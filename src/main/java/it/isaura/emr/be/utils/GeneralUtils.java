package it.isaura.emr.be.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.isaura.emr.be.model.EmrDepartment;

/**
 * Created by pasquale on 18/06/2016.
 */
public class GeneralUtils {

    public static String prettyJson(String s) {
        String ret = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object json = mapper.readValue(s, Object.class);
            ret = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String getJson(EmrDepartment emrDepartment) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(emrDepartment);
        return jsonInString;
    }


}
