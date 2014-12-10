package com.blogspot.tuticfruti.multiportal.model.resource;

import junit.framework.TestCase;

import java.util.ArrayList;

public class LinkTest extends TestCase {

    private static Link sLink;
    public static final String ID = "id";
    public static final String TITLE = "title";

    public void setUp() throws Exception {
        super.setUp();
        sLink = new Link(ID, TITLE);
    }

    public void testGetId() throws Exception {
        assertEquals(ID, sLink.getId());
    }

    public void testSetId() throws Exception {
        sLink.setId("test_set_id");
        assertEquals("test_set_id", sLink.getId());
    }

    public void testGetTitle() throws Exception {
        assertEquals(TITLE, sLink.getTitle());
    }

    public void testSetTitle() throws Exception {
        sLink.setId("test_set_title");
        assertEquals("test_set_title", sLink.getId());
    }

    public void testGetComments() throws Exception {
        assertNotNull(sLink.getComments());
    }

    public void testSetComments() throws Exception {

        ArrayList<Comment> comments = new ArrayList<Comment>(){{
            add(new Comment());
        }};

        comments.add(new Comment());

        sLink.setComments(comments);
        assertEquals(comments, sLink.getComments());
        assertEquals(1, sLink.getComments().size());
    }
}