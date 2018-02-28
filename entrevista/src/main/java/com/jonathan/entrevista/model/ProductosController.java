package com.jonathan.entrevista.model;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.jonathan.entrevista.daosinterfaces.IProductos;
import com.jonathan.entrevista.daosinterfaces.ITipoProductos;
import com.jonathan.entrevista.mappingtables.Productos;
import com.jonathan.entrevista.mappingtables.TipoProductos;

@ManagedBean
public class ProductosController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "entrevista")
	private EntityManager em;

	@EJB
	private IProductos ip;

	@EJB
	private ITipoProductos itp;

	private Productos productos;

	private int idtp;

	public ProductosController() {
		this.productos = new Productos();
	}

	/*
	 * creating, business layer for Productos
	 */
	public List<TipoProductos> obtenerTipoProductos() {
		return itp.listTipoProductos(em);
	}

	public void agregaProductos() {
		TipoProductos ingresaTP = itp.searchProductos(em, getIdtp());
		this.productos.setTiposProductos(ingresaTP);
		ip.addProducto(em, this.productos);
	}

	public void deleteProductos() {
		ip.deleteProducto(em, this.productos.getIdProducto());
	}

	public List<Productos> productosLista() {
		return ip.listProductos(em);
	}

	/*
	 * start getters and setter to access productos since productos view
	 */

	public Productos getProductos() {
		return this.productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public int getIdtp() {
		return this.idtp;
	}

	public void setIdtp(int idtp) {
		this.idtp = idtp;
	}

}
