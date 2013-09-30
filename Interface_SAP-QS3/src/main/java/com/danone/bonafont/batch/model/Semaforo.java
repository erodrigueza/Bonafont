package com.danone.bonafont.batch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "QS_TBL_SEMAFORO", schema = "dbo")
public class Semaforo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nu_id_semaforo", unique = true, nullable = false, precision = 10)
	private Long nu_id_semaforo;

	@Column(name = "ch_entidad", nullable = false)
	private String ch_entidad;

	@Column(name = "da_fecha", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date da_fecha;

	@Column(name = "nu_estatus", nullable = false)
	private Integer nu_estatus;

	@Column(name = "ch_descripcion")
	private String ch_descripcion;

	public Long getNu_id_semaforo() {
		return nu_id_semaforo;
	}

	public void setNu_id_semaforo(Long nu_id_semaforo) {
		this.nu_id_semaforo = nu_id_semaforo;
	}

	public String getCh_entidad() {
		return ch_entidad;
	}

	public void setCh_entidad(String ch_entidad) {
		this.ch_entidad = ch_entidad;
	}

	public Date getDa_fecha() {
		return da_fecha;
	}

	public void setDa_fecha(Date da_fecha) {
		this.da_fecha = da_fecha;
	}

	public Integer getNu_estatus() {
		return nu_estatus;
	}

	public void setNu_estatus(Integer nu_estatus) {
		this.nu_estatus = nu_estatus;
	}

	public String getCh_descripcion() {
		return ch_descripcion;
	}

	public void setCh_descripcion(String ch_descripcion) {
		this.ch_descripcion = ch_descripcion;
	}

}
