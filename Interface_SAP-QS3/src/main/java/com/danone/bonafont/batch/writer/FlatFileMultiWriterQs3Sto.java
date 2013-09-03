package com.danone.bonafont.batch.writer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.MultiResourceItemWriter;

import com.danone.bonafont.batch.model.Qs3STO;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class FlatFileMultiWriterQs3Sto extends MultiResourceItemWriter<Qs3STO> {

	private static final Logger LOG = Logger
			.getLogger(FlatFileMultiWriterQs3Sto.class);

	@Override
	public void write(List<? extends Qs3STO> items) throws Exception {
		LOG.info("Tamaño de lista original: " + items.size());
		Map<String, List<Qs3STO>> map = new HashMap<String, List<Qs3STO>>();
		for (Qs3STO orden : items) {
			if (map.containsKey(getKey(orden))) {
				List<Qs3STO> tmp = map.get(getKey(orden));
				tmp.add(orden);
				map.put(getKey(orden), tmp);
			} else {
				List<Qs3STO> nueva = new ArrayList<Qs3STO>();
				nueva.add(orden);
				map.put(getKey(orden), nueva);
			}
		}

		for (Map.Entry<String, List<Qs3STO>> entry : map.entrySet()) {
			LOG.info("Key de Lista: " + entry.getKey());
			LOG.info("Tamano de segmento: " + entry.getValue().size());
			setItemCountLimitPerResource(entry.getValue().size());
			super.write(entry.getValue());
		}
	}

	private String getKey(Qs3STO orden) {
		StringBuffer buffer = new StringBuffer();

		buffer.append(orden.getCh_tipopedido());
		buffer.append(orden.getCh_destino());
		buffer.append(orden.getCh_cubicuadre());
		buffer.append(orden.getCh_pedidos3());
		
		return buffer.toString();
	}

}
