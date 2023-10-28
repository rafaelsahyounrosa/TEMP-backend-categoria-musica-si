package com.utfpr.rafaelrosa.backendempresa.service;

import com.utfpr.rafaelrosa.backendempresa.entity.Funcionario;
import com.utfpr.rafaelrosa.backendempresa.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }
}
