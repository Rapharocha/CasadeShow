package com.trabalho.casadeshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trabalho.casadeshow.model.Cadastrologin;
import com.trabalho.casadeshow.repository.CadastroUsuario;


@Controller
@RequestMapping("/cadastro")
public class CadastroController {

	 @Autowired
	 private CadastroUsuario user;
	
	 @RequestMapping	
	 public String cadastro() {
		 
		 return "Cadastrar";
	 }	
	 
	 @RequestMapping(method= RequestMethod.POST)
	 public String salvar(Cadastrologin cadastrologin) {
		 user.save(cadastrologin);
		 return "Login";
	 }
}
