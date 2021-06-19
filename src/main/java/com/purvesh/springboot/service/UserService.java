package com.purvesh.springboot.service;

import com.purvesh.springboot.model.PostDTO;
import com.purvesh.springboot.model.Posts;
import com.purvesh.springboot.model.Users;
import com.purvesh.springboot.persistence.repositories.PostRepository;
import com.purvesh.springboot.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    public Posts publish(PostDTO postDTO) {
        return postRepository.save(toPostsEntity().apply(postDTO));
    }

    /**
     * Lambda to convert model to entity
     *
     * @return lambda performing the action
     */
    public Function<PostDTO, Posts> toPostsEntity() {
        return postDTO -> Posts.builder()
                .postTitle(postDTO.getTitle())
                .postBody(postDTO.getBody())
                .build();
    }

    public int getPostCount() {
        return (int) postRepository.findAll().stream().count();
    }

    public List<Posts> getPost() {
        return postRepository.findAll();
    }

    public Posts getPostById(Integer postId) {
        return postRepository.findById(postId).orElse(Posts.builder().build());
    }

    public List<Posts> getPostByUser(Integer userId) {
        Users user = userRepository.findById(userId).orElseThrow(RuntimeException::new);
        return user.getPostsList();
    }
}
