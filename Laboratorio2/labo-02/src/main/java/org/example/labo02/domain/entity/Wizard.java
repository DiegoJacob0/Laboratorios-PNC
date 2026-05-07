package org.example.labo02.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Wizard")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "wizardName")
    private String name;

    @Column(name = "house")
    private String house;

    @Column(name = "patronus")
    private String patronus;

    @Column(name = "is_deatheater")
    private Boolean isDeatheater;

}
