package com.guilfram.reportado.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the publicaciones database table.
 * 
 */
@Entity
@Table(name="publicaciones")
@NamedQuery(name="Publicacion.findAll", query="SELECT p FROM Publicacion p")
public class Publicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String titulo;
	
	private String detalles;

	//bi-directional many-to-one association to PublicacionCaracteristica
	@OneToMany(mappedBy="publicacion")
	private List<PublicacionCaracteristica> publicacionCaracteristicas;

	//bi-directional many-to-many association to Imagene
	@ManyToMany(mappedBy="publicaciones")
	private List<Imagene> imagenes;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	private Categoria categoria;
	
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	//bi-directional many-to-one association to Localidad
	@ManyToOne
	private Localidad localidad;

	public Publicacion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDetalles() {
		return this.detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public List<PublicacionCaracteristica> getPublicacionCaracteristicas() {
		return this.publicacionCaracteristicas;
	}

	public void setPublicacionCaracteristicas(List<PublicacionCaracteristica> publicacionCaracteristicas) {
		this.publicacionCaracteristicas = publicacionCaracteristicas;
	}

	public PublicacionCaracteristica addPublicacionCaracteristica(PublicacionCaracteristica publicacionCaracteristica) {
		getPublicacionCaracteristicas().add(publicacionCaracteristica);
		publicacionCaracteristica.setPublicacion(this);

		return publicacionCaracteristica;
	}

	public PublicacionCaracteristica removePublicacionCaracteristica(PublicacionCaracteristica publicacionCaracteristica) {
		getPublicacionCaracteristicas().remove(publicacionCaracteristica);
		publicacionCaracteristica.setPublicacion(null);

		return publicacionCaracteristica;
	}

	public List<Imagene> getImagenes() {
		return this.imagenes;
	}

	public void setImagenes(List<Imagene> imagenes) {
		this.imagenes = imagenes;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Localidad getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

}