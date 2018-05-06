package com.haven.techassessment;

import org.testng.annotations.Test;

public class StubbedTests {

    @Test(enabled = false)
    public void dailyFileExport_verifyChangeStructure() {
        /*
          Verify that the structure of the daily file exports has not changed. If it has changed, that may be OK, but we
          need to verify that our system can handle the changes.

          Example: On 28 April 2017, information about Popularity was added to certain dumps. The expected results have
          changes, so we need to verify if there is any modification required on our side to capture the updated data.
         */
    }

    @Test(enabled = false)
    public void timezones_supportedTimezones_changeUpdateVerification() {
        /*
          Verify that if there as been a change to the list of supported timezones, that we understand and process this
          change.

          Example: Venezuela changed their timezone on 1 May 2016 by 30 mins. The name didn't change, only the offset
         */
    }

    /**
     * @see ConfigurationCacheManager
     */
    @Test(enabled = false)
    public void configuration_dailyCache_updatesOnceDaily() {
        /*
          I have written a utility to ensure we have an up-to-date cache. We should verify that this cache has been
          updated daily. We also would want to verify the structure and change-set of that cache. This is important
          for images more than anything else. The information in the cache assists us in building proper images URLs.
          We need to verify the data in order to construct valid image tags.
         */
    }

    @Test(enabled = false)
    public void movie_rejectsNonStandardIDs_returns404() {
        /*
          We should take wonky data and throw it at the API to verify that a 404 is still returned.

          Boundary Analysis, Non-standard UTF characters, zero-byte/null characters, data overload, multi-byte
            non-standard characters (which, depending on the language may be accepted), etc..
         */
    }

    @Test(enabled = false)
    public void authenticate_redirectTo_returns404OnMaliciousURLs() {
        /*
          The authenticate endpoint allows use of the "redirect_to" parameter for 3rd party developers. Even though we
          can't control another redirecting to a valid malicious website, we should drop obvious attempts to session
          hijack, provide reflective XSS, or other security concerns.
         */
    }

    /*
        Note that this will turn into many different tests
     */
    @Test(enabled = false)
    public void endpoint_validateEndpointStructure() {
        /*
          While TMDb is a well known API, there have been cases where large APIs have been required to make a breaking
          change to a stable version without a new re-release. This does break a set contract, but we don't want to take
          the risk of this break.

          This series of tests would take all of our Model objects, and verify that intended structure has not changed.
          Most other tests would start breaking if this happened, and this test would provided us information as to
          _why_ those tests failed. See: A more pointed effort to reduce the amount of context and debugging required.
         */
    }

    @Test(enabled = false)
    public void discover_queryLanguage_verifyKnownQueryItems() {
        /*
         The /discover/movie|tv endpoints can be pretty complex. There is a light weight query language being used, as
         well as the ability to check movies with certain certifications. This test should verify the query language
         works as expected.

         For an integration test, we should verify that items from our daily download of Certifications can be used
         within the discovery endpoint.

         The discovery API is documented here: https://www.themoviedb.org/documentation/api/discover
         */
    }

    /**
     *  ***WARNING*** ***WARNING*** ***WARNING*** ***WARNING*** ***WARNING*** ***WARNING*** ***WARNING*** ***WARNING***
     *
     *      This test is going to verify that adult items are not returned by search results. In order to make this
     *      verification, we must include the name of one expected item. We have included a name that isn't offensive
     *      in name alone, but please understand that this item very much of the adult nature.
     *
     *      If for some reason this verification fails, it means that an item item was returned by the search, and you
     *      must be extra cautious when handling the data.
     *
     *      It is important that we verify this functionality works for our end-users, no matter how sensitive of a
     *      topic that this can be for some users.
     *
     *  ***WARNING*** ***WARNING*** ***WARNING*** ***WARNING*** ***WARNING*** ***WARNING*** ***WARNING*** ***WARNING***
     */
    @Test(enabled = false)
    public void search_includeAdultFlagFalse_adultItemsNotInResults() {
        /*
          Verify that you when you perform a search including the "include_adult=false" flag, adult items are not
          returned. While this test may be uncomfortable for some, it is important that we do everything in our power to
          ensure this functionality works for our users. I have appropriately flagged the test in a ways that ensures
          internal users understand the purpose of the test.
         */
    }
}
