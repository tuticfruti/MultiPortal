package com.blogspot.tuticfruti.multiportal.model.matcher;

import junit.framework.TestCase;

public class UriParamsTest extends TestCase {

    private static UriParams sUriParams;
    private static final String PARAM = "param";
    private static final String PARAM_VALUE = "value";

    @Override
    protected void setUp() throws Exception {

        super.setUp();

        sUriParams = new UriParams();
        sUriParams.put(PARAM, PARAM_VALUE);
    }

    public void testPreconditions() throws Exception {
        assertNotNull(sUriParams);
    }

    public void testGet() throws Exception {
        assertEquals(PARAM_VALUE, sUriParams.get(PARAM));
    }

    public void testPut() throws Exception {
        assertEquals(PARAM_VALUE, sUriParams.get(PARAM));
    }

}