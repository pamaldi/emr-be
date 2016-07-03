package it.isaura.emr.be.mapper;

import it.isaura.emr.be.model.EmrAccessInfo;
import it.isaura.emr.be.model.EmrDepartment;

import java.util.List;

/**
 * Created by pasquale on 03/07/2016.
 */
public interface EmrAccessMapper {

    public void mapFromJson(String json) throws Exception;

    List<EmrAccessInfo> getEmrAccessInfoList();

}
