package com.petdoc.user;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

import com.petdoc.pet.Pet;

@Data
@Entity
public class UUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String phone;
    private String gender;
    
    @Column(nullable = false)
    private String password;

    @ManyToMany(mappedBy = "owners")
    private Set<Pet> pets;
}
