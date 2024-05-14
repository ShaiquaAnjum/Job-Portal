package com.project.jobllisting.controller;



import com.project.jobllisting.model.Post;
import com.project.jobllisting.repository.PostRepo;
import com.project.jobllisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepo postRepo;
    @Autowired
    SearchRepository searchRepository;

    @ApiIgnore
    @RequestMapping(value="/")
    public void post(HttpServletResponse response) throws IOException {
        response.sendRedirect( "/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postRepo.findAll();

    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
     return   postRepo.save(post);

    }
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
      return  searchRepository.findByText(text);


    }







}
