package com.jonathan.entrevista.model;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jonathan.entrevista.daosinterfaces.ITipoProductos;
import com.jonathan.entrevista.mappingtables.TipoProductos;

@ManagedBean
public class TipoProductosController {

	@PersistenceContext(name = "entrevista")
	private EntityManager em;

	@EJB
	private ITipoProductos itp;

	private TipoProductos tipoProductos;
	private List<TipoProductos> tipoProductosList;

	public TipoProductosController() {
		this.tipoProductos = new TipoProductos();
	}

	/*
	 * creating, business layer for Tipo Productos
	 */

	public void addTipoProductos() {
		itp.addTipoProductos(em, this.tipoProductos);
	}

	public void deleteTipoproductos() {
		itp.deleteTipoProductos(em, this.tipoProductos.getIdTipoProductos());
	}

	public List<TipoProductos> obtenerProductos() {
		return this.tipoProductosList = itp.listTipoProductos(em);
	}

	/*
	 * starts getters and setters to access since view point Tproductos
	 */

	public List<TipoProductos> getTipoProductosList() {
		return this.tipoProductosList;
	}

	public void setTipoProductosList(List<TipoProductos> tipoProductosList) {
		this.tipoProductosList = tipoProductosList;
	}

	public TipoProductos getTipoProductos() {
		return this.tipoProductos;
	}

	public void setTipoProductos(TipoProductos tipoProductos) {
		this.tipoProductos = tipoProductos;
	}
}
