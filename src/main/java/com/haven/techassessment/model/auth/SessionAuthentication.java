package com.haven.techassessment.model.auth;

import com.haven.techassessment.model.TMDbObject;

public class SessionAuthentication implements TMDbObject {
    private boolean success;
    private String session_id;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getSessionId() {
        return session_id;
    }

    public void setSessionId(String sessionId) {
        this.session_id = sessionId;
    }
}
