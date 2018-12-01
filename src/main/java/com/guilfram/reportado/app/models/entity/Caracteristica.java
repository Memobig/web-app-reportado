package com.guilfram.reportado.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the caracteristicas database table.
 * 
 */
@Entity
@Table(name="caracteristicas")
@NamedQuery(name="Caracteristica.findAll", query="SELECT c FROM Caracteristica c")
public class Caracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	private Categoria categoria;

	//bi-directional many-to-one association to PublicacionCaracteristica
	@OneToMany(mappedBy="caracteristica")
	private List<PublicacionCaracteristica> publicacionCaracteristicas;

	public Caracteristica() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<PublicacionCaracteristica> getPublicacionCaracteristicas() {
		return this.publicacionCaracteristicas;
	}

	public void setPublicacionCaracteristicas(List<PublicacionCaracteristica> publicacionCaracteristicas) {
		this.publicacionCaracteristicas = publicacionCaracteristicas;
	}

	public PublicacionCaracteristica addPublicacionCaracteristica(PublicacionCaracteristica publicacionCaracteristica) {
		getPublicacionCaracteristicas().add(publicacionCaracteristica);
		publicacionCaracteristica.setCaracteristica(this);

		return publicacionCaracteristica;
	}

	public PublicacionCaracteristica removePublicacionCaracteristica(PublicacionCaracteristica publicacionCaracteristica) {
		getPublicacionCaracteristicas().remove(publicacionCaracteristica);
		publicacionCaracteristica.setCaracteristica(null);

		return publicacionCaracteristica;
	}

}