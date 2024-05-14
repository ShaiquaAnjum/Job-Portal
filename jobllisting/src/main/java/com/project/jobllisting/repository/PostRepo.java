package com.project.jobllisting.repository;

import com.mongodb.client.MongoClient;
import com.project.jobllisting.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface PostRepo extends MongoRepository<Post,String> {

}
