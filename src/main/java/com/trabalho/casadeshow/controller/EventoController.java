package com.trabalho.casadeshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trabalho.casadeshow.model.Cadastroevento;
import com.trabalho.casadeshow.repository.Cadastrocasaeventos;

@Controller
@RequestMapping("/eventos")
public class EventoController {
	
	 @Autowired
	 private Cadastrocasaeventos casaeventos;
	
	 @RequestMapping(method = RequestMethod.GET)
	 public String eventos() {
		 return "Eventos";
	 }
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public String salvar(Cadastroevento cadastroevento) {
		 
		 casaeventos.save(cadastroevento);
		 
		 return "Eventos";
	 }
	 

}
