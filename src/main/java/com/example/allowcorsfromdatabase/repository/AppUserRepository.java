package com.example.allowcorsfromdatabase.repository;

import com.example.allowcorsfromdatabase.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    boolean existsByToken(String token);
}