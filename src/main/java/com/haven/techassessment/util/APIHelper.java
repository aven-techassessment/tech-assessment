package com.haven.techassessment.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.haven.techassessment.model.TMDbObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/*
    Note that this class doesn't handle nearly everything it would need. append_to_response, file exports, etc..
 */
/**
 * APIHelper class to assist with making API calls easy to do from each test.
 */
public class APIHelper {

    private static final String API_KEY;
    private static final String BASE_URL = "https://api.themoviedb.org/3";

    static {
        final String propertyName = "tmdb.apiKey";
        API_KEY = System.getProperty(propertyName);
    }

    public APIHelper() {
    }

    /**
     * Get the raw response string
     */
    public static String get(String requestString) {
        return getJSONResults(requestString, HTTPMethod.GET);
    }

    /**
     * Perform an API get and returned a populated Model object
     *
     * @param requestString The HTTP Request to submit
     * @param modelObject The Type of Object related to this API Request
     * @param <T> While not required, enforced as a {@link TMDbObject} for compile time checking.
     * @return A populated Model object matching a {@link TMDbObject}
     */
    public static <T extends TMDbObject> T get(String requestString, Class<T> modelObject) {
        String jsonString = getJSONResults(requestString, HTTPMethod.GET);

        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, modelObject);
    }


    public static <T extends TMDbObject> T get(String requestString, String additionalParams, Class<T> modelObject) {
        String jsonString = getJSONResults(requestString, HTTPMethod.GET, additionalParams);

        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, modelObject);
    }

    public static <T extends TMDbObject> T post(String requestString, Class<T> modelObject) {
        String jsonString = getJSONResults(requestString, HTTPMethod.POST);

        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, modelObject);
    }

    public static <T extends TMDbObject> T post(String requestString, String additionalParams, Class<T> modelObject) {
        String jsonString = getJSONResults(requestString, HTTPMethod.POST, additionalParams);

        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, modelObject);
    }

    private static String getJSONResults(String requestString, HTTPMethod method) {
        try {
            URL url = new URL(BASE_URL + requestString + "?api_key=" + API_KEY);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(method.toString());
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream()));

            return bufferedReader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getJSONResults(String requestString, HTTPMethod method, String additionalParams){
        try {
            URL url = new URL(BASE_URL + requestString + "?api_key=" + API_KEY + additionalParams);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(method.toString());
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream()));

            return bufferedReader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
