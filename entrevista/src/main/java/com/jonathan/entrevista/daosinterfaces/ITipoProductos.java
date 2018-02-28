package com.jonathan.entrevista.daosinterfaces;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import com.jonathan.entrevista.mappingtables.TipoProductos;

@Local
public interface ITipoProductos {

	public TipoProductos searchProductos(EntityManager em, int id);

	public void addTipoProductos(EntityManager em, TipoProductos tp);

	public void deleteTipoProductos(EntityManager em, int idTp);

	public List<TipoProductos> listTipoProductos(EntityManager em);
}
