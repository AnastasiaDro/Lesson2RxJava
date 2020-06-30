package com.trainings.lesson2rxjava.second;


import android.util.Log;
import java.util.ArrayList;

public class Sender implements Observable{

    private static final String TAG = "Sender";
    private ArrayList <Observer> observersList;
    private String name;
    private String spamContent;
    public Sender (){
        observersList = new ArrayList<>();
    }

    public void sendSpam() {
        Log.d(TAG, "Отправлен спам");
        notifyObservers();
    }

    public void generateSpam(String name, String spamContent){
        this.name = name;
        this.spamContent = spamContent;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        Log.d(TAG, "addObserver в потоке: " + Thread.currentThread().getName());
        observersList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        Log.d(TAG, "removeObserver в потоке: " + Thread.currentThread().getName());
        observersList.remove(o);
    }

    @Override
    public void removeObserver(int observerNumber){
        Log.d(TAG, "removeObserver в потоке: " + Thread.currentThread().getName());
        observersList.remove(observerNumber);
    }

    @Override
    public void notifyObservers() {
        Log.d(TAG, "notifyObservers в потоке: " + Thread.currentThread().getName());
        Observer observer;
        for (int i = 0; i < observersList.size(); i++) {
            observer = observersList.get(i);
            observer.update(name, spamContent);
        }
    }
}
