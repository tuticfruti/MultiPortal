package com.blogspot.tuticfruti.multiportal.model.site.reddit.resource.converter;

import com.blogspot.tuticfruti.multiportal.model.resource.converter.ResourceCollectionOffSet;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandler;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandlerCollection;

public class RedditResourceCollectionOffset implements ResourceCollectionOffSet {
    @Override
    public StreamHandler offSetResource(StreamHandler sh) {
        return sh.getObject("data");
    }

    @Override
    public StreamHandlerCollection offSetResourceCollection(StreamHandler sh) {
        return sh.getObject("data").getCollection("children");
    }
}
