package com.trainings.lesson2rxjava.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.trainings.lesson2rxjava.R;

public class SecondActivity extends AppCompatActivity {


    int subscriberCounter;
    Sender sender;
    //кнопки
    Button subscribeBtn;
    Button unSubscribeBtn;
    Button spamBtn;
    String subscriberName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
        subscriberCounter = 0;
        sender = new Sender();
    }


    //Обработчики нажатия
    public void onSubscribeClick(View view) {
        subscriberName = String.valueOf(subscriberCounter);
        Subscriber subscriber = new Subscriber(subscriberName);
        sender.addObserver(subscriber);
        subscriberCounter++;
    }

    public void onUnsubscribeClick(View view) {

    }

    public void onSpamClick(View view) {
    }

    //инициализирует кнопки
    private void init(){
        subscribeBtn = findViewById(R.id.subscribeBtn);
        unSubscribeBtn = findViewById(R.id.unSubscribeBtn);
        spamBtn = findViewById(R.id.spamBtn);
    }

}