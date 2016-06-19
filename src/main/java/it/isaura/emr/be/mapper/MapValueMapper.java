package it.isaura.emr.be.mapper;

import java.util.Map;

/**
 * Created by pasquale on 19/06/2016.
 */
public interface MapValueMapper {


    public Map<String, Object> map(String json) throws Exception;


}
