package com.example.microservice1.repository;

import com.example.microservice1.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user, Long> {
    // Këtu mund të shtoni metoda të tjera specifike për kërkesa të personalizuara
}

