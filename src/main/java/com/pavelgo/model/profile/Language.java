package com.pavelgo.model.profile;

/**
 * Created by u7070 on 05.02.2020.
 */
public class Language {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id='" + id + '\'' +
                '}';
    }
}
