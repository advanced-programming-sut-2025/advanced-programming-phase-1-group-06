package com.ap.Model;


public abstract class Component {
    protected Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

}
