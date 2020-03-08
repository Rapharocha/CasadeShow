package com.trabalho.casadeshow.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trabalho.casadeshow.model.Cadastroevento;
import com.trabalho.casadeshow.model.Cadastrologin;
import com.trabalho.casadeshow.model.Vendas;
import com.trabalho.casadeshow.repository.Cadastrocasaeventos;
import com.trabalho.casadeshow.repository.VendasRepository;


@Controller
public class GeralController {

	@Autowired
	private VendasRepository vendasRepository;
	
	@Autowired
	private Cadastrocasaeventos eventosRepository;
	
 @RequestMapping(method = RequestMethod.GET, path = "/login")	
 public String login() {
	 
	 return "Login";
 }	
 
 @RequestMapping("/historico/{username}")
 public ModelAndView historico(@PathVariable String username,Vendas venda,Integer ingressosComprados,Long codigo) {
	 ModelAndView mv = new ModelAndView("Historico");
	 List<Vendas> vendas = vendasRepository.findByUsername(username);
	 mv.addObject("vendas", vendas);
	 	 
	
	 return mv;
 }
}
