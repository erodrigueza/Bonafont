package com.danone.bonafont.batch.util;

/**
 * @author Eduardo Rodriguez
 * Values constants by application
 */
public class Constants {

	public final static Integer ARCHIVO_LEIDO 		= 1001;
	public final static Integer ARCHIVO_ERROR 		= 1002;
	public final static Integer ARCHIVO_GENERADO 	= 1003;
	public final static Integer ARCHIVO_DUPLICADO 	= 1004;
	public final static Integer ARCHIVO_PROCESANDO 	= 1005;
	
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
	
	public final static String ERR_FILE_MOVE 			= "No se puede mover de ruta el archivo.";
	public final static String ERR_FILE_DATA 			= "Error al insertar el dato en la DB.";
	public final static String ERR_FILE_STRU 			= "Estructura incorrecta del archivo.";
	public final static String ERR_FILE_DUPL 			= "El nombre del archivo esta duplicado.";
	public final static String ERR_DATA_DUPL 			= "Archivo con registros duplicados.";
	
}
