package com.example.techblogapi.repository;

import com.example.techblogapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    public Optional<Users> findByEmail(String email);

}