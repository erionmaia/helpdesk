package com.erion.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erion.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
    
}
