package com.erion.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erion.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
