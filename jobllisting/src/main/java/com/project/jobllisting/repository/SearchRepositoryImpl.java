package com.project.jobllisting.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.project.jobllisting.model.Post;
import com.project.jobllisting.repository.SearchRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class SearchRepositoryImpl implements SearchRepository {
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;


@Override
public List<Post> findByText(String text) {

    final List<Post> post = new ArrayList<>();
    MongoDatabase database = mongoClient.getDatabase("shaiqua");
    MongoCollection<Document> collection = database.getCollection("jobpost");

    AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
            new Document("$search",
                    new Document("text",
                            new Document("query", text)
                                    .append("path", Arrays.asList("techs", "desc", "profile")))),
            new Document("$limit", 5L)));

    result.forEach(document -> {
        post.add(mongoConverter.read(Post.class, document));
    });

        return post;
    }

}


