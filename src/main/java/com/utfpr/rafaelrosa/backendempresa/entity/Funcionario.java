package com.utfpr.rafaelrosa.backendempresa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "funcionario")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 120)
    private String nome;

    @Column(name = "qtd_dependentes", columnDefinition = "interger default 0")
    private int qtdDependentes;

    private float salario;

    @Column(length = 60)
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Departamento departamento;

}
