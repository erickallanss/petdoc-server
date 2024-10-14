package com.petdoc.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PController {

    @Autowired
    private PService service;

    @GetMapping
    public List<Pet> getAllPets() {
        return service.findAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return service.findPetById(id);
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return service.createPet(pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        service.deletePet(id);
    }
}
