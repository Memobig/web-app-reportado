package com.guilfram.reportado.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.guilfram.reportado.app.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByEmail(String email);
	
}
