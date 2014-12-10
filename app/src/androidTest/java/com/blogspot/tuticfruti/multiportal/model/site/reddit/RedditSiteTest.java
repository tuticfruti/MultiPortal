package com.blogspot.tuticfruti.multiportal.model.site.reddit;

import com.blogspot.tuticfruti.multiportal.model.resource.ResourceType;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandlerType;

import junit.framework.TestCase;

public class RedditSiteTest extends TestCase {

    private static final String BASE_URI = "http://www.reddit.com/";
    private RedditSite mRedditSite;

    @Override
    protected void setUp() throws Exception {

        super.setUp();

        mRedditSite = RedditSite.getInstance();
    }

    public void testGetInstance() throws Exception {
        assertNotNull(mRedditSite);
        assertEquals(mRedditSite.getClass(), RedditSite.class);
    }

    public void testGetBaseUri() throws Exception {
        assertEquals(BASE_URI, mRedditSite.getBaseUri());
    }

    public void testGetDefaultStreamHandler() throws Exception {
        assertEquals(StreamHandlerType.JSON, mRedditSite.getDefaultStreamHandler());
    }

    public void testGetUriMatcher() throws Exception {
        for(ResourceType resourceType : ResourceType.values()) {
            assertNotNull(mRedditSite.getUriMatcher(resourceType));
        }
    }

}