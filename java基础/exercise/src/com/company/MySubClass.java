package com.company;

public class MySubClass extends MyClass {
    public static void main(String[] args){
        MySubClass mySubClass = new MySubClass();
        mySubClass.setName("I");
        System.out.println(((MyClass)mySubClass).getName());


    }

    @Override
    public int abstractFun() {
        return 0;
    }

    @Override
    public String getName() {
        return "K";
    }
}
