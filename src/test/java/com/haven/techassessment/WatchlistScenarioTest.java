package com.haven.techassessment;

import com.haven.techassessment.model.Result;
import com.haven.techassessment.model.WatchList;
import com.haven.techassessment.model.account.Account;
import com.haven.techassessment.model.account.AccountWatchList;
import com.haven.techassessment.model.auth.Authentication;
import com.haven.techassessment.model.auth.SessionAuthentication;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class WatchlistScenarioTest extends BaseTest {

    /**
     *  Given an authenticated user
     *  When a user has added a media item to their watch list
     *  Then the media item has now been added to their account watchlist
     *
     *  Note that this was designed as a scenario test. AAA is still followed for each step. While it is possible to
     *      create a forced test method order in TestNG, the cookie/session relationship would break between tests
     *      without more overhead. I took the trade-off of having a more complex test. I'd still probably break it up
     *      into individuals methods once complete.
     */
    @Test(groups = "Scenario", enabled = false)
    public void accountWatchlistScenarioTest_setAndVerifyWatchListItem() throws IOException {
        final String theExpanseID = "63639";
        String requestToken = "";
        String sessionId = "";

        requestToken = scenarioStep1_getAuthToken();
        scenarioStep2_authenticateRequestToken();
        sessionId = scenarioStep3_getSession(requestToken);
        scenarioStep4_getAccountID(sessionId);
        scenarioStep5_addShowToWatchList(sessionId, theExpanseID);
        scenarioStep6_verifyShowAddedToWatchList(sessionId, theExpanseID);
    }

    /**
     * Step 1: Get a Token
     *         //https://api.themoviedb.org/3/authentication/token/new?api_key=<apiKey>
     * @return Request Token, required for later steps.
     */
    private String scenarioStep1_getAuthToken() {
        Authentication authentication =
                apiHelper.get("/authentication/token/new", Authentication.class);
        String requestToken = authentication.getRequestToken();
        Assert.assertTrue(!"".equals(requestToken), "Request Token was Null or Empty");
        return requestToken;
    }

    /**
     * Step 2: With that token, verify the authentication
     * https://www.themoviedb.org/authenticate/{REQUEST_TOKEN}
     */
    private void scenarioStep2_authenticateRequestToken() {
        /* TODO:
            More is needed to complete this portion of the test. We need to authenticate, but the API doesn't
            directly allow us to authenticate. There is a Session Cookie that must be resubmitted on the get.
         */
        Assert.fail("Not Implemented");
    }

    /**
     * Step 3: Now that the token has been approved, get a Session
     * https://api.themoviedb.org/3/authentication/session/new?api_key=<apiKey>&request_token=<requestToken>
     * @param requestToken Token to authenticate
     * @return Session ID, required for later steps.
     */
    private String scenarioStep3_getSession(String requestToken) {
        SessionAuthentication sessionAuthentication =
                apiHelper.get("/authentication/session/new", "&request_token=" + requestToken, SessionAuthentication.class);
        String sessionId = sessionAuthentication.getSessionId();
        Assert.assertTrue(sessionAuthentication.isSuccess(), "Session authentication was not successful");
        Assert.assertTrue(!"".equals(sessionId), "Session ID was Null or Empty");
        return sessionId;
    }

    /**
     * We now need to get the account_ID for the user to be used in the watchlist get
     * https://api.themoviedb.org/3/account?api_key=<apiKey>&session_id<sessionID>
     * @param sessionId
     */
    private void scenarioStep4_getAccountID(String sessionId) {
        Account account =
                apiHelper.get("/account", "&session_id=" + sessionId, Account.class);
        int accountId = account.getId();
        Assert.assertNotNull(accountId);
        Assert.assertEquals(accountId > 0, "AccountID was not populated.");
    }

    /**
     * Step 5: Using that account ID, add the TV show to your watch list
     * https://api.themoviedb.org/3/account/51209/watchlist?api_key=<apiKey>&session_id=<sessionID>
     *    BODY of {
     *      "media_type": "tv",
     *      "media_id": 63639,
     *      "watchlist": true
     *     }
     * @param sessionId
     * @param tvIDString TV ID to add to watch list
     */
    private void scenarioStep5_addShowToWatchList(String sessionId, String tvIDString) {
        /*
            TODO: More is required, as we need to submit a body of type application/json
         */
        WatchList watchList =
                apiHelper.post("/account/" + tvIDString + "/watchlist", "&session_id=" + sessionId, WatchList.class);
        boolean watchlist = watchList.isWatchlist();
        Assert.assertTrue(watchlist, "Item was not added to the watch list.");
    }

    /**
     *  Step 6: Get the watch list for this authenticated user and verify that the TV Show has been set to the watch list
     *  https://api.themoviedb.org/3/account/51209/watchlist/tv?api_key=<apiKey>&session_id=<sessionID>
     * @param sessionId
     * @param tvIDString
     */
    private void scenarioStep6_verifyShowAddedToWatchList(String sessionId, String tvIDString) {
        AccountWatchList accountWatchList = apiHelper.get("/account/ " + tvIDString + "/watchlist/tv",
                "&session_id=" + sessionId, AccountWatchList.class);
        List<Result> results = accountWatchList.getResults();
        Assert.assertTrue(results.size() == 1, "There were most items on the watch list than we expected.");
        Result resultItem = results.get(0);
        int resultId = resultItem.getId();
        Assert.assertEquals(resultId, tvIDString, "The wrong item was added to the watch list.");
    }
}