package com.jonathan.entrevista.model;

import java.util.ArrayList;
import java.util.List;
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
		this.stock = new Stock();
	}

	public List<Stock> buscaStock() {
		this.listaStock = new ArrayList<Stock>();
		List<Stock> dec = is.listStock(em);
		for (Stock stock : dec) {
			if (stock.getCantidad() > 0) {
				this.listaStock.add(stock);
			}
		}
		return this.listaStock;
	}

	/*
	 * creating, business layer for Stock
	 * 
	 */

	public void agregarStock() throws Exception {
		Stock produc = buscarProducto();
		if (produc == null) {
			Productos producto = ip.searchProducto(em, this.getIdProducto());
			stock.setIdProducto(producto);
			is.addStock(em, this.stock);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Transaccion Exitosa!", "!producto guardado exitosamente!"));
		} else {
			is.updateStock(em, produc.getIdStock(), produc.getCantidad() + stock.getCantidad());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Transaccion Exitosa!", "!producto modificado exitosamente!"));
		}
	}

	private Stock buscarProducto() {
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

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
