package com.petdoc.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PService {

    @Autowired
    private PRepository repository;

    public List<Pet> findAllPets() {
        return repository.findAll();
    }

    public Pet findPetById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pet createPet(Pet pet) {
        return repository.save(pet);
    }

    public void deletePet(Long id) {
        repository.deleteById(id);
    }
}
