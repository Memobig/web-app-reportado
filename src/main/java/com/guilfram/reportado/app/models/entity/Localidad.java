package com.guilfram.reportado.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the localidad database table.
 * 
 */
@Entity
@Table(name="localidad")
@NamedQuery(name="Localidad.findAll", query="SELECT l FROM Localidad l")
public class Localidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int cp;

	private String nombre;

	private String zona;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	private Municipio municipio;

	//bi-directional many-to-one association to Publicacione
	@OneToMany(mappedBy="localidad")
	private List<Publicacion> publicaciones;

	public Localidad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCp() {
		return this.cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getZona() {
		return this.zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Publicacion> getPublicaciones() {
		return this.publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Publicacion addPublicacione(Publicacion publicacione) {
		getPublicaciones().add(publicacione);
		publicacione.setLocalidad(this);

		return publicacione;
	}

	public Publicacion removePublicacione(Publicacion publicacione) {
		getPublicaciones().remove(publicacione);
		publicacione.setLocalidad(null);

		return publicacione;
	}

}