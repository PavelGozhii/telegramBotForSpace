package com.pavelgo.model.absense;

/**
 * Created by u7070 on 06.02.2020.
 */
public class Location {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                '}';
    }
}
