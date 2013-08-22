package com.danone.bonafont.batch.util;

/**
 * @author Eduardo Rodriguez
 * Values constants by application
 */
public class Constants {

	public final static Integer ARCHIVO_LEIDO 		= 1001;
	public final static Integer ARCHIVO_ERROR 		= 1002;
	public final static Integer ARCHIVO_GENERADO 	= 1003;
	
	public final static Integer REG_NUEVO 			= 2001;
	public final static Integer REG_DUPLICADO 		= 2002;
	public final static Integer REG_ERROR 			= 2003;
	public final static Integer REG_EN_PROCESO 		= 2004;
	public final static Integer REG_PROCESADO_QS3 	= 2005;
	public final static Integer REG_PROCESADO 		= 2006;
	
	public final static Integer SAP_QS3_OR_CREATION 	= 1;
	public final static Integer SAP_QS3_OR_CANCELLA 	= 2;
	public final static Integer SAP_QS3_INVENTORY 		= 3;
	public final static Integer SAP_QS3_DELIVERY 		= 4;
	public final static Integer QS3_SAP_OR_CREATION 	= 5;
	public final static Integer QS3_SAP_OR_CANCELLA 	= 6;
	public final static Integer QS3_SAP_STO 			= 7;
	
}
