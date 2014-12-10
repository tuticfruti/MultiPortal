package com.blogspot.tuticfruti.multiportal.model.rest;

import org.apache.http.Header;

public interface ResponseHandler {
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody);

    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error);
}
