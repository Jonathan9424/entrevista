package com.jonathan.entrevista.daosinterfaces;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import com.jonathan.entrevista.mappingtables.Stock;

@Local
public interface IStock {

	public void addStock(EntityManager em, Stock s);

	public void updateStock(EntityManager em, int idS, int cantidad);

	public List<Stock> listStock(EntityManager em);

}
