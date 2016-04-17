package com.android.tutos.tutosandroidblog.model;

import java.util.List;

public class RecentPosts {
    private String status;
    private int count;
    private int countTotal;
    private int pages;
    private List<Article> posts;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCountTotal(int countTotal) {
        this.countTotal = countTotal;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPosts(List<Article> posts) {
        this.posts = posts;
    }

    public String getStatus() {
        return status;
    }

    public int getCount() {
        return count;
    }

    public int getCountTotal() {
        return countTotal;
    }

    public int getPages() {
        return pages;
    }

    public List<Article> getPosts() {
        return posts;
    }
}
