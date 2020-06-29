package com.trainings.lesson2rxjava.second;


import android.util.Log;

import java.util.ArrayList;

public class Sender implements Observable{

    private static final String TAG = "Sender";

    ArrayList <Observer> observersList;

    public Sender (){
        observersList = new ArrayList<>();
    }

    public void sendSpam() {
        Log.d(TAG, "Отправлен спам");
        notifyObservers();
    }



    @Override
    public void addObserver(Observer o) {
        observersList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observersList.remove(o);
    }

    @Override
    public void notifyObservers() {
        Observer observer;
        for (int i = 0; i < observersList.size(); i++) {
            observer = observersList.get(i);
            observer.update();
        }
    }
}
