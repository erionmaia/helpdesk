package com.erion.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tecnico extends Pessoa {

    private List<Chamado> chamados = new ArrayList<>();   
}
