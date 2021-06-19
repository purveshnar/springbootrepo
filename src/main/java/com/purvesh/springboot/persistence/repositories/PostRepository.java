package com.purvesh.springboot.persistence.repositories;

import com.purvesh.springboot.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts,Integer> {


}
