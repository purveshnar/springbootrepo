package com.purvesh.springboot.persistence.repositories;

import com.purvesh.springboot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
