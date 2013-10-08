package com.danone.bonafont.batch.writer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.MultiResourceItemWriter;

import com.danone.bonafont.batch.model.Qs3Orden;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class FlatFileMultiWriterQs3Orden extends MultiResourceItemWriter<Qs3Orden> {

	private static final Logger LOG = Logger
			.getLogger(FlatFileMultiWriterQs3Orden.class);

	@Override
	public void write(List<? extends Qs3Orden> items) throws Exception {
		LOG.info("Tamaño de lista original: " + items.size());
		Map<String, List<Qs3Orden>> map = new HashMap<String, List<Qs3Orden>>();
		for (Qs3Orden orden : items) {
			if (map.containsKey(getKey(orden))) {
				List<Qs3Orden> tmp = map.get(getKey(orden));
				tmp.add(orden);
				map.put(getKey(orden), tmp);
			} else {
				List<Qs3Orden> nueva = new ArrayList<Qs3Orden>();
				nueva.add(orden);
				map.put(getKey(orden), nueva);
			}
		}

		for (Map.Entry<String, List<Qs3Orden>> entry : map.entrySet()) {
			LOG.info("Key de Lista: " + entry.getKey());
			LOG.info("Tamano de segmento: " + entry.getValue().size());
			setItemCountLimitPerResource(entry.getValue().size());
			super.write(entry.getValue());
		}
	}

	private String getKey(Qs3Orden orden) {
		StringBuffer buffer = new StringBuffer();

//		buffer.append(orden.getCh_tipopedido());
//		buffer.append(orden.getCh_canaldist());
//		buffer.append(orden.getCh_division());
//		buffer.append(orden.getCh_destino());
//		buffer.append(orden.getCh_foliopedido());
//		buffer.append(orden.getCh_observa());
//		buffer.append(orden.getCh_cubicuadre());
		buffer.append(orden.getCh_pedidos3());
//		buffer.append(orden.getCh_occamion());
//		buffer.append(orden.getNu_prioridad());
//		buffer.append(orden.getCh_razonpedido());
		
		return buffer.toString();
	}

}
