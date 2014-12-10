package com.blogspot.tuticfruti.multiportal.model.site;

import java.util.EnumMap;

public class Matcher<T extends Enum<T>> {

    private EnumMap<T, String> mMap;

    public Matcher(EnumMap<T, String> map) {
        mMap = map;
    }

    public String match(Enum<T> key) {
        return mMap.get(key);
    }
}
