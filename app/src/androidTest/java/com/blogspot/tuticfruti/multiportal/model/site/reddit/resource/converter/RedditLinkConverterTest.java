package com.blogspot.tuticfruti.multiportal.model.site.reddit.resource.converter;

import com.blogspot.tuticfruti.multiportal.model.resource.converter.ResourceConverter;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class RedditLinkConverterTest extends TestCase {

    private static ClassLoader sClassLoader;
    private static ResourceConverter sConverter;
    public static byte[] sStream;

    public RedditLinkConverterTest() {

        try {
            sClassLoader = getClass().getClassLoader();
            File file = new File(sClassLoader.getResource("reddit/by_id__t3_2nu3zp.json").getFile());
            FileInputStream fis = new FileInputStream(file);
            sStream = new byte[(int) file.length()];
            fis.read();
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUp() throws Exception {

        super.setUp();

        sConverter = new RedditLinkConverter_();
    }

    public void testPreconditions() throws Exception {
        assertNotNull(sConverter);
        assertTrue(sStream.length > 0);
    }

    public void testOffSet() throws Exception {

    }

    public void testOffSetCollection() throws Exception {

    }

    public void testToResource() throws Exception {

    }

    public void testToResourceCollection() throws Exception {

    }
}