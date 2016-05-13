package com.furkan.mongotest;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.ParseException;

public class Main {

    public static void main(String [ ] args) throws ParseException {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("WORLD");
        db.getCollection("world").insertOne(new Document("name", "hello " +
                "world"));
        FindIterable<Document> iterable = db.getCollection("world").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }
}
