package com.utfpr.banco.atividade.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="funcionarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")

//9. Alterar a classe Funcionario e criar uma consulta para
// listar os funcionários com uma determinada quantidade de dependentes por @NamedQuery.
@NamedQuery(
        name = "Funcionario.ByQtdDpn",
        query = "from Funcionario  f where f.qtdDpn = ?1")

//10. Alterar a classe Funcionario e criar uma consulta para
// listar os funcionários que contenham em qualquer parte do
// seu nome um determinado nome por @NamedNativeQuery.
@NamedNativeQuery(
        name="Funcionario.ByNomeLike",
        query = "select * from funcionarios f where f.nome like ?1",
        resultClass = Funcionario.class)
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_funcionario", nullable = false)
    private Long id;
    @Column(length = 100)
    private String nome;
    @Column(name = "quantidade_dependentes")
    private Integer qtdDpn;
    private Double salario;
    private String cargo;
    @ManyToOne
    @JoinColumn(name = "codigo_departamento", nullable = false)
    private Departamento departamento;

}
