package com.android.tutos.tutosandroidblog.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tutos.tutosandroidblog.R;
import com.android.tutos.tutosandroidblog.model.Article;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class LatestPostsAdapter extends RecyclerView.Adapter<LatestPostsAdapter.ViewHolder> {
    private List<Article> articles;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView articleTitle;
        public ImageView articleImg;

        public ViewHolder(View v) {
            super(v);
            articleTitle = (TextView) v.findViewById(R.id.article_title);
            articleImg = (ImageView) v.findViewById(R.id.article_img);
        }
    }

    public LatestPostsAdapter(Context context, List<Article> articles) {
        this.articles = articles;
        this.context = context;
    }

    @Override
    public LatestPostsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.articleTitle.setText(Html.fromHtml(article.getTitle()));
        Glide.with(context).load(article.getThumbnail()).placeholder(R.drawable.placeholder).into(holder.articleImg);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
