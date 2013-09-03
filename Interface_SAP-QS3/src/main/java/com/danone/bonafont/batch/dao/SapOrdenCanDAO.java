package com.danone.bonafont.batch.dao;

import java.util.List;

import com.danone.bonafont.batch.model.SapOrdenCan;

/**
 * @author Eduardo Rodriguez
 * 
 */
public interface SapOrdenCanDAO extends GenericDAO<SapOrdenCan, Long> {

	List<SapOrdenCan> findByFolioProducto(SapOrdenCan orden);
}
