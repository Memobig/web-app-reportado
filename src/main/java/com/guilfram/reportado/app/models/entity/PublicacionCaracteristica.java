package com.guilfram.reportado.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the publicacion_caracteristica database table.
 * 
 */
@Entity
@Table(name="publicacion_caracteristica")
@NamedQuery(name="PublicacionCaracteristica.findAll", query="SELECT p FROM PublicacionCaracteristica p")
public class PublicacionCaracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String valor;

	//bi-directional many-to-one association to Publicacione
	@ManyToOne
	@JoinColumn(name="publicacion_id")
	private Publicacion publicacion;

	//bi-directional many-to-one association to Caracteristica
	@ManyToOne
	private Caracteristica caracteristica;

	public PublicacionCaracteristica() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacione) {
		this.publicacion = publicacione;
	}

	public Caracteristica getCaracteristica() {
		return this.caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

}