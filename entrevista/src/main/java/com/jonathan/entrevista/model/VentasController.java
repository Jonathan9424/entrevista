package com.jonathan.entrevista.model;

import java.io.Serializable;
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
import com.jonathan.entrevista.daosinterfaces.IVentas;
import com.jonathan.entrevista.mappingtables.Productos;
import com.jonathan.entrevista.mappingtables.Stock;
import com.jonathan.entrevista.mappingtables.Ventas;

@ManagedBean
public class VentasController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "entrevista")
	private EntityManager em;

	@EJB
	private IVentas iv;

	@EJB
	private IStock is;

	@EJB
	private IProductos ip;
	private int idProducto;
	private Ventas ventas;

	private List<Stock> disponibles;

	public VentasController() {
		this.ventas = new Ventas();
	}

	public void realizaCompra() {
		Productos pro = ip.searchProducto(em, this.getIdProducto());
		Stock st = is.searchStock(em, pro.getIdProducto());
		if ((st.getCantidad() - this.ventas.getCantidad()) >= 0) {

			this.ventas.setIdProducto(pro);
			;
			this.ventas.setValorUnitario(st.getValor());
			int iva = calculaIva(st.getValor(), st.getIva());
			this.ventas.setIva(iva);
			int valorTotal = calculaTotal(st.getValor() + iva, this.ventas.getCantidad());
			this.ventas.setValorTotal(valorTotal);
			// disminuye el stock
			int saldoCantidad = st.getCantidad() - this.ventas.getCantidad();
			iv.addVenta(em, ventas);
			is.updateStock(em, st.getIdStock(), saldoCantidad);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Compra Exitosa!", "se ha realizado la compra de forma correcta...!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Error de Compra!", "!intente hacer una menor cantidad de compra!"));
		}
	}

	public List<Ventas> obtenerVentas() {
		return iv.listVentas(em);
	}

	/*
	 * Metodo que me retona lista de productos con existencias
	 */
	public List<Stock> productoStock() {
		this.disponibles = new ArrayList<Stock>();
		List<Stock> prod = is.listStock(em);
		for (Stock stock : prod) {
			if (stock.getCantidad() > 0) {
				this.disponibles.add(stock);
			}
		}
		return this.disponibles;
	}

	private int calculaTotal(int valor, int cantidad) {
		int valorCantidad = valor * cantidad;
		return valorCantidad;
	}

	private int calculaIva(int valor, int porcentaje) {
		int valorPorcentaje = (valor * porcentaje) / 100;
		return valorPorcentaje;
	}

	/*
	 * start getters and setters to access public methods
	 */

	public List<Stock> getDisponibles() {
		return this.disponibles;
	}

	public void setDisponibles(List<Stock> disponibles) {
		this.disponibles = disponibles;
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Ventas getVentas() {
		return this.ventas;
	}

	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}
}
