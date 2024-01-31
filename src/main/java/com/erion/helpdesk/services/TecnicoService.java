package com.erion.helpdesk.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erion.helpdesk.domain.Tecnico;
import com.erion.helpdesk.domain.dtos.TecnicoDTO;
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
    
    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico addTecnico(TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(null);
        Tecnico newTecnico = new Tecnico(tecnicoDTO);
        return tecnicoRepository.save(newTecnico);
    }
}
