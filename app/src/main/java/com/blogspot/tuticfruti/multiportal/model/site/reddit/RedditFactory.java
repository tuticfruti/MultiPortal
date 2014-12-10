package com.blogspot.tuticfruti.multiportal.model.site.reddit;

import com.blogspot.tuticfruti.multiportal.model.resource.converter.Converter;
import com.blogspot.tuticfruti.multiportal.model.resource.converter.LinkConverter;
import com.blogspot.tuticfruti.multiportal.model.resource.converter.ResourceCollectionOffSet;
import com.blogspot.tuticfruti.multiportal.model.resource.converter.ResourceOffSet;
import com.blogspot.tuticfruti.multiportal.model.resource.loader.LinkLoader;
import com.blogspot.tuticfruti.multiportal.model.resource.loader.Loader;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.JsonResource;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.JsonResourceCollection;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandler;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandlerCollection;
import com.blogspot.tuticfruti.multiportal.model.site.Site;
import com.blogspot.tuticfruti.multiportal.model.site.SiteAbstractFactory;
import com.blogspot.tuticfruti.multiportal.model.site.reddit.resource.converter.RedditResourceCollectionOffset;
import com.blogspot.tuticfruti.multiportal.model.site.reddit.resource.converter.RedditResourceOffset;

public class RedditFactory extends SiteAbstractFactory {

    private static RedditFactory ourInstance = new RedditFactory();

    public static RedditFactory getInstance() {
        return ourInstance;
    }

    private RedditFactory() {
    }

    @Override
    public Loader createResourceLoader(Site.ResourceType resourceType) {

        Loader returnValue;

        switch (resourceType) {
            case LINK:
                returnValue = new LinkLoader(RedditSite.getInstance());
                break;
            default:
                throw new RuntimeException(new EnumConstantNotPresentException(Site.ResourceType.class, ""));
        }

        return returnValue;
    }

    @Override
    public Converter createResourceConverter(Site.ResourceType resourceType) {

        Converter returnValue;

        switch (resourceType) {
            case LINK:
                returnValue = new LinkConverter(RedditSite.getInstance());
                break;
            default:
                throw new RuntimeException(new EnumConstantNotPresentException(Site.ResourceType.class, ""));
        }

        return returnValue;
    }

    @Override
    public StreamHandler createStreamHandler(byte[] data) {

        StreamHandler returnValue;

        switch (RedditSite.getInstance().getDefaultStreamHandlerType()) {

            case JSON:
                returnValue = new JsonResource(data);
                break;
            default:
                throw new RuntimeException(new EnumConstantNotPresentException(Site.ResourceType.class, ""));
        }

        return returnValue;
    }

    @Override
    public StreamHandlerCollection createStreamHandlerCollection(byte[] data) {

        StreamHandlerCollection returnValue;

        switch (RedditSite.getInstance().getDefaultStreamHandlerType()) {

            case JSON:
                returnValue = new JsonResourceCollection(data);
                break;
            default:
                throw new RuntimeException(new EnumConstantNotPresentException(Site.ResourceType.class, ""));
        }

        return returnValue;
    }

    @Override
    public ResourceOffSet createResourceOffSet(Site.ResourceType resourceType) {
        return new RedditResourceOffset();
    }

    @Override
    public ResourceCollectionOffSet createResourceCollectionOffSet(Site.ResourceType resourceType) {
        return new RedditResourceCollectionOffset();
    }

}

