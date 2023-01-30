package com.fakeapi.fakeApiRequest.service;


import com.fakeapi.fakeApiRequest.model.Post;
import com.fakeapi.fakeApiRequest.model.PostResponce;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@Log4j2
public class PostService {
    @Autowired
    public  RestTemplate restTemplate;

    @Value("${test.url}")
    private String testUrl;

   public PostResponce createPost(Post post){

       HttpEntity<Post> http=new HttpEntity<>(post);
      ResponseEntity<PostResponce> postResponce= restTemplate.exchange(testUrl + "/posts", HttpMethod.POST,http,PostResponce.class);
       log.info("Done");
       log.info("Successfull Post");
       return postResponce.getBody();

   }
    public Post getRequest(Long id)
    {
      Post post= restTemplate.getForObject(testUrl +"/posts/{id}",Post.class,id );
      log.info("Successfull Get");
       return post;

    }

    public PostResponce updatePosts(Long id, PostResponce postRequest) {
        HttpEntity httpEntity=new HttpEntity<>(postRequest);
        ResponseEntity<PostResponce> postResponse= restTemplate.exchange(testUrl+"/posts/"+id,HttpMethod.PUT,httpEntity,
                PostResponce.class);
        return postResponse.getBody();
    }


   public PostResponce updatePosts1(Long id, PostResponce postRequest) {

        postRequest= restTemplate.put(testUrl+"/posts/"+id,PostResponce.class);
        return postRequest.getBody();
    }


    public void  deleteRequest(Long id)
    {

        restTemplate.delete(testUrl + "/posts/{id}",id);
        log.info("Deleted Succesfully");
    }


}
