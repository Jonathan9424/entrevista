package com.jonathan.entrevista.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jonathan.entrevista.daosinterfaces.ITipoProductos;
import com.jonathan.entrevista.mappingtables.TipoProductos;

@Stateless
public class TipoProductosBean implements ITipoProductos {

	@Override
	public TipoProductos searchProductos(EntityManager em, int id) {
		TipoProductos tp = em.find(TipoProductos.class, id);
		return tp;
	}

	@Override
	public void addTipoProductos(EntityManager em, TipoProductos tp) {
		em.merge(tp);
	}

	@Override
	public void deleteTipoProductos(EntityManager em, int idTp) {
		TipoProductos tp = em.find(TipoProductos.class, idTp);
		em.remove(tp);
	}

	@Override
	public List<TipoProductos> listTipoProductos(EntityManager em) {
		String query = "SELECT T FROM com.jonathan.entrevista.mappingtables.TipoProductos T";
		return em.createQuery(query, TipoProductos.class).getResultList();
	}

}
