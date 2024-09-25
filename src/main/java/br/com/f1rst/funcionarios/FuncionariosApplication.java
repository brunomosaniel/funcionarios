package br.com.f1rst.funcionarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class FuncionariosApplication {

	public String getHomeTeste(){
		return "Funcionarios - API HOME";
	}


	public static void main(String[] args) {
		SpringApplication.run(FuncionariosApplication.class, args);
	}

}
