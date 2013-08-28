package com.danone.bonafont.batch.dao.imp.jpa;

import org.springframework.stereotype.Repository;

import com.danone.bonafont.batch.dao.Qs3OrdenCanDAO;
import com.danone.bonafont.batch.model.Qs3OrdenCan;

/**
 * @author Eduardo Rodriguez
 * 
 */
@Repository("qs3OrdenCanDAO")
public class Qs3OrdenCanDAOJPAImpl extends GenericDAOJPAImpl<Qs3OrdenCan, Long>
		implements Qs3OrdenCanDAO {

}
