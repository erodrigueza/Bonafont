package com.danone.bonafont.batch.writer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.MultiResourceItemWriter;

import com.danone.bonafont.batch.model.Qs3OrdenCan;


/**
 * @author Eduardo Rodriguez
 * 
 */
public class FlatFileMultiWriterQs3OrdenCan extends MultiResourceItemWriter<Qs3OrdenCan> {

	private static final Logger LOG = Logger
			.getLogger(FlatFileMultiWriterQs3OrdenCan.class);

	@Override
	public void write(List<? extends Qs3OrdenCan> items) throws Exception {
		LOG.info("Tamaño de lista original: " + items.size());
		Map<String, List<Qs3OrdenCan>> map = new HashMap<String, List<Qs3OrdenCan>>();
		for (Qs3OrdenCan orden : items) {
			if (map.containsKey(getKey(orden))) {
				List<Qs3OrdenCan> tmp = map.get(getKey(orden));
				tmp.add(orden);
				map.put(getKey(orden), tmp);
			} else {
				List<Qs3OrdenCan> nueva = new ArrayList<Qs3OrdenCan>();
				nueva.add(orden);
				map.put(getKey(orden), nueva);
			}
		}

		for (Map.Entry<String, List<Qs3OrdenCan>> entry : map.entrySet()) {
			LOG.info("Key de Lista: " + entry.getKey());
			LOG.info("Tamano de segmento: " + entry.getValue().size());
			setItemCountLimitPerResource(entry.getValue().size());
			super.write(entry.getValue());
		}
	}

	private String getKey(Qs3OrdenCan orden) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(orden.getCh_producto());
		buffer.append(orden.getCh_foliopedido());
		return buffer.toString();
	}

}
