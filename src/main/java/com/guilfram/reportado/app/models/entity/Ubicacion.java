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
@Table(name = "ubicacion")
public class Ubicacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String calle;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ubicacion_id")
	private List<Publicacion> publicaciones;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Municipio municipio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Asentamiento asentamiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Estado estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Asentamiento getAsentamiento() {
		return asentamiento;
	}

	public void setAsentamiento(Asentamiento asentamiento) {
		this.asentamiento = asentamiento;
	}

	private static final long serialVersionUID = 1L;

}
