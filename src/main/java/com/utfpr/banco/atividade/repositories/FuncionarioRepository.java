package com.utfpr.banco.atividade.repositories;

import com.utfpr.banco.atividade.entities.Departamento;
import com.utfpr.banco.atividade.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    //1. Listar um funcionário pelo seu nome e quantidade de dependentes
    // utilizando consulta por palavras-chaves.
    Funcionario findByNomeAndQtdDpn(String nome, Integer qtdDpn);

    //2. Listar todos os funcionários de um determinado departamento por JPQL via @Query.
    @Query("select f from Funcionario f where f.departamento = ?1")
    List<Funcionario> findAllByDepartamento(Departamento departamento);

    //4. Listar o primeiro funcionário que tem o maior salário.
    Funcionario findTopByOrderBySalarioDesc();

    //5. Listar os 3 (três) primeiros funcionários que tem os maiores salários.
    List<Funcionario> findFirst3ByOrderBySalarioDesc();

    //6. Listar os funcionários que não tem dependentes em ordem crescente de nome por JPQL via @Query.
    @Query("select f from Funcionario f where f.qtdDpn = 0 order by f.nome asc")
    List<Funcionario> findByFuncionariosSemDependentesAsc();

    //7. Listar os funcionários que tem salário maior que um determinado valor
    // por JPQL sobrescrevendo palavras-chaves @Query.
    @Query("select f from Funcionario f where f.salario > ?1")
    List<Funcionario> findAllSalarioAfter(Double salario);

    //8. Listar os funcionários que tem salário maior que um determinado
    // valor por @Query com native query.
    @Query(value = "select * from funcionarios where salario > ?1", nativeQuery = true)
    List<Funcionario> findBySalarioMaiorQue(Double salario);

    //11. Alterar a interface FuncionarioRepository para utilizar a @NamedQuery
    // e @NamedNativeQuery realizadas nas questões 9 e 10 (respectivamente).
    @Query(name = "Funcionario.ByQtdDpn")
    List<Funcionario> findAllByQtdDpn(Integer qtdDpn);

    @Query(name = "Funcionario.ByNomeLike")
    List<Funcionario> findAllByNomeLike(String nome);

}
