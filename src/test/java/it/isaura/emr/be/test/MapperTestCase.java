package it.isaura.emr.be.test;

import it.isaura.emr.be.facade.EmrFacade;
import it.isaura.emr.be.mapper.EmrDepartmentMapper;
import it.isaura.emr.be.mapper.EmrDepartmentMapperLazio;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by pasquale on 19/06/2016.
 */
public class MapperTestCase extends TestCase {

    final Logger logger = LogManager.getLogger("MapperTestCase");


    @Test
    public void testMapper(){
        logger.debug("testMapper");
        EmrDepartmentMapper mapper = EmrFacade.getInstance().buildEmrDepartmentMapper();
        assertNotNull(mapper);
        assertEquals(EmrDepartmentMapperLazio.class,mapper.getClass());
        logger.debug("mapper "+mapper.getClass());
    }




    @Test
    public void testMapObjectLazio(){
        logger.debug("testMapObjectLazio");
        EmrDepartmentMapper mapper = EmrFacade.getInstance().buildEmrDepartmentMapper();
        logger.debug("deps size "+mapper.getEmrDepartmentList().size());
        assertTrue(mapper.getEmrDepartmentList().size() > 0);
        logger.debug(mapper.getEmrDepartmentList());
    }





}
