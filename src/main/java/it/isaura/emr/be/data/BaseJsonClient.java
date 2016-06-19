package it.isaura.emr.be.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Created by pasquale on 18/06/2016.
 */
public class BaseJsonClient {

    final Logger logger = LogManager.getLogger("JSonClient");

    public String call(String url) {
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target(url);
        logger.debug("url " + url);
        String response = myResource.request(MediaType.APPLICATION_JSON)
                .get(String.class);
        return response;
    }


}
