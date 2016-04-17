package com.android.tutos.tutosandroidblog.api;

import com.android.tutos.tutosandroidblog.model.Article;
import com.android.tutos.tutosandroidblog.model.RecentPosts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

public interface APIServices {

    @GET("/?json=get_recent_posts")
    Observable<RecentPosts> loadRecentArticles();

}
