package com.danone.bonafont.batch.dao;

import java.util.List;

import com.danone.bonafont.batch.model.Archivo;

/**
 * @author Eduardo Rodriguez
 *
 */
public interface ArchivoDAO extends GenericDAO<Archivo, Long>{

	Long registerFile(String fileName, Integer status, Integer interfaz);
	
	List<Archivo> findByName(String fileName);
}
