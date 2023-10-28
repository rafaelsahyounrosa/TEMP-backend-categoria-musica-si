package com.utfpr.rafaelrosa.backendempresa;

import com.utfpr.rafaelrosa.backendempresa.entity.Departamento;
import com.utfpr.rafaelrosa.backendempresa.entity.Funcionario;
import com.utfpr.rafaelrosa.backendempresa.service.DepartamentoService;
import com.utfpr.rafaelrosa.backendempresa.service.FuncionarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendCategoriaMusicaSiApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendCategoriaMusicaSiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendCategoriaMusicaSiApplication.class, args);



	}

	@Bean
	public CommandLineRunner demo(DepartamentoService departamentoService,
								  FuncionarioService funcionarioService){
		return args -> {

			log.info("Listagem de todos os departamentos");
			log.info("----------------------------------------");
			for (Departamento departamento : departamentoService.listaTodos())
				log.info(departamento.toString());
			log.info("");


			log.info("Listagem de todos os funcionarios");
			log.info("----------------------------------------");
			for (Funcionario funcionario : funcionarioService.findAll())
				log.info(funcionario.toString());
			log.info("");
		};
	}

}
