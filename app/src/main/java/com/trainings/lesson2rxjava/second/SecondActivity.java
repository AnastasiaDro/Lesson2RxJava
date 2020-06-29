package com.trainings.lesson2rxjava.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.trainings.lesson2rxjava.R;

public class SecondActivity extends AppCompatActivity {

    //кнопки
    Button subscribeBtn;
    Button unSubscribeBtn;
    Button spamBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
    }


    //Обработчики нажатия
    public void onSubscribeClick(View view) {
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