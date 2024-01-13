package com.erion.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erion.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    
}
