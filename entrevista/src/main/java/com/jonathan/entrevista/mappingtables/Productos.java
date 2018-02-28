package com.jonathan.entrevista.mappingtables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private int idProducto;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "medidas")
	private String medidas;

	@Column(name = "tipo_material")
	private String tipoMaterial;

	@Column(name = "marca")
	private String marca;

	@ManyToOne
	@JoinColumn(name = "id_tipo_productos")
	private TipoProductos tipoProductos;

	/*
	 * start getters and setters to access
	 */

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMedidas() {
		return this.medidas;
	}

	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}

	public String getTipoMaterial() {
		return this.tipoMaterial;
	}

	public void setTipoMaterial(String tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public TipoProductos getTiposProductos() {
		return this.tipoProductos;
	}

	public void setTiposProductos(TipoProductos tipoProductos) {
		this.tipoProductos = tipoProductos;
	}
}
