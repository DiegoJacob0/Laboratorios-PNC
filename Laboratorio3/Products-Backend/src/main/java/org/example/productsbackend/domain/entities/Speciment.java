package org.example.productsbackend.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "speciment")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Speciment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "dangerLevel")
    private Integer dangerLevel;

    @Column(name = "isFriendly")
    private Boolean isFriendly;
}