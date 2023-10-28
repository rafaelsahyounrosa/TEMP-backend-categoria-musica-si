package com.utfpr.rafaelrosa.backendempresa.repository;

import com.utfpr.rafaelrosa.backendempresa.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
