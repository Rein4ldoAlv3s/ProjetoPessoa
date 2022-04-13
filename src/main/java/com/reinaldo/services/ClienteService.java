package com.reinaldo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.models.Cliente;
import com.reinaldo.repo.ClienteRepo;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepo clienteRepo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienteRepo.findById(id);
		return obj.orElse(null);
	}
}
