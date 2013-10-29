package com.danone.bonafont.batch.dao.imp.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.danone.bonafont.batch.dao.SapOrdenDAO;
import com.danone.bonafont.batch.model.SapOrden;

/**
 * @author Eduardo Rodriguez
 * 
 */
@Repository("sapOrdenDAO")
public class SapOrdenDAOJPAImpl extends GenericDAOJPAImpl<SapOrden, Long>
		implements SapOrdenDAO {

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<SapOrden> findByFolioProducto(SapOrden orden) {
		Map<String,String> paramMap=new HashMap<String, String>();	

		paramMap.put("ch_foliopedido", orden.getCh_foliopedido());
		paramMap.put("ch_producto", orden.getCh_producto());
		paramMap.put("ch_destino", orden.getCh_destino());

		return getJpaTemplate().findByNamedQueryAndNamedParams("SapOrden.findByFolioProducto", paramMap);
	}
	
}
