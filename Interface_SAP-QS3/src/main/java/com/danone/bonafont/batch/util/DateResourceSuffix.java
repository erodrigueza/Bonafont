package com.danone.bonafont.batch.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.batch.item.file.ResourceSuffixCreator;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class DateResourceSuffix implements ResourceSuffixCreator {

	@Override
	public String getSuffix(int index) {
		NumberFormat formatter;
		formatter = new DecimalFormat("00");
		return Util.getDateSeg() + formatter.format(index) + ".csv";
	}

}
