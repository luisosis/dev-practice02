package com.democrud.democrud.repository;

import com.democrud.democrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.concurrent.CompletableFuture;

public interface UserRepository extends JpaRepository<User, Integer> {

    CompletableFuture<User> findByName(String name);
}
