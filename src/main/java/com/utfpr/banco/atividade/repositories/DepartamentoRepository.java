package com.utfpr.banco.atividade.repositories;

import com.utfpr.banco.atividade.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    //3. Listar o primeiro departamento cadastrado.
    Departamento findFirstBy();
}
