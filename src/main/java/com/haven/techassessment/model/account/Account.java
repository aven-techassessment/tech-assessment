package com.haven.techassessment.model.account;

import com.haven.techassessment.model.TMDbObject;

public class Account implements TMDbObject {

    private Avatar avatar;
    private int id;
    private String iso_639_1;
    private String iso_3166_1;
    private String name;
    private boolean include_adult;
    private String username;

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIso6391() {
        return iso_639_1;
    }

    public void setIso6391(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getIso31661() {
        return iso_3166_1;
    }

    public void setIso31661(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIncludeAdult() {
        return include_adult;
    }

    public void setIncludeAdult(boolean include_adult) {
        this.include_adult = include_adult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}