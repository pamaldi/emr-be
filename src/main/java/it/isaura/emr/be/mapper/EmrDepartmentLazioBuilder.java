package it.isaura.emr.be.mapper;

import it.isaura.emr.be.model.EmrDepartment;

import java.util.Map;

/**
 * Created by pasquale on 19/06/2016.
 */
public class EmrDepartmentLazioBuilder implements EmrDepartmentBuilder {

    @Override
    public void buildCodeDescription(EmrDepartment emrDepartment, Map map) {
     String code = (String)map.get("CODICE");
     String istituto = (String)map.get("ISTITUTO");
     emrDepartment.setCode(code);
     emrDepartment.setDescription(istituto);
    }

    @Override
    public void buildAddressInfo(EmrDepartment emrDepartment, Map map) {
        emrDepartment.setAddress("");
        emrDepartment.setAddressNumber("");
        emrDepartment.setCity((String)map.get("COMUNE"));
        emrDepartment.setRegion("Lazio");
    }
}
