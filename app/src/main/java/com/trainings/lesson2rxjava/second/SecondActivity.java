package com.trainings.lesson2rxjava.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.trainings.lesson2rxjava.R;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    int subscriberCounter = 0;
    Sender sender = new Sender();
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
        Subscriber subscriber = new Subscriber("Подписчик #"+subscriberCounter);//кнопки
        Log.d(TAG, "Создан подписчик #" + subscriberCounter);
        subscriberCounter++;
        sender.addObserver(subscriber);
    }

    public void onUnsubscribeClick(View view) {
        try {
            sender.removeObserver(subscriberCounter-1);
            subscriberCounter--;
        } catch (ArrayIndexOutOfBoundsException e){
            Toast.makeText(this, "Подписчики кончились, удалять некого!", Toast.LENGTH_LONG).show();
            subscriberCounter = 0;
            e.getStackTrace();
        }
    }

    public void onSpamClick(View view) {
        sender.generateSpam("Это спам", "О-хо-хо-хо");
    }

    //инициализирует кнопки
    private void init(){
        subscribeBtn = findViewById(R.id.subscribeBtn);
        unSubscribeBtn = findViewById(R.id.unSubscribeBtn);
        spamBtn = findViewById(R.id.spamBtn);
    }

}