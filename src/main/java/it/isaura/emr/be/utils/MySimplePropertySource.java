package it.isaura.emr.be.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tamaya.core.propertysource.BasePropertySource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by pasquale on 18/06/2016.
 */
public class MySimplePropertySource extends BasePropertySource {
    public static final String CONFIG_PROPERTIES_LOCATION = "META-INF/application.properties";
    final static Logger logger = LogManager.getLogger("Configuration");
    private Map<String, String> props = new HashMap<String, String>();

    public MySimplePropertySource() throws IOException {
        URL url = ClassLoader.getSystemClassLoader().getResource(CONFIG_PROPERTIES_LOCATION);
        Properties properties = new Properties();

        try {
            InputStream is = url.openStream();
            properties.load(is);
        } catch (IOException e) {
            logger.error("Error reading configuration ");
        } finally {
            for (Map.Entry en : properties.entrySet()) {
                props.put(en.getKey().toString(), en.getValue().toString());
            }
            props = Collections.unmodifiableMap(props);
        }
    }

    @Override
    public String getName() {
        return CONFIG_PROPERTIES_LOCATION;
    }


    public Map<String, String> getProperties() {
        return props;
    }
}
