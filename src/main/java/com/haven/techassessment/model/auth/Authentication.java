package com.haven.techassessment.model.auth;

import com.haven.techassessment.model.TMDbObject;

public class Authentication implements TMDbObject {

    private boolean success;
    private String expires_at;
    private String request_token;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getExpiresAt() {
        return expires_at;
    }

    public void setExpiresAt(String expires_at) {
        this.expires_at = expires_at;
    }

    public String getRequestToken() {
        return request_token;
    }

    public void setRequestToken(String request_token) {
        this.request_token = request_token;
    }

}
