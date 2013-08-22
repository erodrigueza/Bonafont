package com.danone.bonafont.batch.dao;

import com.danone.bonafont.batch.model.Archivo;

/**
 * @author Eduardo Rodriguez
 *
 */
public interface ArchivoDAO extends GenericDAO<Archivo, Long>{

	Integer registerFile(String fileName, Integer status, Integer interfaz);
}
