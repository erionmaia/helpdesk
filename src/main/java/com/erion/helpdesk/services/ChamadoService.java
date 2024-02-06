package com.erion.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erion.helpdesk.domain.Chamado;
import com.erion.helpdesk.repositories.ChamadoRepository;
import com.erion.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
    
    @Autowired
    private ChamadoRepository chamadoRepository;

    public Chamado findById(Integer id) {
        Optional<Chamado> chamadoObj = chamadoRepository.findById(id);
        return chamadoObj.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado para o ID: " + id));
    }

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }
}
