package com.danone.bonafont.batch.writer;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.danone.bonafont.batch.dao.SapOrdenCanDAO;
import com.danone.bonafont.batch.model.SapOrdenCan;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class JdbcWriterSapOrdenCan extends JdbcBatchItemWriter<SapOrdenCan> {

	private static final Logger LOG = Logger.getLogger(JdbcWriterSapOrden.class);
	
	protected String threwException = "";
	
	@Resource
	SapOrdenCanDAO sapOrdenCanDAO;

	@Override
	public void write(List<? extends SapOrdenCan> items) throws Exception {
		for (SapOrdenCan orden : items) {
			LOG.info("ch_foliopedido: " + orden.getCh_foliopedido());
			LOG.info("ch_producto: " + orden.getCh_producto());
			List<SapOrdenCan> ordens = sapOrdenCanDAO.findByFolioProducto(orden);
			if (ordens.size() > 0) {
				orden.setNu_id_estatus(Constants.REG_DUPLICADO);
				String key = orden.getNu_id_archivo()+orden.getCh_foliopedido()+orden.getCh_producto();
				if(!threwException.equals(key)){
					threwException = key;
					throw new Exception(Constants.ERR_DATA_DUPL);
				}
			} else {
				orden.setNu_id_estatus(Constants.REG_NUEVO);
			}
		}
		super.write(items);
	}

}
