package com.android.tutos.tutosandroidblog.model;

import java.util.List;

public class Article {
    private int id;
    private String type;
    private String slug;
    private String url;
    private String status;
    private String title;
    private String titlePlain;
    private String content;
    private String excerpt;
    private String date;
    private String modified;
    private List<Category> categories;
    private List<Tag> tags;
    private Author author;
    private List<Comment> comments;
    private List<Attachment> attachments;
    private int commentCount;
    private String commentStatus;
    private String thumbnail;
    private String thumbnailSize;
    private List<Image> thumbnailImages;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSlug() {
        return slug;
    }

    public String getUrl() {
        return url;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getTitlePlain() {
        return titlePlain;
    }

    public String getContent() {
        return content;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public String getDate() {
        return date;
    }

    public String getModified() {
        return modified;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getThumbnailSize() {
        return thumbnailSize;
    }

    public List<Image> getThumbnailImages() {
        return thumbnailImages;
    }
}
