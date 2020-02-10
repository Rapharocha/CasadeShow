package com.trabalho.casadeshow.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class GeralController {

 @RequestMapping(method = RequestMethod.GET, path = "/login")	
 public String login() {
	 
	 return "Cadastro";
 }	
 
 @RequestMapping(method = RequestMethod.GET, path ="/")
 public String Inicio() {
	 
	 return "Inicio";
  } 
  
 @RequestMapping(method = RequestMethod.GET, path ="/historico")
 public String historico() {
	 return "Historico";
 }
}
