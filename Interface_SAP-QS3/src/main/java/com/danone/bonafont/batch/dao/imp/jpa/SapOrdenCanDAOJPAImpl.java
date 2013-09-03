package com.danone.bonafont.batch.dao.imp.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.danone.bonafont.batch.dao.SapOrdenCanDAO;
import com.danone.bonafont.batch.model.SapOrdenCan;

/**
 * @author Eduardo Rodriguez
 * 
 */
@Repository("sapOrdenCanDAO")
public class SapOrdenCanDAOJPAImpl extends GenericDAOJPAImpl<SapOrdenCan, Long>
		implements SapOrdenCanDAO {

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<SapOrdenCan> findByFolioProducto(SapOrdenCan orden) {
		Map<String,String> paramMap=new HashMap<String, String>();	

		paramMap.put("ch_foliopedido", orden.getCh_foliopedido());
		paramMap.put("ch_producto", orden.getCh_producto());

		return getJpaTemplate().findByNamedQueryAndNamedParams("SapOrdenCan.findByFolioProducto", paramMap);
	}
	
}
