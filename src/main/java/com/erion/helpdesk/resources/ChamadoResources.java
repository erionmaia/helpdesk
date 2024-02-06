package com.erion.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.erion.helpdesk.domain.Chamado;
import com.erion.helpdesk.domain.dtos.ChamadoDTO;
import com.erion.helpdesk.services.ChamadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResources {
    
    @Autowired
    private ChamadoService chamadoService;

    @GetMapping(value="/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
        Chamado chamadoObj = chamadoService.findById(id);
        return ResponseEntity.ok().body(new ChamadoDTO(chamadoObj));
    }

    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll() {
        List<Chamado> listChamados = chamadoService.findAll();
        List<ChamadoDTO> listChamadosDTO = listChamados.stream().map(chamadoObj -> new ChamadoDTO(chamadoObj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listChamadosDTO);
    }

    @PostMapping
    public ResponseEntity<ChamadoDTO> addChamado(@Valid @RequestBody ChamadoDTO objChamado) {
        Chamado chamadoObj = chamadoService.addChamado(objChamado);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(chamadoObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ChamadoDTO> updateChamado(@PathVariable Integer id,@Valid @RequestBody ChamadoDTO objChamadoDTO) {
        Chamado newChamado = chamadoService.update(id, objChamadoDTO);
        return ResponseEntity.ok().body(new ChamadoDTO(newChamado));
    }
}
