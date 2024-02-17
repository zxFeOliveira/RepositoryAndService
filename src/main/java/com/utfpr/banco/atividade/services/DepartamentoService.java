package com.utfpr.banco.atividade.services;

import com.utfpr.banco.atividade.entities.Departamento;
import com.utfpr.banco.atividade.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository repository;

    public Departamento listarPrimeiroCad(){
        return repository.findFirstBy();
    }
}
