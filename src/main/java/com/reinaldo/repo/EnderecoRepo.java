package com.reinaldo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reinaldo.models.Endereco;

@Repository
public interface EnderecoRepo extends JpaRepository<Endereco, Integer>{

}
