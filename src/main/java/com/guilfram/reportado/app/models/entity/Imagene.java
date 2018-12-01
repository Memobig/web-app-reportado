package com.guilfram.reportado.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the imagenes database table.
 * 
 */
@Entity
@Table(name="imagenes")
@NamedQuery(name="Imagene.findAll", query="SELECT i FROM Imagene i")
public class Imagene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="texto_alt")
	private String textoAlt;

	private String url;

	//bi-directional many-to-many association to Publicacione
	@ManyToMany
	@JoinTable(
		name="publicacion_imagen"
		, joinColumns={
			@JoinColumn(name="imagen_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="publicacion_id")
			}
		)
	private List<Publicacion> publicaciones;

	public Imagene() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTextoAlt() {
		return this.textoAlt;
	}

	public void setTextoAlt(String textoAlt) {
		this.textoAlt = textoAlt;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Publicacion> getPublicaciones() {
		return this.publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

}