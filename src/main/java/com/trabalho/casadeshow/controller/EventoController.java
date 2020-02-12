package com.trabalho.casadeshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trabalho.casadeshow.model.Cadastrocasa;
import com.trabalho.casadeshow.model.Cadastroevento;
import com.trabalho.casadeshow.repository.Cadastrocasaeventos;
import com.trabalho.casadeshow.repository.Cadastroshow;

@Controller
@RequestMapping("/eventos")
public class EventoController {
	
	 @Autowired
	 private Cadastrocasaeventos casaeventos;
	 @Autowired
	 private Cadastroshow cadastrodeshow;
	
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView eventos() {
		 ModelAndView mv = new ModelAndView("Eventos");
		 List<Cadastrocasa>todosCadastro = cadastrodeshow.findAll();
		 mv.addObject("listacasas", todosCadastro);
		 return mv;
	 }
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public String salvar(Cadastroevento cadastroevento) {
		 casaeventos.save(cadastroevento);
		 return "Eventos";
	 }
	 

}
