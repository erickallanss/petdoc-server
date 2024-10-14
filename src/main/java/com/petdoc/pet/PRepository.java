package com.petdoc.pet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PRepository extends JpaRepository<Pet, Long> {
}
