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
		
		/*
		Usuario user = usuarioService.findOne(1L);
		
		log.info("Usuario recuperado: " + user.getNombre() + " " + user.getApellido());
		
		for(Publicacion publicacion: user.getPublicaciones()) {
			
			log.info("Publicacion: " + publicacion.getCreateAt().toString());
			log.info("Detalles: " + publicacion.getDetalles());
			log.info("Estado: " + publicacion.getUbicacion().getEstado().getNombre());
			log.info("Municipio: " + publicacion.getUbicacion().getMunicipio().getNombre());
			log.info("Asentamiento: " + publicacion.getUbicacion().getAsentamiento().getNombre());
			//log.info("Email: " + publicacion.get);
			//caracteristicas
			for(PublicacionCaracteristica pc:publicacion.getPublicacionCaracteristicas()) {
				log.info("Categoria: " + pc.getCaracteristica().getCategoria().getNombre());
				log.info("Caracteristica: " + pc.getCaracteristica().getNombre());
				log.info("Valor: " + pc.getValor());
			}
		}
		*/
		return "inicio";
	}
	
	@GetMapping("/busqueda")
	public String buscarPublicacion(@RequestParam(value = "q") String term, Model model, RedirectAttributes flash) {
		
		List<Publicacion> publicaciones = usuarioService.findByValor(term);
		
		log.info("Valor del termino:" + term);
		
		if(publicaciones.isEmpty()) {
			flash.addFlashAttribute("error", "No se encontro información en la base de datos");
			
			return "redirect:/";
		}
		
		model.addAttribute("titulo", "REPO: Resultado de la busqueda -" + term + "");
		model.addAttribute("publicaciones", publicaciones);
		
		return "busqueda";
	}
}
