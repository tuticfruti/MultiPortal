package com.blogspot.tuticfruti.multiportal.model.resource.stream;

import junit.framework.TestCase;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonObjectTest extends TestCase {

    private static JSONObject sJSONObject;
    private static JsonResource sJsonObject;

    private static final boolean BOOLEAN_VALUE = true;
    private static final int INT_VALUE = 1024;
    private static final long LONG_VALUE = (long) Math.pow(2, 32);
    private static final double FLOAT_VALUE = .1024;
    private static final double DOUBLE_VALUE = .1024;
    private static final String STRING_VALUE = "Android";
    private static final String JSON_OBJECT_VALUE = "{}";
    private static final String JSON_ARRAY_VALUE = "[0,1]";

    public void setUp() throws Exception {

        super.setUp();

        sJSONObject = (new JSONObject())
                .put("BOOLEAN_VALUE", BOOLEAN_VALUE)
                .put("INT_VALUE", INT_VALUE)
                .put("LONG_VALUE", LONG_VALUE)
                .put("DOUBLE_VALUE", DOUBLE_VALUE)
                .put("STRING_VALUE", STRING_VALUE)
                .put("JSON_OBJECT_VALUE", new JSONObject(JSON_OBJECT_VALUE))
                .put("JSON_ARRAY_VALUE", new JSONArray(JSON_ARRAY_VALUE));


        sJsonObject = new JsonResource(sJSONObject.toString().getBytes());
    }

    public void testPreconditions() throws Exception {
        assertNotNull(sJSONObject);
        assertNotNull(sJsonObject);
    }

    public void testGetBoolean() throws Exception {
        assertEquals(BOOLEAN_VALUE, sJsonObject.getBoolean("BOOLEAN_VALUE"));
    }

    public void testGetInt() throws Exception {
        assertEquals(INT_VALUE, sJsonObject.getInt("INT_VALUE"));
    }

    public void testGetLong() throws Exception {
        assertEquals(LONG_VALUE, sJsonObject.getLong("LONG_VALUE"));
    }

    public void testGetFloat() throws Exception {
        assertEquals(FLOAT_VALUE, sJsonObject.getDouble("DOUBLE_VALUE"));
    }

    public void testGetDouble() throws Exception {
        assertEquals(DOUBLE_VALUE, sJsonObject.getDouble("DOUBLE_VALUE"));
    }

    public void testGetString() throws Exception {
        assertEquals(STRING_VALUE, sJsonObject.getString("STRING_VALUE"));
    }

    public void testGetObject() throws Exception {
        assertEquals(JSON_OBJECT_VALUE.toString(), sJsonObject.getObject("JSON_OBJECT_VALUE").toString());
    }

    public void testGetCollection() throws Exception {
        assertEquals(JSON_ARRAY_VALUE.toString(), sJsonObject.getCollection("JSON_ARRAY_VALUE").toString());
    }

    public void testToString() throws Exception {
        assertEquals(sJSONObject.toString(), sJsonObject.toString());
    }
}