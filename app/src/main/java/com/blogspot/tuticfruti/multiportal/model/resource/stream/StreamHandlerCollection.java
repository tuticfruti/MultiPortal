package com.blogspot.tuticfruti.multiportal.model.resource.stream;

public abstract class StreamHandlerCollection {

    public StreamHandlerCollection() {
    }

    public StreamHandlerCollection(byte[] data) {
    }

    public abstract int length();

    public abstract StreamHandler getObject(int index);

    public abstract StreamHandlerCollection getCollection(int index);
}
