package com.danone.bonafont.batch.util;

import org.springframework.batch.item.file.ResourceSuffixCreator;

/**
 * @author Eduardo Rodriguez
 *
 */
public class DateResourceSuffix implements ResourceSuffixCreator {

	@Override
	public String getSuffix(int index) {
		return "_" + Util.getDate() + "_" + index + ".csv";
	}

}
