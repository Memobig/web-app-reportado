package com.guilfram.reportado.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.guilfram.reportado.app.models.entity.Publicacion;
import com.guilfram.reportado.app.models.entity.PublicacionCaracteristica;
import com.guilfram.reportado.app.models.entity.Usuario;
import com.guilfram.reportado.app.models.service.IUsuarioService;

@SessionAttributes(names = { "usuario" })
@Controller
public class UsuarioController {

	public final Logger log = LoggerFactory.getLogger(UsuarioController.class);  
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/")
	public String index() {
		
		return "inicio";
	}
	
	@GetMapping("/busqueda")
	public String buscarPublicacion(@RequestParam(value = "q") String term, Model model, RedirectAttributes flash) {
		
		List<Publicacion> publicaciones = usuarioService.findByValor(term);
		
		//log.info("Valor del termino:" + term);
		
		if(publicaciones.isEmpty()) {
			flash.addFlashAttribute("error", "No se encontro información en la base de datos");
			
			return "redirect:/";
		}
		
		model.addAttribute("titulo", "REPO: Resultado de la busqueda -" + term + "");
		model.addAttribute("publicaciones", publicaciones);
		
		return "busqueda";
	}
	// /publicaciones/ciudad-de-mexico/tlahuac/15/mazda-3-2005
	@GetMapping("/publicaciones/*/*/*/*-id-{id}")
	public String publicaciones(@PathVariable("id") Long id, Model model, RedirectAttributes flash) {
		

		
		Publicacion publicacion = usuarioService.findPublicacionById(id);
		
		if (publicacion != null) {
			model.addAttribute("titulo", 
					publicacion.getTitulo() + " en " + publicacion.getLocalidad().getNombre());
			model.addAttribute("publicacion", publicacion);
			model.addAttribute("imagenes", publicacion.getImagenes());
		} else {
			flash.addFlashAttribute("error", "La publicación solicitada no existe");
			return "redirect:/";
		}
		
		return "publicacion";
	}
}
