package com.trainings.lesson2rxjava.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.trainings.lesson2rxjava.R;

import java.util.concurrent.TimeUnit;

public class FirstActivity extends AppCompatActivity {

private static final String ASYNC_TAG = "AsyncTask";
private static final String ONCLICK_TAG = "ButtonClick метод";

private MyAsynkTask myAsynkTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void onTaskBtnClick(View view) {
        myAsynkTask = new MyAsynkTask();
        myAsynkTask.execute();
        Log.d(ONCLICK_TAG, "Метод завершен, нажатие на кнопку обработано потоком " + Thread.currentThread().getName());
    }


    private static class MyAsynkTask extends AsyncTask <Void, Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 1; i < 6; i++){
                    TimeUnit.SECONDS.sleep(1);
                    Log.d(ASYNC_TAG, "Это сообщение N " + i + " имя потока: " +Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }



}