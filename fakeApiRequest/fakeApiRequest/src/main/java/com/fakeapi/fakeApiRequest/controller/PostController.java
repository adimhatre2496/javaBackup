package com.fakeapi.fakeApiRequest.controller;


import com.fakeapi.fakeApiRequest.model.Post;
import com.fakeapi.fakeApiRequest.model.PostResponce;
import com.fakeapi.fakeApiRequest.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class PostController {

    @Autowired
    public PostService postService;

    @GetMapping(path = "/posts/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> getRequest(@PathVariable Long id){

        Post post= postService.getRequest(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

   @PostMapping(path = "/posts",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponce> postRequest(@RequestBody Post post)
    {
        PostResponce postRequest=postService.createPost(post);
        return new ResponseEntity<>(postRequest, HttpStatus.OK);
    }

   /* @PutMapping(path = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post){
    post= postService.updatePost(id, post);

        return new  ResponseEntity<>(post,HttpStatus.OK);

    }*/

    @PutMapping(path = "/posts/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponce> updatePosts(@PathVariable Long id,@RequestBody PostResponce postRequest) {
        return new ResponseEntity<>(postService.updatePosts(id,postRequest), HttpStatus.OK);
    }


    @DeleteMapping(path = "/posts/{id}",produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id)
    {
        postService.deleteRequest(id);
        log.info("successfully deleted");
        return ResponseEntity.ok().build();
    }






    }
