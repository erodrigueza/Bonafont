package com.danone.bonafont.batch.dao.imp.jpa;

import org.springframework.stereotype.Repository;

import com.danone.bonafont.batch.dao.Qs3OrdenDAO;
import com.danone.bonafont.batch.model.Qs3Orden;

/**
 * @author Eduardo Rodriguez
 *
 */
@Repository("qs3OrdenDAO")
public class Qs3OrdenDAOJPAImpl extends GenericDAOJPAImpl<Qs3Orden, Long> implements Qs3OrdenDAO{

}
