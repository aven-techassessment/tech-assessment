package com.haven.techassessment.listener;

import com.haven.techassessment.ConfigurationCacheManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * This SuiteListener was going to do more for holding configuration for our test suite, but I think it was slightly
 * over engineered, so I undid it. In general, I really like keeping the configuration away from the class hierarchy of
 * within test suites
 */
public class SuiteListener implements ISuiteListener {
    private static final Logger LOG = LogManager.getLogger(SuiteListener.class);

    @Override
    public void onStart(ISuite iSuite) {
        LOG.info("Suite Start");
        ConfigurationCacheManager cacheManager = new ConfigurationCacheManager();
        cacheManager.verifyOrBustCache();
    }

    @Override
    public void onFinish(ISuite iSuite) {
        LOG.info("Suite Finish");
    }
}
