package com.utfpr.banco.atividade.services;

import com.utfpr.banco.atividade.entities.Departamento;
import com.utfpr.banco.atividade.entities.Funcionario;
import com.utfpr.banco.atividade.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario buscaPorNomeEQtdDpn(String nome, Integer qtdDpn){
        return repository.findByNomeAndQtdDpn(nome, qtdDpn);
    }

    public List<Funcionario> listarPorDepartamento(Departamento departamento){
        return repository.findAllByDepartamento(departamento);
    }

    public Funcionario listarComMaiorSalario(){
        return repository.findTopByOrderBySalarioDesc();
    }

    public List<Funcionario> listar3ComMaioresSalarios(){
        return repository.findFirst3ByOrderBySalarioDesc();
    }

    public List<Funcionario> listarSemDependentesPorNomeAsc() {
        return repository.findByFuncionariosSemDependentesAsc();
    }

    public List<Funcionario> listarComSalarioMaiorQue(Double salario){
        return repository.findAllSalarioAfter(salario);
    }

    public List<Funcionario> listarComSalarioMaiorQueNativeQuery(Double salario){
        return repository.findBySalarioMaiorQue(salario);
    }

    public List<Funcionario> listarPorQtdDpn(Integer qtdDpn){
        return repository.findAllByQtdDpn(qtdDpn);
    }

    public List<Funcionario> listarPorNomeContem(String nome){
        return repository.findAllByNomeLike(nome);
    }
}
