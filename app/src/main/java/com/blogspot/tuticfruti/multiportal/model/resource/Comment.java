package com.blogspot.tuticfruti.multiportal.model.resource;

public class Comment extends Resource {

    private String mId;
    private String mTitle;

    public Comment() {
    }

    public Comment(String id, String title) {
        mId = id;
        mTitle = title;
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
}
