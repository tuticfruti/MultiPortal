package com.blogspot.tuticfruti.multiportal.model.resource;

import java.util.ArrayList;
import java.util.Collection;

public class Link extends Resource {

    protected String mId;
    protected String mTitle;
    protected String mCategoryId;
    protected Collection<Comment> comments;

    public Link() {
    }

    public Link(String id, String title) {
        mId = id;
        mTitle = title;
        comments = new ArrayList<>();
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
