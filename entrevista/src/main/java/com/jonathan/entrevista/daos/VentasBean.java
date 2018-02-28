package com.jonathan.entrevista.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.jonathan.entrevista.daosinterfaces.IVentas;
import com.jonathan.entrevista.mappingtables.Ventas;

@Stateless
public class VentasBean implements IVentas {

	@Override
	public void addVenta(EntityManager em, Ventas v) {
		em.persist(v);
	}

	@Override
	public void updateVenta(EntityManager em, int idV, Ventas v) {
		Ventas vs = em.find(Ventas.class, idV);
		vs.setIdProducto(v.getIdProducto());
		vs.setCantidad(v.getCantidad());
		vs.setValorUnitario(v.getValorUnitario());
		vs.setIva(v.getIva());
		vs.setVelorTotal(v.getValorTotal());

	}

	@Override
	public List<Ventas> listVentas(EntityManager em) {
		String query = "SELECT V FROM com.jonathan.entrevista.mappingtables.Ventas V";
		return em.createQuery(query, Ventas.class).getResultList();
	}
}
