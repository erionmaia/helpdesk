package com.erion.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erion.helpdesk.domain.Chamado;
import com.erion.helpdesk.domain.Cliente;
import com.erion.helpdesk.domain.Tecnico;
import com.erion.helpdesk.domain.dtos.ChamadoDTO;
import com.erion.helpdesk.domain.enums.Prioridade;
import com.erion.helpdesk.domain.enums.Status;
import com.erion.helpdesk.repositories.ChamadoRepository;
import com.erion.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class ChamadoService {
    
    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id) {
        Optional<Chamado> chamadoObj = chamadoRepository.findById(id);
        return chamadoObj.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado para o ID: " + id));
    }

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }

    public Chamado addChamado(@Valid ChamadoDTO objChamado) {
        return chamadoRepository.save(newChamado(objChamado));
    }

    public Chamado update(Integer id, @Valid ChamadoDTO objChamadoDTO) {
        objChamadoDTO.setId(id);
        Chamado oldObjChamado = findById(id);
        oldObjChamado = newChamado(objChamadoDTO);
        return chamadoRepository.save(oldObjChamado);
    }

    private Chamado newChamado(ChamadoDTO chamadoDTOObj) {
        Tecnico tecnico = tecnicoService.findById(chamadoDTOObj.getCodTecnico());
        Cliente cliente = clienteService.findById(chamadoDTOObj.getCodCliente());

        Chamado chamado = new Chamado();
        if(chamadoDTOObj.getId() != null) {
            chamado.setId(chamadoDTOObj.getId());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(chamadoDTOObj.getCodPrioridade()));
        chamado.setStatus(Status.toEnum(chamadoDTOObj.getCodStatus()));
        chamado.setTitulo(chamadoDTOObj.getTitulo());
        chamado.setObservacoes(chamadoDTOObj.getObservacoes());
        return chamado;
    }
}
