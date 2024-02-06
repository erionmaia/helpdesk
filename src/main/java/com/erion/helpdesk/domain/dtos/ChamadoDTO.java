package com.erion.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.erion.helpdesk.domain.Chamado;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ChamadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private Integer codPrioridade;
    private Integer codStatus;
    private String titulo;
    private String observacoes;
    private Integer codTecnico;
    private String nomeTecnico;
    private Integer codCliente;
    private String nomeCliente;
    
    public ChamadoDTO() {
        super();
    }
    public ChamadoDTO(Chamado chamadoDTO) {
        super();
        this.id = chamadoDTO.getId();
        this.dataAbertura = chamadoDTO.getDataAbertura();
        this.dataFechamento = chamadoDTO.getDataFechamento();
        this.codPrioridade = chamadoDTO.getPrioridade().getCodigo();
        this.codStatus = chamadoDTO.getStatus().getCodigo();
        this.titulo = chamadoDTO.getTitulo();
        this.observacoes = chamadoDTO.getTitulo();
        this.codTecnico = chamadoDTO.getTecnico().getId();
        this.nomeTecnico = chamadoDTO.getTecnico().getNome();
        this.codCliente = chamadoDTO.getCliente().getId();
        this.nomeCliente = chamadoDTO.getCliente().getNome();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getDataAbertura() {
        return dataAbertura;
    }
    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    public LocalDate getDataFechamento() {
        return dataFechamento;
    }
    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
    public Integer getCodPrioridade() {
        return codPrioridade;
    }
    public void setCodPrioridade(Integer codPrioridade) {
        this.codPrioridade = codPrioridade;
    }
    public Integer getCodStatus() {
        return codStatus;
    }
    public void setCodStatus(Integer codStatus) {
        this.codStatus = codStatus;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    public Integer getCodTecnico() {
        return codTecnico;
    }
    public void setCodTecnico(Integer codTecnico) {
        this.codTecnico = codTecnico;
    }
    public Integer getCodCliente() {
        return codCliente;
    }
    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }
    public String getNomeTecnico() {
        return nomeTecnico;
    }
    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
