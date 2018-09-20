package com.guilfram.reportado.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "publicaciones")
public class Publicacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String detalles;
	
	private String titulo;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createAt;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "publicacion_id")
	private List<PublicacionCaracteristica> publicacionCaracteristicas;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Ubicacion ubicacion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PublicacionCaracteristica> getPublicacionCaracteristicas() {
		return publicacionCaracteristicas;
	}

	public void setPublicacionCaracteristicas(List<PublicacionCaracteristica> publicacionCaracteristicas) {
		this.publicacionCaracteristicas = publicacionCaracteristicas;
	}

	public String getDetalles() {
		return detalles;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	private static final long serialVersionUID = 1L;

}
