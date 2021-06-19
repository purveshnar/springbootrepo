package com.purvesh.springboot.controller;

import com.purvesh.springboot.model.PostDTO;
import com.purvesh.springboot.model.Posts;
import com.purvesh.springboot.service.UserService;
import com.purvesh.springboot.util.EntitiyHawk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController extends EntitiyHawk {

    @Autowired
    UserService userService;

    @PostMapping("/publish")
    @ResponseBody
    public ResponseEntity publish(@RequestBody @Valid PostDTO postDTO) {
        userService.publish(postDTO);
        return new EntitiyHawk().genericSuccess("Published");
    }

    @GetMapping("/getPostCount")
    @ResponseBody
    public ResponseEntity getPostCount() {
        int postCount = userService.getPostCount();
        System.out.println("postCount = " + postCount);
        return new EntitiyHawk().genericSuccess(postCount);
    }

    @GetMapping("/getPost")
    @ResponseBody
    public ResponseEntity<List<Posts>> getPost() {
        List<Posts> postsList = userService.getPost();
        return new EntitiyHawk().genericSuccess(postsList);
    }

    @GetMapping("/getPost/{postId}")
    @ResponseBody
    public ResponseEntity<Posts> getPostById(@PathVariable("postId") Integer postId) {
        Posts post = userService.getPostById(postId);
        return new EntitiyHawk().genericSuccess(post);
    }

    @GetMapping("/getPostByUser/{userId}")
    @ResponseBody
    public ResponseEntity<List<Posts>> getPostByUser(@RequestParam("userId") Integer userId) {
        List<Posts> postsList = userService.getPostByUser(userId);
        return new EntitiyHawk().genericSuccess(postsList);
    }
}
