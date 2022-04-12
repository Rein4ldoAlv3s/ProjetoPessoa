package com.reinaldo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.models.Cidade;
import com.reinaldo.models.Cliente;
import com.reinaldo.models.Endereco;
import com.reinaldo.models.Estado;
import com.reinaldo.models.enums.TipoCliente;
import com.reinaldo.repo.CidadeRepo;
import com.reinaldo.repo.ClienteRepo;
import com.reinaldo.repo.EnderecoRepo;
import com.reinaldo.repo.EstadoRepo;

@SpringBootApplication
public class ProjetoPessoaApplication implements CommandLineRunner{

	@Autowired
	private CidadeRepo cidadeRepo;
	@Autowired
	private EstadoRepo estadoRepo;
	@Autowired
	private EnderecoRepo enderecoRepo;
	@Autowired
	private ClienteRepo clienteRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoPessoaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estado est1 = new Estado(null, "Goiás");
		
		Cidade cid1 = new Cidade(null, "Goiânia", est1);
		
		est1.getCidades().add(cid1);
		
		Endereco end1 = new Endereco(null, "Av T3", "42", "Rua Laranjeiras", 
				"Bairro Sao francisco", "740000", cid1);
		
		cid1.getEnderecos().add(end1);
		
		Cliente cli1 = new Cliente(null, "Ricardo", "ricardo@yahoo.com", 
				"049588230211", TipoCliente.PESSOAFISICA);
		
		end1.setCliente(cli1);
		cli1.getEnderecos().add(end1);
		
		cidadeRepo.save(cid1);
		estadoRepo.save(est1);
		enderecoRepo.save(end1);
		clienteRepo.save(cli1);
		
		
		
	}

}
