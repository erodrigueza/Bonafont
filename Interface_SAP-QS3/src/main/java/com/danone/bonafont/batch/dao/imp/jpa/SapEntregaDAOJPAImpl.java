package com.danone.bonafont.batch.dao.imp.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.danone.bonafont.batch.dao.SapEntregaDAO;
import com.danone.bonafont.batch.model.SapEntrega;

/**
 * @author Eduardo Rodriguez
 * 
 */
@Repository("sapEntregaDAO")
public class SapEntregaDAOJPAImpl extends GenericDAOJPAImpl<SapEntrega, Long>
		implements SapEntregaDAO {

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<SapEntrega> findByFolioProducto(SapEntrega entrega) {
		Map<String,String> paramMap=new HashMap<String, String>();	

		paramMap.put("ch_foliopedido", entrega.getCh_foliopedido());
		paramMap.put("ch_producto", entrega.getCh_producto());

		return getJpaTemplate().findByNamedQueryAndNamedParams("SapEntrega.findByFolioProducto", paramMap);
	}
	
}
