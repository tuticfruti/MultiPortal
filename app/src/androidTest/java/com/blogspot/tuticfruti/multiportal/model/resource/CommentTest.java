package com.blogspot.tuticfruti.multiportal.model.resource;

import junit.framework.TestCase;

public class CommentTest extends TestCase {

    private static Comment sComment;
    public static final String ID = "id";
    public static final String TITLE = "title";

    public void setUp() throws Exception {
        super.setUp();
        sComment = new Comment("id", "title");
    }

    public void testPreconditions() throws  Exception {
        assertNotNull(sComment);
    }

    public void testGetId() throws Exception {
        assertEquals(ID, sComment.getId());
    }

    public void testSetId() throws Exception {
        sComment.setId("test_set_id");
        assertEquals("test_set_id", sComment.getId());
    }

    public void testGetTitle() throws Exception {
        assertEquals(TITLE, sComment.getTitle());
    }

    public void testSetTitle() throws Exception {
        sComment.setTitle("test_set_title");
        assertEquals("test_set_title", sComment.getTitle());
    }
}