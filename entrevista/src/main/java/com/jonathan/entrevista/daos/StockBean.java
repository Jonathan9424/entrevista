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
		String query = "SELECT S.id_stock FROM com.jonathan.entrevista.mappigntables.Stock S WHERE S.id_producto="
				+ idp;
		return em.createQuery(query, Stock.class).getSingleResult();
	}

	@Override
	public void addStock(EntityManager em, Stock s) {
		s.setCantidad(0);
		em.merge(s);
	}

	@Override
	public void updateStock(EntityManager em, int idS, int cantidad) {
		Stock s = em.find(Stock.class, idS);
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
