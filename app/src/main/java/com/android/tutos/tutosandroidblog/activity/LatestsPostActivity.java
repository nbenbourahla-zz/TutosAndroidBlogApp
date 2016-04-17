package com.android.tutos.tutosandroidblog.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.View;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.android.tutos.tutosandroidblog.R;
import com.android.tutos.tutosandroidblog.adapters.LatestPostsAdapter;
import com.android.tutos.tutosandroidblog.api.APIProvider;
import com.android.tutos.tutosandroidblog.api.APIServices;
import com.android.tutos.tutosandroidblog.model.Article;
import com.android.tutos.tutosandroidblog.model.RecentPosts;

import java.util.List;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LatestsPostActivity extends AbstractActivity {

    public static final String TAG = "LatestsPostActivity";
    @Bind(R.id.my_recycler_view) RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Bind(R.id.content_loader) ContentLoadingProgressBar mContentLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        loadRecentArticles();
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.latests_post_act_title);
    }

    @Override
    protected int getView() {
        return R.layout.activity_main_drawer;
    }

    private void loadRecentArticles() {
        mContentLoader.show();
        Observable<RecentPosts> call = service.loadRecentArticles();
        this.subscription = call.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<RecentPosts>() {
            @Override
            public void onCompleted() {
                mContentLoader.hide();
                mRecyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(LatestsPostActivity.this, R.string.loading_error, Toast.LENGTH_SHORT).show();
                Log.e(TAG, getString(R.string.loading_error), e);
            }

            @Override
            public void onNext(RecentPosts recentPosts) {
                List<Article> articles = recentPosts.getPosts();
                mAdapter = new LatestPostsAdapter(LatestsPostActivity.this, articles);
                mRecyclerView.setAdapter(mAdapter);
            }
        });
    }
}
