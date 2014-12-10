package com.blogspot.tuticfruti.multiportal.model.matcher;

import junit.framework.TestCase;

public class UriBuilderTest extends TestCase {

    private static UriBuilder_ sUriBuilder;
    private static UriParams sUriParams;
    private static final String PARAM = "id";
    private static final String PARAM_VALUE = "item_id";
    private static final String URI_TEMPLATE = "http://www.example.com/item/{id}.json";

    public void setUp() throws Exception {

        super.setUp();

        sUriParams = new UriParams();
        sUriParams.put(PARAM, PARAM_VALUE);

        sUriBuilder = new UriBuilder_(URI_TEMPLATE, sUriParams);
    }

    public void testPreconditions() throws Exception {
        assertNotNull(sUriBuilder);
    }

    public void testBuild() throws Exception {
        assertEquals(URI_TEMPLATE.replace("{" + PARAM + "}", PARAM_VALUE), sUriBuilder.build());
    }
}