package com.trabalho.casadeshow.controller;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trabalho.casadeshow.model.Cadastroevento;
import com.trabalho.casadeshow.model.Cadastrologin;
import com.trabalho.casadeshow.model.Vendas;
import com.trabalho.casadeshow.repository.Cadastrocasaeventos;
import com.trabalho.casadeshow.repository.VendasRepository;


@Controller
@RequestMapping("/")
public class TelaCompraController {
	
	@Autowired
	 private Cadastrocasaeventos casaeventos;
	
	@Autowired
	private VendasRepository vendasRepository;
	
	@RequestMapping
	public ModelAndView inicio() {
		
		 ModelAndView mv = new ModelAndView("Inicio");
	
		 List<Cadastroevento>cadastroeventos = casaeventos.findAll();
		 mv.addObject("evento", cadastroeventos);
		 return mv;
		 
	}
	@RequestMapping("{codigo}/{username}")
	public String comprar(@PathVariable Long codigo, RedirectAttributes attributes,@PathVariable String username) {
		ModelAndView mv = new ModelAndView("Inicio");
		Optional<Cadastroevento>Eventostodos = casaeventos.findById(codigo);
		
		int menosum = 1;
		if(Eventostodos.get().getIngresso()>0) {
			Eventostodos.get().setIngresso(Eventostodos.get().getIngresso()-menosum);
			mv.addObject(Eventostodos.get().getIngresso());
			casaeventos.save(Eventostodos.get());}
		else {
			attributes.addFlashAttribute("mensagem","ESGOTADO!!!");
		}
		
		Vendas vendas = vendasRepository.findByUsuarioAndEventos(username, codigo);
		if(vendas == null) {
			Vendas salvarvendas = new Vendas();
			salvarvendas.setIngressosComprados(1);
			salvarvendas.setValorTotal(Eventostodos.get().getValor());
			Cadastrologin cadastrologin = new Cadastrologin();
			cadastrologin.setUsername(username);
			salvarvendas.setUsuario(cadastrologin);
			salvarvendas.setEvento(Eventostodos.get());
			vendasRepository.save(salvarvendas);
		}else {
			vendas.setIngressosComprados(vendas.getIngressosComprados()+1);
			vendas.setValorTotal(Eventostodos.get().getValor() * vendas.getIngressosComprados());
			vendasRepository.save(vendas);
		}
		
		
		return "redirect:/";
	}	
}
