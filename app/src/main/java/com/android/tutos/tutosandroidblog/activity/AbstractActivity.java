package com.android.tutos.tutosandroidblog.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.android.tutos.tutosandroidblog.R;
import com.android.tutos.tutosandroidblog.api.APIProvider;
import com.android.tutos.tutosandroidblog.api.APIServices;
import rx.Subscription;

public abstract class AbstractActivity extends AppCompatActivity {

    protected Subscription subscription;
    protected APIServices service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (null != getSupportActionBar()) {
            getSupportActionBar().setTitle(getScreenTitle());
        }

        service = APIProvider.provideAPI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!subscription.isUnsubscribed())
            subscription.unsubscribe();
    }

    protected abstract String getScreenTitle();

    protected abstract int getView();
}
