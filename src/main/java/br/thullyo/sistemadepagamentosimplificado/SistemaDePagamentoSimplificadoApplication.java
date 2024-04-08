package br.thullyo.sistemadepagamentosimplificado;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Sistema de pagamento API", version = "1.0", description = "API para validações de transações"))
public class SistemaDePagamentoSimplificadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDePagamentoSimplificadoApplication.class, args);
	}

}
