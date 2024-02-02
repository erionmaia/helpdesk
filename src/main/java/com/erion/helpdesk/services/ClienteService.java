package com.erion.helpdesk.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erion.helpdesk.domain.Cliente;
import com.erion.helpdesk.domain.Pessoa;
import com.erion.helpdesk.domain.dtos.ClienteDTO;
import com.erion.helpdesk.domain.dtos.TecnicoDTO;
import com.erion.helpdesk.repositories.ClienteRepository;
import com.erion.helpdesk.repositories.PessoaRepository;
import com.erion.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

import com.erion.helpdesk.services.exceptions.DataIntegrityViolationException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found by ID: " + id));
    }
    
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente addCliente(ClienteDTO clienteDTO) {
        clienteDTO.setId(null);
        validaPorCpfEEmail(clienteDTO);
        Cliente newCliente = new Cliente(clienteDTO);
        return clienteRepository.save(newCliente);
    }

    public Cliente updateCliente(Integer id, @Valid ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        Cliente oldCliente = findById(id);
        validaPorCpfEEmail(clienteDTO);
        oldCliente = new Cliente(clienteDTO);
        return clienteRepository.save(oldCliente);
    }

    public void deleteCliente(Integer id) {
        Cliente oldCliente = findById(id);
        if(oldCliente.getChamados().size() > 0) {
            throw new DataIntegrityViolationException("Este Cliente possui ordens de serviço e não pode ser deletado!");
        } else {
            clienteRepository.deleteById(id);
        };
    }

    private void validaPorCpfEEmail(ClienteDTO clienteDTO) {
        Optional<Pessoa> newPessoa = pessoaRepository.findByCpf(clienteDTO.getCpf());
        if(newPessoa.isPresent() && newPessoa.get().getId() != clienteDTO.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado na base de dados");
        };
        newPessoa = pessoaRepository.findByEmail(clienteDTO.getEmail());
        if(newPessoa.isPresent() && newPessoa.get().getId() != clienteDTO.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado na base de dados");
        };
    }

    
}
