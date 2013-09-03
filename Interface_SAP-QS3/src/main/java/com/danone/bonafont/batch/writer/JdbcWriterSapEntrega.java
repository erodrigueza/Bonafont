package com.danone.bonafont.batch.writer;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.danone.bonafont.batch.dao.SapEntregaDAO;
import com.danone.bonafont.batch.model.SapEntrega;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class JdbcWriterSapEntrega extends JdbcBatchItemWriter<SapEntrega> {

	private static final Logger LOG = Logger.getLogger(JdbcWriterSapEntrega.class);

	@Resource
	SapEntregaDAO sapEntregaDAO;

	@Override
	public void write(List<? extends SapEntrega> items) throws Exception {
		for (SapEntrega entrega : items) {
			LOG.info("ch_foliopedido: " + entrega.getCh_foliopedido());
			LOG.info("ch_producto: " + entrega.getCh_producto());
			List<SapEntrega> entregas = sapEntregaDAO.findByFolioProducto(entrega);
			if(entregas.size() > 0){
				entrega.setNu_id_estatus(Constants.REG_DUPLICADO);
			}else{
				entrega.setNu_id_estatus(Constants.REG_NUEVO);
			}
		}
		super.write(items);
	}
}
