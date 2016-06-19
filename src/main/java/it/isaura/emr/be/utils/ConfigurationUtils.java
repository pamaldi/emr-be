package it.isaura.emr.be.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tamaya.Configuration;
import org.apache.tamaya.ConfigurationProvider;

import java.io.IOException;

/**
 * Created by pasquale on 18/06/2016.
 */
public class ConfigurationUtils {


    final static Logger logger = LogManager.getLogger("Configuration");
    private static Configuration configuration = null;

    static {

        MySimplePropertySource simplePropertySource = null;
        try {
            simplePropertySource = new MySimplePropertySource();
        } catch (IOException e) {
            logger.error("Errore in configurazione ");
        }
        ConfigurationProvider.getConfiguration().getContext().addPropertySources(simplePropertySource);
        configuration = ConfigurationProvider.getConfiguration();
    }


    public static String getUrlLazio() {
        return configuration.get("url.dati.emr.lazio");
    }

    public static String getGoogleKey() {
        return configuration.get("google-api-key");
    }

    public static String getGoogleApi() {
        return configuration.get("url.directions.google");
    }

    public static String getMongoHost() {
        return configuration.get("mongo.host");
    }

    public static Integer getMongoPort() {
        return Integer.valueOf(configuration.get("mongo.port"));
    }


}
