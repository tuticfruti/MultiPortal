package com.blogspot.tuticfruti.multiportal.model.resource.converter;

import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandler;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandlerCollection;

public interface ResourceCollectionOffSet {
    public StreamHandler offSetResource(StreamHandler sh);

    public StreamHandlerCollection offSetResourceCollection(StreamHandler sh);
}
