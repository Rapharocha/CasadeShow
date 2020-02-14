package com.trabalho.casadeshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trabalho.casadeshow.model.Cadastrocasa;
import com.trabalho.casadeshow.model.Cadastroevento;
import com.trabalho.casadeshow.model.GeneroEvento;
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
		 mv.addObject("estiloevento", GeneroEvento.values());
		 
		 
		 List<Cadastroevento>cadastroeventos = casaeventos.findAll();
		 mv.addObject("evento", cadastroeventos);
		 
		 Cadastroevento cadastroevento = new Cadastroevento();
		 mv.addObject("cadastroevento",cadastroevento);
		 
		 List<Cadastrocasa>todosCadastro = cadastrodeshow.findAll();
		 mv.addObject("listacasas", todosCadastro);
		 return mv;
	 }
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public ModelAndView salvar(@Validated Cadastroevento cadastroevento, Errors errors) {
		 ModelAndView mv = new ModelAndView("Eventos");
		 if(errors.hasErrors()) {
			 mv.addObject("estiloevento", GeneroEvento.values());
			 List<Cadastroevento>cadastroeventos = casaeventos.findAll();
			 mv.addObject("evento", cadastroeventos);
			 List<Cadastrocasa>todosCadastro = cadastrodeshow.findAll();
			 mv.addObject("listacasas", todosCadastro);
			 return mv;
		 }
		 cadastroevento.setIngresso(cadastroevento.getCapacidade());
		 casaeventos.save(cadastroevento);
		 mv.addObject(new Cadastroevento());
		 mv.addObject("mensagem","Evento salvo com sucesso");
		 List<Cadastroevento>cadastroeventos = casaeventos.findAll();
		 mv.addObject("evento", cadastroeventos);
		 List<Cadastrocasa>todosCadastro = cadastrodeshow.findAll();
		 mv.addObject("listacasas", todosCadastro);
		 mv.addObject("estiloevento", GeneroEvento.values());
		 return mv;	 
	 }
	 
	 @RequestMapping("{codigo}")
	 public ModelAndView editar(@PathVariable("codigo") Cadastroevento cadastro ) {
		ModelAndView mv = new ModelAndView("Eventos");
		mv.addObject(cadastro);
		return mv;
	 }
	 
	 @RequestMapping(value = "{codigo}", method = RequestMethod.POST)
	 public String excluir(@PathVariable Long codigo) {
	 casaeventos.deleteById(codigo);
	 
	 return "redirect:/eventos";
	 }
	 

}
