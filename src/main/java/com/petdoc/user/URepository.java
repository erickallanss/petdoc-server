package com.petdoc.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface URepository extends JpaRepository<UUser, Long> {
    UUser findByEmail(String email);
}
