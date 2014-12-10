package com.blogspot.tuticfruti.multiportal.model.site.reddit.resource.converter;

import com.blogspot.tuticfruti.multiportal.model.resource.converter.ResourceOffSet;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandler;

public class RedditResourceOffset implements ResourceOffSet {
    @Override
    public StreamHandler offSetResource(StreamHandler sh) {
        return sh.getObject("data").getCollection("children").getObject(0).getObject("data");
    }
}
