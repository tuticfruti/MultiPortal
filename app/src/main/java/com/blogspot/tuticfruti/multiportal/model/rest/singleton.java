package com.blogspot.tuticfruti.multiportal.model.rest;

/**
 * Created by padmoral on 7/12/14.
 */
public class singleton {
    private static singleton ourInstance = new singleton();

    public static singleton getInstance() {
        return ourInstance;
    }

    private singleton() {
    }
}
