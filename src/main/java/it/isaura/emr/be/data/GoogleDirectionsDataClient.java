package it.isaura.emr.be.data;

import it.isaura.emr.be.utils.ConfigurationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by pasquale on 18/06/2016.
 */
public class GoogleDirectionsDataClient implements DirectionsDataClient {

    final Logger logger = LogManager.getLogger("EmrDataClientLazio");

    public String getDirections(String url, String origin, String destination) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append("?origin=");
        sb.append(origin);
        sb.append("&destination=");
        sb.append(destination);
        sb.append("&key=");
        sb.append(ConfigurationUtils.getGoogleKey());
        BaseJsonClient baseJsonClient = new BaseJsonClient();
        return baseJsonClient.call(sb.toString());
    }
}
