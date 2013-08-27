-- Autogenerated: do not edit this file
DROP TABLE  dbo.QS_TBL_SAP_ORDEN IF EXISTS;
DROP TABLE  dbo.QS_TBL_QS3_ORDEN IF EXISTS;
DROP TABLE  dbo.QS_TBL_ARCHIVOS IF EXISTS;

--DROP SCHEMA dbo
CREATE SCHEMA dbo AUTHORIZATION DBA

CREATE TABLE dbo.QS_TBL_ARCHIVOS ( 
	nu_id_archivo int NOT NULL IDENTITY, 
	nu_id_tipo smallint NOT NULL, 
	nu_id_estatus smallint NOT NULL, 
	ch_nombre varchar(60) NOT NULL, 
	da_registro datetime NOT NULL)

CREATE TABLE dbo.QS_TBL_SAP_ORDEN (
	nu_id_orden int NOT NULL IDENTITY,
	ch_orden_compra varchar(250) NOT NULL, 
	nu_id_estatus smallint  NOT NULL, 
	da_registro datetime NOT NULL, 
	nu_id_archivo int NOT NULL, 
	da_proceso datetime NULL, 
	ch_origen varchar(250) NULL, 
	ch_foliopedido varchar(250) NULL, 
	ch_destino varchar(250) NULL, 
	ch_ciudescrip varchar(250) NULL, 
	ch_pedfecha varchar(250) NULL, 
	ch_pedfechaemb varchar(250) NULL, 
	ch_pedfechaent varchar(250) NULL, 
	ch_observa varchar(250) NULL,  
	ch_producto varchar(250) NULL, 
	ch_cantidad varchar(250) NULL, 
	ch_fechaembarque varchar(250) NULL, 
	ch_cajas varchar(250) NULL, 
	ch_ocedi varchar(250) NULL, 
	ch_cubicuadre varchar(250) NULL, 
	ch_pedidos3 varchar(250) NULL, 
	ch_occamion varchar(1) NULL, 
	ch_tipopedido varchar(8) NULL,      
	ch_orgventas varchar(4) NULL, 
	ch_canaldist varchar(2) NULL, 
	ch_division varchar(4) NULL,  
	nu_posicionitem int NULL, 
	ch_procedencia varchar(250) NULL, 
	ch_razonpedido varchar(250) NULL)

CREATE TABLE dbo.QS_TBL_QS3_ORDEN ( 
	nu_id_orden int NOT NULL,
	nu_id_estatus smallint NOT NULL, 
	da_registro datetime NOT NULL, 
	nu_id_archivo int NOT NULL, 
	da_proceso datetime NULL, 
	ch_tipopedido varchar(8) NULL,      
	ch_orgventas varchar(4) NULL, 
	ch_canaldist varchar(2) NULL, 
	ch_division varchar(2) NULL,  
	ch_destino varchar(250) NULL, 
	ch_pedfecha varchar(250) NULL, 
	ch_pedfechaemb varchar(250) NULL, 
	ch_pedfechaent varchar(250) NULL, 
	ch_producto varchar(250) NULL, 
	ch_cantidad varchar(250) NULL, 
	ch_origen varchar(250) NULL, 
	ch_almacen varchar(250) NULL, 
	ch_foliopedido varchar(250) NULL, 
	ch_estadopedido varchar(250) NULL, 
	ch_observa varchar(250) NULL,  
	ch_ocedi varchar(15) NULL, 
	ch_cubicuadre varchar(20) NULL, 
	ch_pedidos3 varchar(50) NULL, 
	ch_occamion varchar(1) NULL, 
	ch_pedtipo varchar(250) NULL, 
	nu_prioridad int NULL, 
	ch_razonpedido varchar(250) NULL)

