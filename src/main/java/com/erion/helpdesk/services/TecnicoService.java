package com.erion.helpdesk.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erion.helpdesk.domain.Pessoa;
import com.erion.helpdesk.domain.Tecnico;
import com.erion.helpdesk.domain.dtos.TecnicoDTO;
import com.erion.helpdesk.repositories.PessoaRepository;
import com.erion.helpdesk.repositories.TecnicoRepository;
import com.erion.helpdesk.services.exceptions.ObjectNotFoundException;
import com.erion.helpdesk.services.exceptions.DataIntegrityViolationException;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found by ID: " + id));
    }
    
    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico addTecnico(TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(null);
        validaPorCpfEEmail(tecnicoDTO);
        Tecnico newTecnico = new Tecnico(tecnicoDTO);
        return tecnicoRepository.save(newTecnico);
    }

    private void validaPorCpfEEmail(TecnicoDTO tecnicoDTO) {
        Optional<Pessoa> newPessoa = pessoaRepository.findByCpf(tecnicoDTO.getCpf());
        if(newPessoa.isPresent() && newPessoa.get().getId() != tecnicoDTO.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado na base de dados");
        };
        newPessoa = pessoaRepository.findByEmail(tecnicoDTO.getEmail());
        if(newPessoa.isPresent() && newPessoa.get().getId() != tecnicoDTO.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado na base de dados");
        };
    }
}
