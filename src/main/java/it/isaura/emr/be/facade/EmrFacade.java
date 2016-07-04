package it.isaura.emr.be.facade;

import it.isaura.emr.be.data.EmrDataClient;
import it.isaura.emr.be.data.EmrLazioDataClient;
import it.isaura.emr.be.mapper.*;
import it.isaura.emr.be.utils.ConfigurationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by pasquale on 04/07/2016.
 */
public class EmrFacade {


    private static EmrFacade instance;
    final Logger logger = LogManager.getLogger("EmrFacade");

    private EmrFacade(){

    }

    public static EmrFacade getInstance(){
        if(instance == null){
            instance = new EmrFacade();
        }
        return instance;
    }

    protected EmrDepartmentMapper getEmrDepartmentMapper() {
        EmrDepartmentMapper mapper = null;
        try {
            mapper = EmrDepartmentMapperFactory.getInstance().getMapper(EmrDepartmentMapperLazio.class.getName());
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
        }
        return mapper;
    }


    protected EmrAccessMapper getEmrAccessMapper() {
        EmrAccessMapper mapper = null;
        try {
            mapper = EmrAccessMapperFactory.getInstance().getMapper(EmrAccessMapperLazio.class.getName());
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
        }
        return mapper;
    }

    public EmrDepartmentMapper buildEmrDepartmentMapper() {
        EmrDepartmentMapper mapper = getEmrDepartmentMapper();
        logger.debug("mapper "+mapper.getClass());
        String response = getJsonResponseEmrLazio();
        try {
            mapper.mapFromJson(response);
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
        }
        return mapper;
    }

    private String getJsonResponseEmrLazio() {
        EmrDataClient emrDataClient = new EmrLazioDataClient();
        return emrDataClient.getData(ConfigurationUtils.getUrlLazio());
    }

    public EmrAccessMapper buildEmrAccessMapper() {
        EmrAccessMapper mapper = getEmrAccessMapper();

        logger.debug("mapper "+mapper.getClass());
        String response = getJsonResponseEmrLazio();
        try {
            mapper.mapFromJson(response);
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
        }
        return mapper;
    }

}
