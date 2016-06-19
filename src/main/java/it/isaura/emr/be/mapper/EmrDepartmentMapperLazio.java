package it.isaura.emr.be.mapper;

import it.isaura.emr.be.model.EmrDepartment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by pasquale on 19/06/2016.
 */
public class EmrDepartmentMapperLazio implements EmrDepartmentMapper {

    final Logger logger = LogManager.getLogger("EmrDepartmentMapperLazio");


    private MapValueMapperJackson mapValueMapper;
    private EmrDepartmentBuilder emrDepartmentBuilder;
    private Map<String, Object> map;
    private List<EmrDepartment> emrDepartmentList=null;

    @Override
    public void mapFromJson(String jsonString) throws Exception {
        logger.debug("mapper for lazio");
        buildObjectMap(jsonString);
        buildEmrDepartment();

    }

    private void buildEmrDepartment() {
        emrDepartmentBuilder = new EmrDepartmentLazioBuilder();
        EmrDepartment emrDepartement = new EmrDepartment();
        ArrayList records = (ArrayList)((Map)map.get("result")).get("records");
        Iterator i = records.iterator();
        Map record = null;
        emrDepartmentList = new ArrayList<EmrDepartment>();
        while(i.hasNext()) {
            record = (Map)i.next();
            emrDepartmentBuilder.buildAddressInfo(emrDepartement, record);
            emrDepartmentBuilder.buildCodeDescription(emrDepartement, record);
            emrDepartmentList.add(emrDepartement);
        }
    }

    private void buildObjectMap(String jsonString) throws Exception {
        mapValueMapper = new MapValueMapperJackson();
        map = mapValueMapper.map(jsonString);
    }

    @Override
    public List<EmrDepartment> getEmrDepartmentList() {
        return emrDepartmentList;
    }
}
