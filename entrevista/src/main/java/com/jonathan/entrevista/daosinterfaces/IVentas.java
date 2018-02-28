package com.jonathan.entrevista.daosinterfaces;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import com.jonathan.entrevista.mappingtables.Ventas;

@Local
public interface IVentas {

	public void addVenta(EntityManager em, Ventas v);

	public void updateVenta(EntityManager em, int idV, Ventas v);

	public List<Ventas> listVentas(EntityManager em);

}
