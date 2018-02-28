package com.jonathan.entrevista.daosinterfaces;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import com.jonathan.entrevista.mappingtables.Productos;

@Local
public interface IProductos {

	public void addProducto(EntityManager em, Productos p);

	public void deleteProducto(EntityManager em, int idP);

	public List<Productos> listProductos(EntityManager em);
}
