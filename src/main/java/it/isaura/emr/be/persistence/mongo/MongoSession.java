package it.isaura.emr.be.persistence.mongo;

import com.mongodb.client.MongoCursor;
import it.isaura.emr.be.model.EmrDepartment;
import org.bson.Document;

/**
 * Created by pasquale on 18/06/2016.
 */
public interface MongoSession {

    public boolean setUp(String host, Integer port);

    void insert(String dbName, String collectionName, EmrDepartment emrDepartment) throws Exception;

    MongoCursor getCollectionIterator(String dbName, String collectionName) throws Exception;

    void delete(String dbName, String collectionName, Document document) throws Exception;


}
