package com.haven.techassessment.util;

/*
 * I would typically use a library here. Implementing for the sake of the assessment.
 */
/**
 * Standard HTTP Methods
 */
public enum HTTPMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    private String value;

    HTTPMethod(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
