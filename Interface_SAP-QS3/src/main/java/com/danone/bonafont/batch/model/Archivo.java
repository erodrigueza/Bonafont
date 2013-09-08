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
@Table(name = "QS_TBL_ARCHIVOS", schema = "dbo")
public class Archivo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    @Column(name = "nu_id_archivo", unique = true, nullable = false, precision = 10)  
    private Long nu_id_archivo;  
  
    @Column(name = "nu_id_tipo", nullable = false)  
    private Integer nu_id_tipo;  
  

    @Column(name = "nu_id_estatus", nullable = false)  
    private Integer nu_id_estatus;  
    
    @Column(length = 60, name = "ch_nombre", nullable = false)
    private String ch_nombre;  
  
    @Column(name = "da_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date da_registro;

    @Column(name = "ch_descripcion")
    private String ch_descripcion;
    
	public Long getNu_id_archivo() {
		return nu_id_archivo;
	}

	public void setNu_id_archivo(Long nu_id_archivo) {
		this.nu_id_archivo = nu_id_archivo;
	}

	public Integer getNu_id_tipo() {
		return nu_id_tipo;
	}

	public void setNu_id_tipo(Integer nu_id_tipo) {
		this.nu_id_tipo = nu_id_tipo;
	}

	public Integer getNu_id_estatus() {
		return nu_id_estatus;
	}

	public void setNu_id_estatus(Integer nu_id_estatus) {
		this.nu_id_estatus = nu_id_estatus;
	}

	public String getCh_nombre() {
		return ch_nombre;
	}

	public void setCh_nombre(String ch_nombre) {
		this.ch_nombre = ch_nombre;
	}

	public Date getDa_registro() {
		return da_registro;
	}

	public void setDa_registro(Date da_registro) {
		this.da_registro = da_registro;
	}

	public String getCh_descripcion() {
		return ch_descripcion;
	}

	public void setCh_descripcion(String ch_descripcion) {
		this.ch_descripcion = ch_descripcion;
	}
}
