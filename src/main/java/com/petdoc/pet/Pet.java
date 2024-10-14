package com.petdoc.pet;

import com.petdoc.user.UUser;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate birth;
    private String type;
    private String breed;

    @ManyToMany
    @JoinTable(
      name = "user_pet",
      joinColumns = @JoinColumn(name = "pet_id"),
      inverseJoinColumns = @JoinColumn(name = "uuser_id")
    )
    private Set<UUser> owners;
}
