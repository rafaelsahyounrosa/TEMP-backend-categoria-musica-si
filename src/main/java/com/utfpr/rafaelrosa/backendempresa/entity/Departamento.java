package com.utfpr.rafaelrosa.backendempresa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "departamento")
@Data
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 60)
    private String nome;
}
