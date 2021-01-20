package com.company;

import java.util.*;

public class MyCollection {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Integer id;

    public MyCollection(Integer id) {
        this.id = id;
    }

    public static void main(String[] args) {
        Map<Integer,MyCollection> myMap = new HashMap<>();
        MyCollection myCollection = new MyCollection(15);
        myMap.put(myCollection.getId(),myCollection);
        System.out.print(myMap);
    }
}
