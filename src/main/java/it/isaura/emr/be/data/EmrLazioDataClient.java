package it.isaura.emr.be.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by pasquale on 18/06/2016.
 */
public class EmrLazioDataClient implements EmrDataClient {

    final Logger logger = LogManager.getLogger("EmrDataClientLazio");

    public String getData(String url) {
        BaseJsonClient baseJsonClient = new BaseJsonClient();
        return baseJsonClient.call(url);
    }

    public String getData(String url, Integer limit) {
        String urlLimit = url + "&limit=" + limit;
        return getData(urlLimit);
    }
}
