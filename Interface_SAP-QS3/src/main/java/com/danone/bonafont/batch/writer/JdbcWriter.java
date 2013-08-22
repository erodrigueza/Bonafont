/**
 * 
 */
package com.danone.bonafont.batch.writer;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.danone.bonafont.batch.dao.SapOrdenDAO;
import com.danone.bonafont.batch.model.SapOrden;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class JdbcWriter extends JdbcBatchItemWriter<SapOrden> {

	private static final Logger LOG = Logger.getLogger(JdbcWriter.class);

	@Resource
	SapOrdenDAO sapOrdenDAO;

	@Override
	public void write(List<? extends SapOrden> items) throws Exception {
		for (SapOrden orden : items) {
			LOG.info("Ch_orden_compra: " + orden.getCh_orden_compra());
			LOG.info("Nu_id_archivo: " + orden.getNu_id_archivo());
			List<SapOrden> ordens = sapOrdenDAO.findByOrdenCompra(orden.getCh_orden_compra());
			if(ordens.size() > 0){
				orden.setNu_id_estatus(Constants.REG_DUPLICADO);
			}else{
				orden.setNu_id_estatus(Constants.REG_NUEVO);
			}
		}
		super.write(items);
	}
}
