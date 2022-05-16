package com.example.practice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetail , Long> {
    Optional<UserDetail> findByEmail(String email);
}
