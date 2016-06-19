package it.isaura.emr.be.mapper;

import it.isaura.emr.be.model.EmrDepartment;

import java.util.List;

/**
 * Created by pasquale on 19/06/2016.
 */
public interface EmrDepartmentMapper {


    public void mapFromJson(String json) throws Exception;


    List<EmrDepartment> getEmrDepartmentList();
}
