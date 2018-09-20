package com.guilfram.reportado.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "caracteristicas")
public class Caracteristica implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "caracteristica_id")
	private List<PublicacionCaracteristica> publicacionCaracteristicas;

	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<PublicacionCaracteristica> getPublicacionCaracteristicas() {
		return publicacionCaracteristicas;
	}

	public void setPublicacionCaracteristicas(List<PublicacionCaracteristica> publicacionCaracteristicas) {
		this.publicacionCaracteristicas = publicacionCaracteristicas;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	private static final long serialVersionUID = 1L;

}
