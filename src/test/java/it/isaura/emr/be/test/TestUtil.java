package it.isaura.emr.be.test;

import it.isaura.emr.be.data.EmrDataClient;
import it.isaura.emr.be.data.EmrLazioDataClient;
import it.isaura.emr.be.mapper.*;
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


    protected EmrAccessMapper getEmrAccessMapper() {
        EmrAccessMapper mapper = null;
        try {
            mapper = EmrAccessMapperFactory.getInstance().getMapper(EmrAccessMapperLazio.class.getName());
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
        String response = getJsonResponseEmrLazio();
        try {
            mapper.mapFromJson(response);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        return mapper;
    }

    private String getJsonResponseEmrLazio() {
        EmrDataClient emrDataClient = new EmrLazioDataClient();
        return emrDataClient.getData(ConfigurationUtils.getUrlLazio());
    }

    protected EmrAccessMapper buildEmrAccessMapper() {
        EmrAccessMapper mapper = getEmrAccessMapper();
        assertNotNull(mapper);
        assertEquals(EmrAccessMapperLazio.class,mapper.getClass());
        logger.debug("mapper "+mapper.getClass());
        String response = getJsonResponseEmrLazio();
        try {
            mapper.mapFromJson(response);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        return mapper;
    }


}
