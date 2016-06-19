package it.isaura.emr.be.test;

import it.isaura.emr.be.data.EmrDataClient;
import it.isaura.emr.be.data.EmrLazioDataClient;
import it.isaura.emr.be.mapper.EmrDepartmentMapper;
import it.isaura.emr.be.mapper.EmrDepartmentMapperFactory;
import it.isaura.emr.be.mapper.EmrDepartmentMapperLazio;
import it.isaura.emr.be.utils.ConfigurationUtils;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by pasquale on 19/06/2016.
 */
public class TestUtil extends TestCase {

    final Logger logger = LogManager.getLogger("TestUtil");

    @Test
    public void test(){
        assertTrue(true);
    }

    protected EmrDepartmentMapper getEmrDepartmentMapper() {
        EmrDepartmentMapper mapper = null;
        try {
            mapper = EmrDepartmentMapperFactory.getInstance().getMapper(EmrDepartmentMapperLazio.class.getName());
        } catch (Exception e) {
            fail(e.getMessage());
        }
        return mapper;
    }

    protected EmrDepartmentMapper getEmrDepartmentMapperList() {
        EmrDepartmentMapper mapper = getEmrDepartmentMapper();
        assertNotNull(mapper);
        assertEquals(EmrDepartmentMapperLazio.class,mapper.getClass());
        logger.debug("mapper "+mapper.getClass());
        EmrDataClient emrDataClient = new EmrLazioDataClient();
        String response = emrDataClient.getData(ConfigurationUtils.getUrlLazio());
        try {
            mapper.mapFromJson(response);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        return mapper;
    }


}
