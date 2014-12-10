package com.blogspot.tuticfruti.multiportal.model.resource;

import java.lang.reflect.Field;

public abstract class Resource {
    @Override
    public String toString() {

        try {

            String returnValue = "";

            for (Field field : this.getClass().getDeclaredFields()) {
                returnValue += field.getName() + "=" + field.get(this) + " ";
            }

            return returnValue;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {

        try {

            if (o == null) return false;
            if (o == this) return true;
            if (!(this.getClass().getCanonicalName().equals(o.getClass().getCanonicalName())))
                return false;

            for (Field field : this.getClass().getDeclaredFields()) {
                if (!field.get(this).equals(field.get(o))) return false;
            }

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
