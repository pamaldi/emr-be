package it.isaura.emr.be.mapper;

import java.util.HashMap;

/**
 * Created by pasquale on 19/06/2016.
 */
public class EmrAccessMapperFactory {


    private static EmrAccessMapperFactory emrAccessMapperFactory = null;
    private HashMap<String, Class> mappers = null;

    private EmrAccessMapperFactory() {
        this.mappers = new HashMap<String, Class>();
        registerMapper();
    }

    public static EmrAccessMapperFactory getInstance() {
        if (emrAccessMapperFactory == null) {
            emrAccessMapperFactory = new EmrAccessMapperFactory();
        }
        return emrAccessMapperFactory;
    }

    private void registerMapper() {
        mappers.put(EmrAccessMapperLazio.class.getName(), EmrAccessMapperLazio.class);
    }

    public EmrAccessMapper getMapper(String name) throws Exception {
        Class clzz = this.mappers.get(name);
        return (EmrAccessMapper) clzz.newInstance();
    }


}
