package it.isaura.emr.be.mapper;

import java.util.HashMap;

/**
 * Created by pasquale on 19/06/2016.
 */
public class EmrDepartmentMapperFactory {


    private static EmrDepartmentMapperFactory emrDepartmentMapperFactory = null;
    private HashMap<String, Class> mappers = null;

    private EmrDepartmentMapperFactory() {
        this.mappers = new HashMap<String, Class>();
        registerMapper();
    }

    public static EmrDepartmentMapperFactory getInstance() {
        if (emrDepartmentMapperFactory == null) {
            emrDepartmentMapperFactory = new EmrDepartmentMapperFactory();
        }
        return emrDepartmentMapperFactory;
    }

    private void registerMapper() {
        mappers.put(EmrDepartmentMapperLazio.class.getName(), EmrDepartmentMapperLazio.class);
    }

    public EmrDepartmentMapper getMapper(String name) throws Exception {
        Class clzz = this.mappers.get(name);
        return (EmrDepartmentMapper) clzz.newInstance();
    }


}
