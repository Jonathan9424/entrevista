package com.jonathan.entrevista.mappingtables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "STOCK")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_stock")
	private int idStock;

	@OneToOne
	@JoinColumn(name = "id_producto")
	private Productos idProducto;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "valor")
	private int valor;

	@Column(name = "iva")
	private int iva;

	/*
	 * start getter and setter to access stock
	 */

	public int getIdStock() {
		return this.idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public Productos getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Productos idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getIva() {
		return this.iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

}
