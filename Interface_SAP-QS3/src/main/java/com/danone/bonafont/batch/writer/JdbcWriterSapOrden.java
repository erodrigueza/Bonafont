package com.danone.bonafont.batch.writer;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.danone.bonafont.batch.dao.ArchivoDAO;
import com.danone.bonafont.batch.dao.SapOrdenDAO;
import com.danone.bonafont.batch.model.SapOrden;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class JdbcWriterSapOrden extends JdbcBatchItemWriter<SapOrden> {

	private static final Logger LOG = Logger.getLogger(JdbcWriterSapOrden.class);

	protected boolean isDuplicate;
	protected Long idArchivo;

	@Resource
	SapOrdenDAO sapOrdenDAO;

	@Resource
	ArchivoDAO archivoDAO;

	@Override
	public void write(List<? extends SapOrden> items) throws Exception {
		isDuplicate = false;
		for (SapOrden orden : items) {
			LOG.info("ch_foliopedido: " + orden.getCh_foliopedido());
			LOG.info("ch_producto: " + orden.getCh_producto());
			List<SapOrden> ordens = sapOrdenDAO.findByFolioProducto(orden);
			if (ordens.size() > 0) {
				orden.setNu_id_estatus(Constants.REG_DUPLICADO);
				isDuplicate = true;
				idArchivo = orden.getNu_id_archivo();
				throw new Exception(Constants.ERR_DATA_DUPL);
			} else {
				orden.setNu_id_estatus(Constants.REG_NUEVO);
			}
		}
		super.write(items);
	}

}
