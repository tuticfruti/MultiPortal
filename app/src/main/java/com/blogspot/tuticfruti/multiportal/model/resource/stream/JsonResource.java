package com.blogspot.tuticfruti.multiportal.model.resource.stream;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.Charset;

public class JsonResource extends StreamHandler {

    JSONObject mData;

    public JsonResource(byte[] data) {
        try {
            mData = new JSONObject(new String(data, Charset.forName("UTF-8")));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JsonResource(JSONObject jsonObject) {
        mData = jsonObject;
    }

    @Override
    public boolean getBoolean(String key) {
        return mData.optBoolean(key);
    }

    @Override
    public int getInt(String key) {
        return mData.optInt(key);
    }

    @Override
    public long getLong(String key) {
        return mData.optLong(key);
    }

    @Override
    public float getFloat(String key) {
        return (float) mData.optDouble(key);
    }

    @Override
    public double getDouble(String key) {
        return mData.optDouble(key);
    }

    @Override
    public String getString(String key) {
        return mData.optString(key);
    }

    @Override
    public StreamHandler getObject(String key) {
        try {
            return new JsonResource(mData.getJSONObject(key));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StreamHandlerCollection getCollection(String key) {
        try {
            return new JsonResourceCollection(mData.getJSONArray(key));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return mData.toString();
    }

}
