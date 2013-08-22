package com.danone.bonafont.batch.dao;

import java.util.List;

import com.danone.bonafont.batch.model.SapOrden;

/**
 * @author Eduardo Rodriguez
 * 
 */
public interface SapOrdenDAO extends GenericDAO<SapOrden, Long> {

	List<SapOrden> findByOrdenCompra(String orden);
}
