package com.trainings.lesson2rxjava.third;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.trainings.lesson2rxjava.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";

    private ThirdPresenter thirdP;
    private Observable <String> observable;
    private Disposable disposable;
    private TextView counterTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        counterTV = findViewById(R.id.counterTV);
        thirdP = new ThirdPresenter();
      //  observable = thirdP.
    }

    public void onStartCountClick(View view) {
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
                ThirdActivity.this.disposable = d;
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + s);
                counterTV.setText(s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
        Log.d(TAG, "Метод onStartCountClick закончился в потоке "+Thread.currentThread().getName());
    }


    public void onStopCountClick(View view) {
        disposable.dispose();
    }


}