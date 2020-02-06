package com.pavelgo.model.absense;

/**
 * Created by u7070 on 06.02.2020.
 */
public class Reason {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Reason{" +
                "name='" + name + '\'' +
                '}';
    }
}
