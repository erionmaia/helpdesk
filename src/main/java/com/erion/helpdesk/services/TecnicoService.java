package com.erion.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erion.helpdesk.domain.Tecnico;
import com.erion.helpdesk.repositories.TecnicoRepository;
import com.erion.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found by ID: " + id));
    }
    
}
