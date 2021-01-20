package com.company;

public abstract class MyClass {
    private String name;

    public MyClass(){}

    public MyClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name+"J";
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract int abstractFun();
}
