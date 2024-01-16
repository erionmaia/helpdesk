package com.erion.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.erion.helpdesk.domain.Chamado;
import com.erion.helpdesk.domain.Cliente;
import com.erion.helpdesk.domain.Tecnico;
import com.erion.helpdesk.domain.enums.Perfil;
import com.erion.helpdesk.domain.enums.Prioridade;
import com.erion.helpdesk.domain.enums.Status;
import com.erion.helpdesk.repositories.ChamadoRepository;
import com.erion.helpdesk.repositories.ClienteRepository;
import com.erion.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

    @Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	@Bean
    public void instanciaDB(){
        Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "42497501084", "valdir@mail.com", "123");
		Tecnico tec2 = new Tecnico(null, "Erion Maia", "97544627047", "erion@mail.com", "456");
		Tecnico tec3 = new Tecnico(null, "Miguel Maia", "99187752034", "miguelito@mail.com", "789");
		Tecnico tec4 = new Tecnico(null, "Tunico da Silva", "31574483072", "tunico@mail.com.br", "123456");
		Tecnico tec5 = new Tecnico(null, "Pedro Alvares Cabral", "59466268090", "pedrinho@mail.com.pt", "135");
		Tecnico tec6 = new Tecnico(null, "Chevrolet da Silva Ford", "31195494017", "chedasilvafor@email.com", "54321");
		Tecnico tec7 = new Tecnico(null, "Simplicio Simplorio da Simplicidade Simples", "59391711090", "simples@justmail.com", "246");
		tec1.addPerfil(Perfil.ADMIN);
		tec2.addPerfil(Perfil.ADMIN);
		tec3.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "76872011084", "torvalds@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Lorena Gonçalves", "89920441007", "lorena@mail.com", "456");
		Cliente cli3 = new Cliente(null, "Laura Maia", "48054203080", "laura@mail.com", "789");
		Cliente cli4 = new Cliente(null, "Thays Maia", "68650564003", "thays@mail.com", "987");
		Cliente cli5 = new Cliente(null, "Thayane Villar", "57398993030", "thayane@mail.com", "654");
		Cliente cli6 = new Cliente(null, "Alan Lima", "90767141008", "alan@mail.com", "123456");
		Cliente cli7 = new Cliente(null, "Maria Eduarda", "91037762045", "dudinha@mail.com", "654321");
		Cliente cli8 = new Cliente(null, "Demontie de Araujo", "58486282039", "demontie@mail.com", "12345");
		Cliente cli9 = new Cliente(null, "Pedrita da Pedra", "85602432086", "pedrita@mail.com", "54321");
		Cliente cli10 = new Cliente(null, "Jack Nicholson", "91767633076", "jackni@mail.com", "135");
		Cliente cli11 = new Cliente(null, "Fabiano Cambota", "75447917000", "fabiano@mail.com", "246");
		Cliente cli12 = new Cliente(null, "Thiago Ventura", "80181104091", "thiago@mail.com", "123");
		Cliente cli13 = new Cliente(null, "Rodrigo Marques", "89031502014", "rodrigo@mail.com", "1357");
		Cliente cli14 = new Cliente(null, "Rafael Portugal", "65604386006", "rafael@mail.com", "2468");
		Cliente cli15 = new Cliente(null, "Nando Viana", "73338850034", "nando@mail.com", "8642");
		Cliente cli16 = new Cliente(null, "Edinalva da Silva", "49267979094", "edinalva@mail.com", "7531");
		Cliente cli17 = new Cliente(null, "Frank Lindner", "57335085071", "frank@mail.com", "1234");
		Cliente cli18 = new Cliente(null, "Edson Alexandre", "39332310009", "edson@mail.com", "4321");
		Cliente cli19 = new Cliente(null, "Tomasz Zawada", "32922322017", "tomasz@mail.com", "98765");
		Cliente cli20 = new Cliente(null, "Jakub Zawada", "38211584093", "jakub@mail.com", "56789");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 02", "Primeiro chamado", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 03", "Primeiro chamado", tec3, cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 04", "Primeiro chamado", tec4, cli4);
		Chamado c5 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 05", "Primeiro chamado", tec5, cli5);
		Chamado c6 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 06", "Primeiro chamado", tec6, cli6);
		Chamado c7 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 07", "Primeiro chamado", tec7, cli7);
		Chamado c8 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 08", "Primeiro chamado", tec6, cli8);
		Chamado c9 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 09", "Primeiro chamado", tec5, cli9);
		Chamado c10 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 10", "Primeiro chamado", tec4, cli10);


		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, tec6, tec7));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6, cli7, cli8, cli9, cli10, cli11, cli12, cli13, cli14, cli15, cli16, cli17, cli18, cli19, cli20));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
    }
    
}
