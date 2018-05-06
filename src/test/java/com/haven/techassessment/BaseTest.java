package com.haven.techassessment;

import com.haven.techassessment.util.APIHelper;

public class BaseTest {
    protected String apiKey;
    protected String baseAPIUrl;

    protected APIHelper apiHelper;

    public BaseTest() {
        APIPropertyManager instance = APIPropertyManager.getInstance();
        this.apiKey = instance.getAPIKey();
        this.baseAPIUrl = instance.getBaseAPIUrl();

        //API Helper
        apiHelper = new APIHelper();
    }
}
