package com.danone.bonafont.batch.dao.imp.jpa;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.danone.bonafont.batch.dao.ArchivoDAO;
import com.danone.bonafont.batch.model.Archivo;

/**
 * @author Eduardo Rodriguez
 *
 */
@Repository("archivoDAO")
public class ArchivoDAOJPAImpl extends GenericDAOJPAImpl<Archivo, Long> implements ArchivoDAO{

	private static final Logger LOG = Logger.getLogger(ArchivoDAOJPAImpl.class);
	
	@Transactional
	public Long registerFile(String fileName, Integer status, Integer interfaz) {
		Long id = 0L;
		Archivo archivo = new Archivo();
        archivo.setCh_nombre(fileName);
        archivo.setDa_registro(new Date());
        archivo.setNu_id_estatus(status);
        archivo.setNu_id_tipo(interfaz);
        insert(archivo);   
        LOG.info("Se registra el archivo " + fileName + " en la DB.");
        id = archivo.getNu_id_archivo();
        LOG.info("Con el ID: "+id);  
		return id;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Archivo> findByName(String fileName) {
		Map<String,String> paramMap=new HashMap<String, String>();	

		paramMap.put("ch_nombre", fileName);

		return getJpaTemplate().findByNamedQueryAndNamedParams("Archivo.findByName", paramMap);
	}
	

}
