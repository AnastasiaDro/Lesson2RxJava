package com.trainings.lesson2rxjava.second;


import java.util.ArrayList;

public class Sender implements Observable{

    ArrayList <Observer> observersList;

    public Sender (){
        observersList = new ArrayList<>();
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
