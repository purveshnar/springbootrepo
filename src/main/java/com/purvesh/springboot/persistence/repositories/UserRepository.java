package com.purvesh.springboot.persistence.repositories;

import com.purvesh.springboot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query("select u from Users u where u.userName = :username")
    Optional<Users> findByUsername(@Param("username") String username);

    @Query("select u from Users u where u.email = :email")
    Optional<Users> findByEmail(@Param("email") String email);

    @Query("select u from Users u where u.userId = :id")
    Optional<Users> findById(@Param("id") Integer id);
}
