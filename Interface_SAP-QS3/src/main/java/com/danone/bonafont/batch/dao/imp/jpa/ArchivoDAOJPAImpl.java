package com.danone.bonafont.batch.dao.imp.jpa;

import org.springframework.stereotype.Repository;

import com.danone.bonafont.batch.dao.ArchivoDAO;
import com.danone.bonafont.batch.model.Archivo;

/**
 * @author Eduardo Rodriguez
 *
 */
@Repository("archivoDAO")
public class ArchivoDAOJPAImpl extends GenericDAOJPAImpl<Archivo, Long> implements ArchivoDAO{

}
