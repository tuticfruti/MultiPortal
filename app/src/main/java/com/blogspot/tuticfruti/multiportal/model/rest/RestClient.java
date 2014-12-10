package com.blogspot.tuticfruti.multiportal.model.rest;

public abstract class RestClient {

    protected abstract Object getRequestParams(RequestParams requestParams);

    protected abstract Object getResponseHandler(ResponseHandler responseHandler);

    public abstract void get(String uri, RequestParams requestParams, ResponseHandler responseHandler);
}
