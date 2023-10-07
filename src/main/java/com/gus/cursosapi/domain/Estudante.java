package com.gus.cursosapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTUDANTE_SEQ_GEN")
    @SequenceGenerator(name = "ESTUDANTE_SEQ_GEN", sequenceName = "ESTUDANTE_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private OffsetDateTime dataCriacao;

    @ManyToMany(mappedBy = "estudantes")
    private List<Curso> cursos;
}
