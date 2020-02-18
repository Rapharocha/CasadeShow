package com.trabalho.casadeshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trabalho.casadeshow.model.Cadastrologin;
import com.trabalho.casadeshow.repository.CadastroUsuario;


@Controller
@RequestMapping("/cadastro")
public class CadastroController {

	 @Autowired
	 private CadastroUsuario user;
	
	 @RequestMapping	
	 public ModelAndView cadastro() {
		 ModelAndView mv = new ModelAndView("Cadastrar");
		 mv.addObject(new Cadastrologin());
		 return mv;
	 }	
	 
	 @RequestMapping(method= RequestMethod.POST)
	 public ModelAndView salvar(@Validated Cadastrologin cadastrologin, Errors errors) {
		 ModelAndView mv = new ModelAndView("Login"); 
		 ModelAndView mv1 = new ModelAndView("Cadastrar");
		 if(errors.hasErrors()) {
			 
			 return mv1;
		 }
		 
		 user.save(cadastrologin);
		 
		 return mv;
	 }
}
