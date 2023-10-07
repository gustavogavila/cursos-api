package com.gus.cursosapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURSO_SEQ_GEN")
    @SequenceGenerator(name = "CURSO_SEQ_GEN", sequenceName = "CURSO_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private OffsetDateTime dataCriacao;

    @ManyToMany
    @JoinTable(name = "curso_estudante",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_estudante"))
    private List<Estudante> estudantes;
}
