package com.trabalho.casadeshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.trabalho.casadeshow.model.Cadastrocasa;
import com.trabalho.casadeshow.repository.Cadastroshow;




@Controller
@RequestMapping("/casasdeshow")
public class CasaController {

	
     @Autowired	
 private Cadastroshow cadastrodeshow;
	
    @RequestMapping
     public ModelAndView casas() {
    	ModelAndView mv = new ModelAndView("CasasdeShow");
    	mv.addObject(new Cadastrocasa());
    	List<Cadastrocasa>todosCadastro = cadastrodeshow.findAll();
    	mv.addObject("cadastro", todosCadastro);
    	 return mv;
     }
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public ModelAndView salvar(@Validated Cadastrocasa cadastrocasa, Errors errors) {
      ModelAndView mv = new ModelAndView("CasasdeShow"); 	 
		if(errors.hasErrors()) {
			List<Cadastrocasa>todosCadastro = cadastrodeshow.findAll();
		  	mv.addObject("cadastro", todosCadastro);
			return mv;
		}
      
	  cadastrodeshow.save(cadastrocasa);
	  
	  mv.addObject("mensagem","Casa de Show cadastrada com sucesso!");
	  
	  List<Cadastrocasa>todosCadastro = cadastrodeshow.findAll();
  	  mv.addObject("cadastro", todosCadastro);
     return mv;
	 }
	
}
