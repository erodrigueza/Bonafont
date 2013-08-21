/**
 * 
 */
package com.danone.bonafont.batch.writer;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.danone.bonafont.batch.dto.OrdenInputDTO;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class JdbcWriter extends JdbcBatchItemWriter<OrdenInputDTO> {
	@Override
	public void write(List<? extends OrdenInputDTO> items) throws Exception {
		List<OrdenInputDTO> rows = new ArrayList<OrdenInputDTO>();
		for (OrdenInputDTO dto : items) {
			//TODO Aqui se implementara la consulta a la DB para identificar duplicados
			System.err.println("Ch_orden_compra: "+dto.getCh_orden_compra());
			System.err.println("Nu_id_archivo: "+dto.getNu_id_archivo());
			dto.setNu_id_estatus(2001);
			rows.add(dto);
		}
		super.write(rows);
	}
@Override
public void setDataSource(DataSource dataSource) {
	// TODO Auto-generated method stub
	super.setDataSource(dataSource);
}
}
