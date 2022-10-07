package utils;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

public class DbConnection {
    private static DbConnection instance;
    private MongoClient mongoClient;

    private DbConnection() {
        mongoClient = MongoClients.create(); //localhost 27017
    }

    public synchronized static DbConnection getInstance() {
        if(instance == null)
            instance = new DbConnection();

        return instance;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
}
