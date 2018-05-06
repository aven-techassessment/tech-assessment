package com.haven.techassessment;

import com.haven.techassessment.listener.SuiteListener;
import com.haven.techassessment.util.APIHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
    Note that this class really is mostly pointless in the end. I had planned on writing a more complex test against
    configurations for the image construction URL, but backed off of that path for time. The class still works! It just
    doesn't add much value currently other than showing some other types of written code.
 */
/**
 * Download a version of TMDb /configuration endpoint and store a version with a date stamp
 *  The API Suggests to "check for updates every few days." - This will ensure the /configuration endpoint is polled and
 *  cached once a day.
 */
public class ConfigurationCacheManager {
    private static final Logger LOG = LogManager.getLogger(SuiteListener.class);

    private String resourcesPath;
    private String todayFormat;
    private String fileName;

    public ConfigurationCacheManager() {
        final String relativeResourcePath = "src\\main\\resources\\tmdbconfig";
        resourcesPath = new File(relativeResourcePath).getAbsolutePath();

        todayFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        fileName = new StringBuilder()
                .append("\\config-" + todayFormat)
                .append(".json").toString();

        cleanConfigResources();
    }

    /**
     * Clean up the configuration directory of all files that do not contain today date.
     */
    private void cleanConfigResources() {
        Arrays.stream(new File(resourcesPath)
                .listFiles(file -> !file.getName().contains(todayFormat)))
                .forEach(File::delete);
    }

    /**
     * Verify that we have a current configuration cache version. If not, fetch a copy. If we have old versions,
     *  clean them up.
     *
     *  Skip if a config file from today already exists. Only write in the case where it does not exist.
     */
    public void verifyOrBustCache() {
        if(!isConfigFileFromTodayPresent()) {
            String rawJson = APIHelper.get("/configuration");
            writeConfigFile(rawJson);
        }
    }

    /**
     * Check if a config file from today has already been generated. This allows us to exit early if already fetched
     *  and cached
     *
     * @return boolean Does config file from today exist
     */
    private boolean isConfigFileFromTodayPresent() {
        File configFile = new File(resourcesPath + fileName);
        return configFile.exists();
    }

    /**
     *
     * @param jsonResponseString JSON Response from the configuration API endpoint
     */
    private void writeConfigFile(String jsonResponseString) {
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(resourcesPath + fileName), StandardCharsets.UTF_8)) {
            writer.write(jsonResponseString);
        } catch (IOException e) {
            LOG.error("Unable to write the config file.", e);
        }
    }
}
