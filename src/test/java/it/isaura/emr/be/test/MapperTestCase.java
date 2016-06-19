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
public class MapperTestCase extends TestUtil {

    final Logger logger = LogManager.getLogger("MapperTestCase");


    @Test
    public void testMapper(){
        logger.debug("testMapper");
        EmrDepartmentMapper mapper = getEmrDepartmentMapper();
        assertNotNull(mapper);
        assertEquals(EmrDepartmentMapperLazio.class,mapper.getClass());
        logger.debug("mapper "+mapper.getClass());
    }




    @Test
    public void testMapObjectLazio(){
        logger.debug("testMapObjectLazio");
        EmrDepartmentMapper mapper = getEmrDepartmentMapperList();
        logger.debug("deps size "+mapper.getEmrDepartmentList().size());
        assertTrue(mapper.getEmrDepartmentList().size() > 0);
        logger.debug(mapper.getEmrDepartmentList());
    }



    @Test
    public void testInsertMongoEmrDepartmentList(){
        logger.debug("testInsertMongoEmrDepartmentList");
        EmrDepartmentMapper mapper = getEmrDepartmentMapper();

    }

}
