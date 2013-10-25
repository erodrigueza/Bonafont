package com.danone.bonafont.batch.writer;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.danone.bonafont.batch.dao.ArchivoDAO;
import com.danone.bonafont.batch.dao.SapOrdenCanDAO;
import com.danone.bonafont.batch.model.Archivo;
import com.danone.bonafont.batch.model.SapOrdenCan;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class JdbcWriterSapOrdenCan extends JdbcBatchItemWriter<SapOrdenCan> {

	private static final Logger LOG = Logger.getLogger(JdbcWriterSapOrden.class);
	protected boolean isDuplicate;
	protected Long idArchivo;

	@Resource
	SapOrdenCanDAO sapOrdenCanDAO;

	@Resource
	ArchivoDAO archivoDAO;

	@Override
	public void write(List<? extends SapOrdenCan> items) throws Exception {
		isDuplicate = false;
		for (SapOrdenCan orden : items) {
			LOG.info("ch_foliopedido: " + orden.getCh_foliopedido());
			LOG.info("ch_producto: " + orden.getCh_producto());
			List<SapOrdenCan> ordens = sapOrdenCanDAO.findByFolioProducto(orden);
			if (ordens.size() > 0) {
				orden.setNu_id_estatus(Constants.REG_DUPLICADO);
				isDuplicate = true;
				idArchivo = orden.getNu_id_archivo();
			} else {
				orden.setNu_id_estatus(Constants.REG_NUEVO);
			}
		}
		updateFile();
		super.write(items);
	}

	private void updateFile() {
		if (idArchivo != null && isDuplicate) {
			Archivo archivo = archivoDAO.findByPK(Archivo.class, idArchivo);
			archivo.setNu_id_estatus(Constants.ARCHIVO_ERROR);
			archivo.setCh_descripcion("Archivo con registros duplicados");
			archivoDAO.update(archivo);
		}
	}

}
