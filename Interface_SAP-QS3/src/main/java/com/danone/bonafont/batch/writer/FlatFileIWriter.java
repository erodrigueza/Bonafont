/**
 * 
 */
package com.danone.bonafont.batch.writer;

import java.util.Collections;
import java.util.List;

import org.springframework.batch.item.file.FlatFileItemWriter;

import com.danone.bonafont.batch.dto.OrdenOutputDTO;

/**
 * @author Eduardo Rodriguez
 *
 */
public class FlatFileIWriter extends FlatFileItemWriter<OrdenOutputDTO> {

	List<OrdenOutputDTO> items;
	
	@Override
	public void write(List<? extends OrdenOutputDTO> items) throws Exception {
		Collections.copy(this.items, items);
		super.write(items);
	}
	@Override
	public void close() {
		for (OrdenOutputDTO dto : items) {
			System.err.println("getCh_almacen(): "+dto.getCh_almacen());
		}
		super.close();
	}
}
