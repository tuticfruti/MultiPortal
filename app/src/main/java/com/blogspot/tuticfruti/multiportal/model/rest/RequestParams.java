package com.blogspot.tuticfruti.multiportal.model.rest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RequestParams implements Iterable<Map.Entry<String, String>> {

    private Map<String, String> mRequestParams;

    public RequestParams() {
        mRequestParams = new HashMap<>();
    }

    public String get(String key) {
        return mRequestParams.get(key);
    }

    public void put(String key, String value) {
        mRequestParams.put(key, value);
    }

    @Override
    public Iterator<Map.Entry<String, String>> iterator() {
        return mRequestParams.entrySet().iterator();
    }
}
