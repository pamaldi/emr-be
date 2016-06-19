package it.isaura.emr.be.persistence.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import it.isaura.emr.be.model.EmrDepartment;
import it.isaura.emr.be.utils.ConfigurationUtils;
import it.isaura.emr.be.utils.GeneralUtils;
import org.bson.Document;

/**
 * Created by pasquale on 18/06/2016.
 */
public class StandardMongoSession implements MongoSession {

    private MongoClient mongoClient = null;

    public boolean setUp(String host, Integer port) {
        mongoClient = new MongoClient(host, port);
        return true;
    }

    @Override
    public void insert(String dbName, String collectionName, EmrDepartment emrDepartment) throws Exception {
        if(mongoClient == null){
            throw  new Exception ("Connection does not exsits");
        }
        MongoCollection<Document> collection = getDocumentMongoCollection(dbName, collectionName);
        collection.insertOne(Document.parse(GeneralUtils.getJson(emrDepartment)));
    }

    private MongoCollection<Document> getDocumentMongoCollection(String dbName, String collectionName) {
        MongoDatabase database = mongoClient.getDatabase(dbName);
        return database.getCollection(collectionName);
    }

    @Override
    public MongoCursor getCollectionIterator(String dbName, String collectionName) throws Exception {
        MongoCollection<Document> collection = getDocumentMongoCollection(dbName, collectionName);
        return collection.find().iterator();
    }

    @Override
    public void delete(String dbName, String collectionName, Document document) throws Exception {
        MongoCollection<Document> collection = getDocumentMongoCollection(dbName, collectionName);
        collection.deleteOne(document);
    }


    public boolean release() {
        this.mongoClient = null;
        return true;
    }
}
