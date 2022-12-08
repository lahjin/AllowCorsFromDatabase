package com.example.allowcorsfromdatabase.repository;

import com.example.allowcorsfromdatabase.entity.Cors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CorsRepository extends JpaRepository<Cors, Long> {
    Optional<Cors> findByUrl(String url);
}
