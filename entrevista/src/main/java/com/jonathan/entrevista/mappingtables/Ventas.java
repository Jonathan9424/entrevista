package com.jonathan.entrevista.mappingtables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "VENTAS")
public class Ventas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venta")
	private int idVenta;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Productos idProducto;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "valor_unitario")
	private int valorUnitario;

	@Column(name = "vale")
	private int iva;

	@Column(name = "valor_total")
	private int valorTotal;

	/*
	 * start getters and setters to access ventas
	 */

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
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

	public int getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getIva() {
		return this.iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getValorTotal() {
		return this.valorTotal;
	}

	public void setVelorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

}
