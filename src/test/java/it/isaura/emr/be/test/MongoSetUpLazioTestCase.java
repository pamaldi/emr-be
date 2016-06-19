package it.isaura.emr.be.test;

import it.isaura.emr.be.data.EmrDataClient;
import it.isaura.emr.be.data.EmrLazioDataClient;
import it.isaura.emr.be.utils.ConfigurationUtils;
import it.isaura.emr.be.utils.GeneralUtils;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by pasquale on 19/06/2016.
 */
public class MongoSetUpLazioTestCase extends TestCase {


    final Logger logger = LogManager.getLogger("MongoSetUpLazioTestCase");


    @Test
    public void testCreateCollectionEmrAddressesLazio(){
        logger.debug("createCollectionEmrAddressesLazio");
        EmrDataClient emrDataClient = new EmrLazioDataClient();
        String response = emrDataClient.getData(ConfigurationUtils.getUrlLazio());
        logger.info("response "+ GeneralUtils.prettyJson(response));
        assertNotNull(response);
    }



}
