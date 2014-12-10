package com.blogspot.tuticfruti.multiportal.model.resource.stream;

import org.json.JSONArray;
import org.json.JSONException;

public class JsonResourceCollection extends StreamHandlerCollection {

    private JSONArray mJsonArray;

    public JsonResourceCollection(byte[] data) {
        try {
            mJsonArray = new JSONArray(new String(data));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    protected JsonResourceCollection(JSONArray jsonArray) {
        mJsonArray = jsonArray;
    }

    @Override
    public int length() {
        return mJsonArray.length();
    }

    @Override
    public StreamHandler getObject(int index) {
        try {
            return new JsonResource(mJsonArray.getJSONObject(index));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StreamHandlerCollection getCollection(int index) {
        try {
            return new JsonResourceCollection(mJsonArray.getJSONArray(index));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return mJsonArray.toString();
    }
}
