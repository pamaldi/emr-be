package it.isaura.emr.be.persistence.mongo;

import com.mongodb.MongoClient;

/**
 * Created by pasquale on 18/06/2016.
 */
public class StandardMongoSession implements MongoSession {

    private MongoClient mongoClient = null;

    public boolean setUp(String host, Integer port) {
        mongoClient = new MongoClient(host, port);
        return true;
    }

    public boolean release() {
        this.mongoClient = null;
        return true;
    }
}
