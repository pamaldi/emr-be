package it.isaura.emr.be.test;

import it.isaura.emr.be.data.EmrDataClient;
import it.isaura.emr.be.data.EmrLazioDataClient;
import it.isaura.emr.be.utils.ConfigurationUtils;
import it.isaura.emr.be.utils.GeneralUtils;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tamaya.Configuration;
import org.apache.tamaya.ConfigurationProvider;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Created by pasquale on 18/06/2016.
 */
public class BaseTestCase extends TestCase {

    @Test
    public void testConfiguration(){
        String url = getUrlLazio();
        assertNotNull(url);
        final  Logger logger = LogManager.getLogger("Test");
        logger.debug("url "+url);
    }

    private String getUrlLazio() {
        String urlLazio = ConfigurationUtils.getUrlLazio();
        assertNotNull(urlLazio);
        return urlLazio;
    }

    @Test
    public void testRetrieveData(){
        final  Logger logger = LogManager.getLogger("Test");
        logger.info("retrieve data");
        EmrDataClient emrDataClient = new EmrLazioDataClient();
        String response = emrDataClient.getData(ConfigurationUtils.getUrlLazio());
        logger.info("response "+ GeneralUtils.prettyJson(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void testRetrieveDataLimit(){
        final  Logger logger = LogManager.getLogger("Test");
        logger.info("retrieve data limit");
        EmrDataClient emrDataClient = new EmrLazioDataClient();
        String response = emrDataClient.getData(ConfigurationUtils.getUrlLazio(),1);
        logger.info("response "+ GeneralUtils.prettyJson(response));
        Assert.assertNotNull(response);
    }

    @Test
    public void testApiKey(){
        final  Logger logger = LogManager.getLogger("Test");
        logger.info("google api key");
        String googleKey = ConfigurationUtils.getGoogleKey();
        logger.info("google api key "+googleKey);
        assertNotNull(googleKey);
    }


}
