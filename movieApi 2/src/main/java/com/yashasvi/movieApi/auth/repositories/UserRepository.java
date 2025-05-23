package com.yashasvi.movieApi.auth.repositories;

import com.yashasvi.movieApi.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String username);
}
