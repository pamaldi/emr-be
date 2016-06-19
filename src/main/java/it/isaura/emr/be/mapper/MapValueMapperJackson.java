package it.isaura.emr.be.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Named;
import java.util.Map;

/**
 * Created by pasquale on 19/06/2016.
 */
@Named("MapValueMapperJackson")
public class MapValueMapperJackson implements MapValueMapper {

    public Map<String, Object> map(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = null;
        map = mapper.readValue(json, Map.class);
        return map;
    }
}
