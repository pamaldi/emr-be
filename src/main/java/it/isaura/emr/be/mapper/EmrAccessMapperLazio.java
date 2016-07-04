package it.isaura.emr.be.mapper;

import it.isaura.emr.be.model.EmrAccessInfo;
import it.isaura.emr.be.model.EmrDepartment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by pasquale on 03/07/2016.
 */
public class EmrAccessMapperLazio implements EmrAccessMapper {

    final Logger logger = LogManager.getLogger("EmrAccessMapperLazio");


    private MapValueMapperJackson mapValueMapper;
    private EmrAccessBuilder emrAccessBuilder;
    private Map<String, Object> map;
    private List<EmrAccessInfo> emrAccessInfoList=null;

    @Override
    public void mapFromJson(String json) throws Exception {
        logger.debug("mapper for lazio ");
        buildObjectMap(json);
        buildEmrDepartment();
    }

    private void buildEmrDepartment() {
        emrAccessBuilder = new EmrAccessBuilderLazio();
        EmrAccessInfo emrAccessInfo = null;
        ArrayList records = (ArrayList)((Map)map.get("result")).get("records");
        Iterator i = records.iterator();
        Map record = null;
        emrAccessInfoList = new ArrayList<EmrAccessInfo>();
        while(i.hasNext()) {
            record = (Map)i.next();
            emrAccessInfo = new EmrAccessInfo();
            emrAccessBuilder.buildCodeDescription(emrAccessInfo, record);
            emrAccessInfoList.add(emrAccessInfo);
        }
    }

    private void buildObjectMap(String jsonString) throws Exception {
        mapValueMapper = new MapValueMapperJackson();
        map = mapValueMapper.map(jsonString);
    }

    @Override
    public List<EmrAccessInfo> getEmrAccessInfoList() {
        return null;
    }


}
