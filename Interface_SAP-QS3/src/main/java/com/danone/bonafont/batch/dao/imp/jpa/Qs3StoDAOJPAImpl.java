package com.danone.bonafont.batch.dao.imp.jpa;

import org.springframework.stereotype.Repository;

import com.danone.bonafont.batch.dao.Qs3StoDAO;
import com.danone.bonafont.batch.model.Qs3STO;

/**
 * @author Eduardo Rodriguez
 * 
 */
@Repository("qs3StoDAO")
public class Qs3StoDAOJPAImpl extends GenericDAOJPAImpl<Qs3STO, Long>
		implements Qs3StoDAO {

}
