package com.haven.techassessment.model;

import java.util.ArrayList;

/**
 * Model for the Configuration Endpoint
 * @see <a href="https://developers.themoviedb.org/3/configuration/get-api-configuration">/configuration</a>
 *
 * Note that I wrote this class and the {@link Images} class. All other model classes I used a generator for.
 *
 */
public class Configuration implements TMDbObject {
    private Images images;
    private ArrayList<String> change_keys;

    //<editor-fold desc="Getters and Setters">
    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public ArrayList<String> getChange_keys() {
        return change_keys;
    }

    public void setChange_keys(ArrayList<String> change_keys) {
        this.change_keys = change_keys;
    }
    //</editor-fold>
}
