package it.isaura.emr.be.test;

import com.mongodb.client.MongoCursor;
import it.isaura.emr.be.data.EmrDataClient;
import it.isaura.emr.be.data.EmrLazioDataClient;
import it.isaura.emr.be.mapper.EmrAccessMapper;
import it.isaura.emr.be.mapper.EmrDepartmentMapper;
import it.isaura.emr.be.model.EmrAccessInfo;
import it.isaura.emr.be.model.EmrDepartment;
import it.isaura.emr.be.persistence.mongo.MongoPersistenceManager;
import it.isaura.emr.be.persistence.mongo.MongoSession;
import it.isaura.emr.be.utils.ConfigurationUtils;
import it.isaura.emr.be.utils.GeneralUtils;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by pasquale on 19/06/2016.
 */
public class MongoSetUpLazioTestCase extends TestUtil {


    final Logger logger = LogManager.getLogger("MongoSetUpLazioTestCase");


    @Test
    public void testCreateCollectionEmrAddressesLazio(){
        logger.debug("createCollectionEmrAddressesLazio");
        EmrDepartmentMapper emrDepartmentMapperList = getEmrDepartmentMapperList();
        MongoPersistenceManager mongoPersistenceManager = MongoPersistenceManager.getInstance();
        MongoSession mongoSession = mongoPersistenceManager.createSession(ConfigurationUtils.getMongoHost(),ConfigurationUtils.getMongoPort());
        assertNotNull(mongoSession);
        try {
            Iterator<EmrDepartment> iterator = emrDepartmentMapperList.getEmrDepartmentList().iterator();
            EmrDepartment next = null;
            while(iterator.hasNext()) {
                next = iterator.next();
                mongoSession.insert(ConfigurationUtils.getMongoDB(), ConfigurationUtils.getMongoLazioSnapAddresses(), next);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }

        try {
            MongoCursor<Document> cursor = mongoSession.getCollectionIterator(ConfigurationUtils.getMongoDB(), ConfigurationUtils.getMongoLazioSnapAddresses());
            try {
                while (cursor.hasNext()) {
                    Document next = cursor.next();
                    logger.debug("Elemento in collection "+ next.toJson());
                    mongoSession.delete(ConfigurationUtils.getMongoDB(), ConfigurationUtils.getMongoLazioSnapAddresses(),next);
                }
            } finally {
                cursor.close();
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }


    @Test
    public void testCreateCollectionEmrLazioAccess(){
        logger.debug("createCollectionEmrLazioAccess");
        EmrAccessMapper emrAccessMapperList = getEmrAccessMapper();
        MongoPersistenceManager mongoPersistenceManager = MongoPersistenceManager.getInstance();
        MongoSession mongoSession = mongoPersistenceManager.createSession(ConfigurationUtils.getMongoHost(),ConfigurationUtils.getMongoPort());
        assertNotNull(mongoSession);
        try {
            Iterator<EmrAccessInfo> iterator = emrAccessMapperList.getEmrAccessInfoList().iterator();
            EmrAccessInfo  next = null;
            while(iterator.hasNext()) {
                next = iterator.next();
                //mongoSession.insert(ConfigurationUtils.getMongoDB(), ConfigurationUtils.getMongoLazioSnapAddresses(), next);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }



    }



}
