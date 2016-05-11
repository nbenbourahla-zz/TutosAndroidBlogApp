package com.android.tutos.tutosandroidblog.adapters;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxSchedulers<T> {

    private Observable schedulersTransformer;

    public <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                if (null == schedulersTransformer) {
                    schedulersTransformer = observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
                }
                return schedulersTransformer;
            }
        };
    }
}
