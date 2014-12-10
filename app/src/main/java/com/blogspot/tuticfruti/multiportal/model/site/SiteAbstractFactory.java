package com.blogspot.tuticfruti.multiportal.model.site;

import com.blogspot.tuticfruti.multiportal.model.resource.converter.Converter;
import com.blogspot.tuticfruti.multiportal.model.resource.converter.ResourceCollectionOffSet;
import com.blogspot.tuticfruti.multiportal.model.resource.converter.ResourceOffSet;
import com.blogspot.tuticfruti.multiportal.model.resource.loader.Loader;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandler;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandlerCollection;

public abstract class SiteAbstractFactory<T> {

    public abstract Loader createResourceLoader(Site.ResourceType resourceType);

    public abstract Converter createResourceConverter(Site.ResourceType resourceType);

    public abstract StreamHandler createStreamHandler(byte[] data);

    public abstract StreamHandlerCollection createStreamHandlerCollection(byte[] data);

    public abstract ResourceOffSet createResourceOffSet(Site.ResourceType resourceType);

    public abstract ResourceCollectionOffSet createResourceCollectionOffSet(Site.ResourceType resourceType);

}
