package com.guilfram.reportado.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

	@GetMapping("/")
	public String index() {
		
		return "inicio";
	}
}