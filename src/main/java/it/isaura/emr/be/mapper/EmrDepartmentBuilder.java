package it.isaura.emr.be.mapper;

import it.isaura.emr.be.model.EmrDepartment;

import java.util.Map;

/**
 * Created by pasquale on 19/06/2016.
 */
public interface EmrDepartmentBuilder {


    public void buildCodeDescription(EmrDepartment emrDepartment, Map map);
    public void buildAddressInfo(EmrDepartment emrDepartment, Map map);


}
