package com.ap.Model.Item;


public abstract class Component {
    protected Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public Component(){}
}
