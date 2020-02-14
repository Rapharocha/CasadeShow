package com.trabalho.casadeshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trabalho.casadeshow.model.Cadastroevento;
import com.trabalho.casadeshow.repository.Cadastrocasaeventos;

@Controller
@RequestMapping("/")
public class TelaCompraController {
	
	@Autowired
	 private Cadastrocasaeventos casaeventos;
	
	@RequestMapping
	public ModelAndView inicio() {
		
		 ModelAndView mv = new ModelAndView("Inicio");
	
		 List<Cadastroevento>cadastroeventos = casaeventos.findAll();
		 mv.addObject("evento", cadastroeventos);
		 return mv;
		 
	}
	public ModelAndView comprar(Cadastroevento cadastro) {
		ModelAndView mv = new ModelAndView("Inicio");

		return mv;
	}

	
}
