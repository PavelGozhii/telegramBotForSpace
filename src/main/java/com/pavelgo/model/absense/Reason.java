package com.pavelgo.model.absense;

/**
 * Created by u7070 on 05.02.2020.
 */
public class Reason {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reason{" +
                "id='" + id + '\'' +
                '}';
    }
}
