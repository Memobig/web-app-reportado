package com.guilfram.reportado.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guilfram.reportado.app.models.dao.IPublicacionDao;
import com.guilfram.reportado.app.models.dao.IUsuarioDao;
import com.guilfram.reportado.app.models.entity.Publicacion;
import com.guilfram.reportado.app.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IPublicacionDao publicacionDao;
	
	@Override
	public List<Usuario> findAll() {
		
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long id) {
		
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		usuarioDao.deleteById(id);
	}



	@Override
	@Transactional
	public void savePublicacion(Publicacion publicacion) {
		
		publicacionDao.save(publicacion);
	}

	@Override
	@Transactional(readOnly = true)
	public Publicacion findPublicacionById(Long id) {
		
		return publicacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deletePublicacion(Long id) {
		
		publicacionDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Publicacion fetchPublicacionByIdWithUbicacionWithCaracteristicas(Long id) {
		
		return publicacionDao.fetchPublicacionByIdWithUbicacionWithCaracteristicas(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Publicacion> findByValor(String term) {
		
		return publicacionDao.findPublicacionByValor(term);
	}

}
