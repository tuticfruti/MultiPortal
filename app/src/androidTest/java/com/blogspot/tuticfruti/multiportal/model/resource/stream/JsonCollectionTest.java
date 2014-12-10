package com.blogspot.tuticfruti.multiportal.model.resource.stream;

import junit.framework.TestCase;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonCollectionTest extends TestCase {

    private static JSONArray sJSONArray;
    private static JsonResourceCollection sJsonCollection;

    private static final String JSON_OBJECT_VALUE = "{}";
    private static final String JSON_ARRAY_VALUE = "[]";

    public void setUp() throws Exception {

        super.setUp();

        sJSONArray = (new JSONArray())
                .put(new JSONObject(JSON_OBJECT_VALUE))
                .put(new JSONArray(JSON_ARRAY_VALUE));

        sJsonCollection = new JsonResourceCollection(sJSONArray);

    }

    public void testPreconditions() throws Exception {
        assertNotNull(sJSONArray);
        assertNotNull(sJsonCollection);
    }

    public void testLength() throws Exception {
        assertEquals(2, sJsonCollection.length());
    }

    public void testGetObject() throws Exception {
        assertEquals(JSON_OBJECT_VALUE, sJsonCollection.getObject(0).toString());
    }

    public void testGetCollection() throws Exception {
        assertEquals(JSON_ARRAY_VALUE, sJsonCollection.getCollection(1).toString());
    }

    public void testToString() throws Exception {
        assertEquals(sJSONArray.toString(), sJsonCollection.toString());
    }
}