package it.isaura.emr.be.persistence.mongo;

import com.mongodb.MongoClient;

/**
 * Created by pasquale on 18/06/2016.
 */
public class MongoPersistenceManager {

private static MongoPersistenceManager mongoPersistenceManager = null;

    private MongoSession mongoSession = null;

    private MongoPersistenceManager(){

    }


    public static MongoPersistenceManager getInstance(){
        if(mongoPersistenceManager == null){
           mongoPersistenceManager = new MongoPersistenceManager();
        }
        return  mongoPersistenceManager;
    }

    public  MongoSession createSession(String host, Integer port){
         if(this.mongoSession == null){
             mongoSession = new StandardMongoSession();
             mongoSession.setUp(host, port);
         }
        return mongoSession;
    }
}
