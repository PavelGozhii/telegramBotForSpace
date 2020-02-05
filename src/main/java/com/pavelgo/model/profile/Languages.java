package com.pavelgo.model.profile;

/**
 * Created by u7070 on 05.02.2020.
 */
public class Languages {

    private Name name;

    private Language language;

    private String languageCode;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public String toString() {
        return "Languages{" +
                "name=" + name +
                ", language=" + language +
                ", languageCode='" + languageCode + '\'' +
                '}';
    }
}
