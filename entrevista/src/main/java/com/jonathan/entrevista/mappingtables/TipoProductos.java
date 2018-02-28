package com.jonathan.entrevista.mappingtables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tipo_productos")
public class TipoProductos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_productos")
	private int idTipoProductos;

	@Column(name = "nombre")
	private String nombre;

	/*
	 * start getters and setters to access tipo productos
	 */

	public int getIdTipoProductos() {
		return this.idTipoProductos;
	}

	public void setIdTipoProductos(int idTipoProductos) {
		this.idTipoProductos = idTipoProductos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
