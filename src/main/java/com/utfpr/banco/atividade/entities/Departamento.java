package com.utfpr.banco.atividade.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="departamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_departamento", nullable = false)
    private Long id;
    @Column(length = 100)
    private String nome;

}
