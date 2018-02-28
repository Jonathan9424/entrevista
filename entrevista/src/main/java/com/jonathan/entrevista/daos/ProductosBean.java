package com.jonathan.entrevista.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.jonathan.entrevista.daosinterfaces.IProductos;
import com.jonathan.entrevista.mappingtables.Productos;

@Stateless
public class ProductosBean implements IProductos {

	@Override
	public void addProducto(EntityManager em, Productos p) {
		em.merge(p);
	}

	@Override
	public void deleteProducto(EntityManager em, int idP) {
		Productos p = em.find(Productos.class, idP);
		em.remove(p);
	}

	@Override
	public List<Productos> listProductos(EntityManager em) {
		String query = "SELEC P FROM com.jonathan.entrevista.Productos P";
		return em.createQuery(query, Productos.class).getResultList();
	}
}
