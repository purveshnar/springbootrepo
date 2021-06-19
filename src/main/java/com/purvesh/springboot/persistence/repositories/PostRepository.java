package com.purvesh.springboot.persistence.repositories;

import com.purvesh.springboot.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Posts, Integer> {

    @Query("select p from Posts p where p.postId = :id")
    Optional<Posts> findById(@Param("id") Integer id);

}
