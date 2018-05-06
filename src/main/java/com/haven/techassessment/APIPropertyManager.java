package com.haven.techassessment;

/*
    There are many other TMDb property objects I could have seen being managed by this object
 */
/**
 * Singleton object to hold API configuration.
 */
public class APIPropertyManager {
    private static APIPropertyManager instance;

    private String apiKey;
    private String baseAPIUrl;

    private APIPropertyManager() {
        final String propertyName = "tmdb.apiKey";
        apiKey = System.getProperty(propertyName);
        baseAPIUrl = "https://api.themoviedb.org";
    }

    public static APIPropertyManager getInstance() {
        if(instance == null) {
            instance = new APIPropertyManager();
        }
        return instance;
    }

    public String getAPIKey() {
        return apiKey;
    }

    public String getBaseAPIUrl() {
        return baseAPIUrl;
    }
}
