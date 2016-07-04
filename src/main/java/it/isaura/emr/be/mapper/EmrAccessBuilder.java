package it.isaura.emr.be.mapper;

import it.isaura.emr.be.model.EmrAccessInfo;
import it.isaura.emr.be.model.EmrDepartment;

import java.util.Map;

/**
 * Created by pasquale on 04/07/2016.
 */
public interface EmrAccessBuilder {

    public void buildCodeDescription(EmrAccessInfo emrAccessInfo, Map map);

}
