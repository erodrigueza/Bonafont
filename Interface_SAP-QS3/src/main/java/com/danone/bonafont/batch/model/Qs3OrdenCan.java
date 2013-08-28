package com.danone.bonafont.batch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Eduardo Rodriguez
 * 
 */
@Entity
@Table(name = "QS_TBL_QS3_ORDEN_CAN", schema = "dbo")
public class Qs3OrdenCan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nu_id_orden_can", unique = true, nullable = false, precision = 10)
	private Long nu_id_orden_can;

	@Column(name = "nu_id_estatus", nullable = false)
	private Integer nu_id_estatus;

	@Column(name = "da_registro", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date da_registro;

	@Column(name = "nu_id_archivo")
	private Long nu_id_archivo;

	@Column(name = "da_proceso")
	@Temporal(TemporalType.TIMESTAMP)
	private Date da_proceso;

	@Column(name = "ch_foliopedido")
	private String ch_foliopedido;

	@Column(name = "ch_orgventas")
	private String ch_orgventas;

	@Column(name = "ch_canaldist")
	private String ch_canaldist;

	@Column(name = "ch_division")
	private String ch_division;

	@Column(name = "ch_producto")
	private String ch_producto;

	@Column(name = "ch_razonrechazo")
	private String ch_razonrechazo;

	@Column(name = "nu_posicionitem")
	private Integer nu_posicionitem;

	public Long getNu_id_orden_can() {
		return nu_id_orden_can;
	}

	public void setNu_id_orden_can(Long nu_id_orden_can) {
		this.nu_id_orden_can = nu_id_orden_can;
	}

	public Integer getNu_id_estatus() {
		return nu_id_estatus;
	}

	public void setNu_id_estatus(Integer nu_id_estatus) {
		this.nu_id_estatus = nu_id_estatus;
	}

	public Date getDa_registro() {
		return da_registro;
	}

	public void setDa_registro(Date da_registro) {
		this.da_registro = da_registro;
	}

	public Long getNu_id_archivo() {
		return nu_id_archivo;
	}

	public void setNu_id_archivo(Long nu_id_archivo) {
		this.nu_id_archivo = nu_id_archivo;
	}

	public Date getDa_proceso() {
		return da_proceso;
	}

	public void setDa_proceso(Date da_proceso) {
		this.da_proceso = da_proceso;
	}

	public String getCh_foliopedido() {
		return ch_foliopedido;
	}

	public void setCh_foliopedido(String ch_foliopedido) {
		this.ch_foliopedido = ch_foliopedido;
	}

	public String getCh_orgventas() {
		return ch_orgventas;
	}

	public void setCh_orgventas(String ch_orgventas) {
		this.ch_orgventas = ch_orgventas;
	}

	public String getCh_canaldist() {
		return ch_canaldist;
	}

	public void setCh_canaldist(String ch_canaldist) {
		this.ch_canaldist = ch_canaldist;
	}

	public String getCh_division() {
		return ch_division;
	}

	public void setCh_division(String ch_division) {
		this.ch_division = ch_division;
	}

	public String getCh_producto() {
		return ch_producto;
	}

	public void setCh_producto(String ch_producto) {
		this.ch_producto = ch_producto;
	}

	public String getCh_razonrechazo() {
		return ch_razonrechazo;
	}

	public void setCh_razonrechazo(String ch_razonrechazo) {
		this.ch_razonrechazo = ch_razonrechazo;
	}

	public Integer getNu_posicionitem() {
		return nu_posicionitem;
	}

	public void setNu_posicionitem(Integer nu_posicionitem) {
		this.nu_posicionitem = nu_posicionitem;
	}

}
