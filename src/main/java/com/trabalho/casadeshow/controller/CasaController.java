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
	  mv.addObject(new Cadastrocasa());
	  List<Cadastrocasa>todosCadastro = cadastrodeshow.findAll();
  	  mv.addObject("cadastro", todosCadastro);
     return mv;
	 }
	 
	 @RequestMapping("{codigo}")
	 public ModelAndView editar(@PathVariable("codigo") Cadastrocasa cadastro) {
		 

		ModelAndView mv = new ModelAndView("CasasdeShow");
		mv.addObject(cadastro);
		return mv;
	 }
	 
	 @RequestMapping(value = "{codigo}", method = RequestMethod.POST)
	 public String excluir(@PathVariable Long codigo) {
	 cadastrodeshow.deleteById(codigo);
	 
	 return "redirect:/casasdeshow";
	 }
	 
	 
	
}
