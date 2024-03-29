package com.erion.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.erion.helpdesk.domain.Tecnico;
import com.erion.helpdesk.domain.dtos.TecnicoDTO;
import com.erion.helpdesk.services.TecnicoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResources {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
        Tecnico obj = tecnicoService.findById(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll() {
        List<Tecnico> list = tecnicoService.findAll();
        List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> addTecnico(@Valid @RequestBody TecnicoDTO tecnicoDTO) {
        Tecnico newTecnico = tecnicoService.addTecnico(tecnicoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTecnico.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<TecnicoDTO> updateTecnico(@PathVariable Integer id, @RequestBody TecnicoDTO tecnicoDTO) {
        Tecnico oldTecnico = tecnicoService.updateTecnico(id, tecnicoDTO);
        return ResponseEntity.ok().body(new TecnicoDTO(oldTecnico));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<TecnicoDTO> deleteTecnico(@PathVariable Integer id) {
        tecnicoService.deleteTecnico(id);
        return ResponseEntity.noContent().build();
    }
}