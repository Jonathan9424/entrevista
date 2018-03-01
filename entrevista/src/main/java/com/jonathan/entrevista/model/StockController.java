package com.jonathan.entrevista.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jonathan.entrevista.daosinterfaces.IProductos;
import com.jonathan.entrevista.daosinterfaces.IStock;
import com.jonathan.entrevista.mappingtables.Productos;
import com.jonathan.entrevista.mappingtables.Stock;

@ManagedBean
public class StockController {

	@PersistenceContext(name = "entrevista")
	private EntityManager em;

	@EJB
	private IStock is;

	@EJB
	private IProductos ip;

	private Stock stock;
	private int idProducto;
	private List<Stock> listaStock;

	public StockController() {

	}

	@PostConstruct
	public void buscaStock() {
		this.listaStock = new ArrayList<Stock>();
		this.listaStock = is.listStock(em);
	}

	/*
	 * creating, business layer for Stock
	 * 
	 */

	public void agregarStock() {
		if (!buscarProductoStock()) {
			Productos producto = ip.searchProducto(em, getIdProducto());
			stock.setIdProducto(producto);
			is.addStock(em, this.stock);
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "!Producto ya existente en stock!"));
		}
	}

	public boolean buscarProductoStock() {
		Stock produc = buscarProducto();
		for (int i = 0; i < this.listaStock.size(); i++) {
			Stock ps = (Stock) this.listaStock.get(i);
			if (ps.getIdProducto() == produc.getIdProducto()) {
				return true;
			}
		}
		return false;
	}

	public Stock buscarProducto() {
		return is.searchStock(em, this.getIdProducto());
	}

	public List<Productos> listaProductos() {
		return ip.listProductos(em);
	}

	/*
	 * start getters and setters to access public
	 */

	public List<Stock> getListaStock() {
		return this.listaStock;
	}

	public void setListaStock(List<Stock> listaStock) {
		this.listaStock = listaStock;
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idStock) {
		this.idProducto = idStock;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
