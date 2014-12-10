package com.blogspot.tuticfruti.multiportal.model.resource.stream;

public abstract class StreamHandler {

    public static enum Type {
        JSON,
        XML
    }

    public StreamHandler() {
    }

    public StreamHandler(byte[] data) {
    }

    public abstract boolean getBoolean(String key);

    public abstract int getInt(String key);

    public abstract long getLong(String key);

    public abstract float getFloat(String key);

    public abstract double getDouble(String key);

    public abstract String getString(String key);

    public abstract StreamHandler getObject(String key);

    public abstract StreamHandlerCollection getCollection(String key);
}
