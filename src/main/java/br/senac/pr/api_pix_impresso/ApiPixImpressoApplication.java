package br.senac.pr.api_pix_impresso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senac.pr.api_pix_impresso.models.Caixa;
import br.senac.pr.api_pix_impresso.repository.JdbcCaixaRepository;

@SpringBootApplication
public class ApiPixImpressoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPixImpressoApplication.class, args);

		JdbcCaixaRepository caixaRepository = new JdbcCaixaRepository();
		caixaRepository.save(new Caixa("Caixa 1", 100.0));
		caixaRepository.save(new Caixa("Caixa 2", 200.0));
		caixaRepository.save(new Caixa("Caixa 3", 300.0));
	}

}
