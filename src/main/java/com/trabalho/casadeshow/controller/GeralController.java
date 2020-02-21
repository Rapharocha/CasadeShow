package com.trabalho.casadeshow.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GeralController {

 @RequestMapping(method = RequestMethod.GET, path = "/login")	
 public String login() {
	 
	 return "Login";
 }	
 
 @RequestMapping(method = RequestMethod.GET, path= "/historico")
 public ModelAndView historico() {
	 ModelAndView mv = new ModelAndView("Historico");
	 
	 return mv;
 }
}