/*
INSERT  INTO dbo.QS_TBL_QS3_ORDEN VALUES (1, 2005, SYSDATE, 666, null, 'POPEDI01', '0001', '01', '01', 'CH_DESTINO', 'CH_PEDFECHA', 'CH_PEDFECHAEMB', 'CH_PEDFECHAENT', 'CH_PRODUCTO', 'CH_CANTIDAD', 'CH_ORIGEN', 'CH_ALMACEN', 'CH_FOLIOPEDIDO', 'CH_ESTADOPEDIDO', 'CH_OBSERVA', 'CH_OCEDI', 'CH_CUBICUADRE', 'CH_PEDIDOS3', '1', 'CH_PEDTIPO', 1, 'CH_RAZONPEDIDO')
INSERT  INTO dbo.QS_TBL_QS3_ORDEN VALUES (2, 2005, SYSDATE, 666, null, 'POPEDI02', '0002', '02', '02', 'CH_DESTINO', 'CH_PEDFECHA', 'CH_PEDFECHAEMB', 'CH_PEDFECHAENT', 'CH_PRODUCTO', 'CH_CANTIDAD', 'CH_ORIGEN', 'CH_ALMACEN', 'CH_FOLIOPEDIDO', 'CH_ESTADOPEDIDO', 'CH_OBSERVA', 'CH_OCEDI', 'CH_CUBICUADRE', 'CH_PEDIDOS3', '2', 'CH_PEDTIPO', 2, 'CH_RAZONPEDIDO')
INSERT  INTO dbo.QS_TBL_QS3_ORDEN VALUES (3, 2005, SYSDATE, 666, null, 'POPEDI02', '0002', '02', '02', 'CH_DESTINO', 'CH_PEDFECHA', 'CH_PEDFECHAEMB', 'CH_PEDFECHAENT', 'CH_PRODUCTO', 'CH_CANTIDAD', 'CH_ORIGEN', 'CH_ALMACEN', 'CH_FOLIOPEDIDO', 'CH_ESTADOPEDIDO', 'CH_OBSERVA', 'CH_OCEDI', 'CH_CUBICUADRE', 'CH_PEDIDOS3', '2', 'CH_PEDTIPO', 2, 'CH_RAZONPEDIDO')
INSERT  INTO dbo.QS_TBL_QS3_ORDEN VALUES (4, 2005, SYSDATE, 666, null, 'POPEDI03', '0003', '03', '03', 'CH_DESTINO', 'CH_PEDFECHA', 'CH_PEDFECHAEMB', 'CH_PEDFECHAENT', 'CH_PRODUCTO', 'CH_CANTIDAD', 'CH_ORIGEN', 'CH_ALMACEN', 'CH_FOLIOPEDIDO', 'CH_ESTADOPEDIDO', 'CH_OBSERVA', 'CH_OCEDI', 'CH_CUBICUADRE', 'CH_PEDIDOS3', '3', 'CH_PEDTIPO', 3, 'CH_RAZONPEDIDO')
INSERT  INTO dbo.QS_TBL_QS3_ORDEN VALUES (5, 2005, SYSDATE, 666, null, 'POPEDI03', '0003', '03', '03', 'CH_DESTINO', 'CH_PEDFECHA', 'CH_PEDFECHAEMB', 'CH_PEDFECHAENT', 'CH_PRODUCTO', 'CH_CANTIDAD', 'CH_ORIGEN', 'CH_ALMACEN', 'CH_FOLIOPEDIDO', 'CH_ESTADOPEDIDO', 'CH_OBSERVA', 'CH_OCEDI', 'CH_CUBICUADRE', 'CH_PEDIDOS3', '3', 'CH_PEDTIPO', 3, 'CH_RAZONPEDIDO')
INSERT  INTO dbo.QS_TBL_QS3_ORDEN VALUES (6, 2005, SYSDATE, 666, null, 'POPEDI03', '0003', '03', '03', 'CH_DESTINO', 'CH_PEDFECHA', 'CH_PEDFECHAEMB', 'CH_PEDFECHAENT', 'CH_PRODUCTO', 'CH_CANTIDAD', 'CH_ORIGEN', 'CH_ALMACEN', 'CH_FOLIOPEDIDO', 'CH_ESTADOPEDIDO', 'CH_OBSERVA', 'CH_OCEDI', 'CH_CUBICUADRE', 'CH_PEDIDOS3', '3', 'CH_PEDTIPO', 3, 'CH_RAZONPEDIDO')
*/