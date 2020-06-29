package com.trainings.lesson2rxjava.second;

import android.util.Log;

public class Subscriber implements Observer {

    public static final String TAG = "Subscriber";
    String name;

    public Subscriber (String name) {
        this.name = name;
    }

    @Override
    public void update() {
        Log.d(TAG, name + " получил спам в потоке "+ Thread.currentThread().getName());
    }
}
