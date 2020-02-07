package com.trabalho.casadeshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    	 return mv;
     }
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public ModelAndView salvar(Cadastrocasa cadastrocasa) {
	  ModelAndView mv = new ModelAndView("Eventos"); 
	  cadastrodeshow.save(cadastrocasa);
	  
	  
     return mv;
	 }
	
}
