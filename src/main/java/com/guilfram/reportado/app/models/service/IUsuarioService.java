package com.guilfram.reportado.app.models.service;

import java.util.List;

import com.guilfram.reportado.app.models.entity.Publicacion;
import com.guilfram.reportado.app.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	
	public void save(Usuario usuario);
	
	public Usuario findOne(Long id);
	
	public void delete(Long id);
	
	public List<Publicacion> findByValor(String term);
	
	public void savePublicacion(Publicacion publicacion);
	
	public Publicacion findPublicacionById(Long id);
	
	public void deletePublicacion(Long id);
	
	public Publicacion fetchPublicacionByIdWithUbicacionWithCaracteristicas(Long id);
	
}
