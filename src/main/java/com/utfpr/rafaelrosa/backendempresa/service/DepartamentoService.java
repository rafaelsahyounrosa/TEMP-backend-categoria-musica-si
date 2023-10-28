package com.utfpr.rafaelrosa.backendempresa.service;

import com.utfpr.rafaelrosa.backendempresa.entity.Departamento;
import com.utfpr.rafaelrosa.backendempresa.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> listaTodos(){
        return departamentoRepository.findAll();
    }
}
