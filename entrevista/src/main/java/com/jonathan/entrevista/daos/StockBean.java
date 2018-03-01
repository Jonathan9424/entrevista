package com.jonathan.entrevista.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.jonathan.entrevista.daosinterfaces.IStock;
import com.jonathan.entrevista.mappingtables.Stock;

@Stateless
public class StockBean implements IStock {

	@Override
	public Stock searchStock(EntityManager em, int idp) {
		try {
			String query = "SELECT S FROM com.jonathan.entrevista.mappingtables.Stock S WHERE S.idProducto =" + idp;
			return em.createQuery(query, Stock.class).getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void addStock(EntityManager em, Stock s) {
		em.merge(s);
	}

	@Override
	public void updateStock(EntityManager em, int idp, int cantidad) {
		Stock s = em.find(Stock.class, idp);
		s.setCantidad(cantidad);
	}

	@Override
	public void modifyAttributes(EntityManager em, int ids, int valor, int iva) {
		Stock s = em.find(Stock.class, ids);
		s.setValor(valor);
		s.setIva(iva);
	}

	@Override
	public List<Stock> listStock(EntityManager em) {
		String query = "SELECT S FROM com.jonathan.entrevista.mappingtables.Stock S";
		return em.createQuery(query, Stock.class).getResultList();
	}
}
