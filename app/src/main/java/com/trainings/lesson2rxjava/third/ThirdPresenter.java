package com.trainings.lesson2rxjava.third;



import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;


public class ThirdPresenter {
    private static final String TAG = "ThirdPresenter";

    public Observable <String> startCount(){
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d(TAG, "Начали счёт");
                try {
                    int i = 0;
                    while (true) {
                        TimeUnit.SECONDS.sleep(1);
                        String counterStr = "Счёт: " + i;
                        i++;
                        Log.d(TAG, "startCount поток " + Thread.currentThread().getName() + ": " + counterStr);
                        emitter.onNext(counterStr);
                    }
                   // emitter.onComplete();
                } catch (InterruptedException e) {
                    Log.d(TAG, "Надоело считать");
                }
            }
        }).subscribeOn(Schedulers.io());
        return observable;
    }

}
