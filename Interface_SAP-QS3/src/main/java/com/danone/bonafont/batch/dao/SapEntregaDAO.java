package com.danone.bonafont.batch.dao;

import java.util.List;

import com.danone.bonafont.batch.model.SapEntrega;

/**
 * @author Eduardo Rodriguez
 * 
 */
public interface SapEntregaDAO extends GenericDAO<SapEntrega, Long> {

	List<SapEntrega> findByFolioProducto(SapEntrega entrega);
}
