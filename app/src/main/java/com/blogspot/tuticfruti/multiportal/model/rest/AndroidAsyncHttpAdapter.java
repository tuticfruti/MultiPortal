package com.blogspot.tuticfruti.multiportal.model.rest;

import com.blogspot.tuticfruti.multiportal.model.lib.AndroidAsyncHttp;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.util.Map;

public class AndroidAsyncHttpAdapter extends RestClient {

    private static AndroidAsyncHttpAdapter ourInstance = new AndroidAsyncHttpAdapter();

    public static AndroidAsyncHttpAdapter getInstance() {
        return ourInstance;
    }

    @Override
    protected Object getRequestParams(RequestParams requestParams) {

        com.loopj.android.http.RequestParams remoteRequestParams = new com.loopj.android.http.RequestParams();

        for (Map.Entry<String, String> param : requestParams) {
            remoteRequestParams.put(param.getKey(), param.getValue());
        }

        return remoteRequestParams;
    }

    @Override
    protected Object getResponseHandler(final ResponseHandler responseHandler) {

        return new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                responseHandler.onSuccess(statusCode, headers, responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                responseHandler.onFailure(statusCode, headers, responseBody, error);
            }
        };
    }

    @Override
    public void get(String uri, RequestParams requestParams, ResponseHandler responseHandler) {
        AndroidAsyncHttp.get(
                uri,
                (com.loopj.android.http.RequestParams) getRequestParams(requestParams),
                (AsyncHttpResponseHandler) getResponseHandler(responseHandler)
        );
    }
}
