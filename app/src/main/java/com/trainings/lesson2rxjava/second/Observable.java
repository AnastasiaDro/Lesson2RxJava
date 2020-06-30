package com.trainings.lesson2rxjava.second;

public interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void removeObserver(int observerNumber);
    void notifyObservers();
}
