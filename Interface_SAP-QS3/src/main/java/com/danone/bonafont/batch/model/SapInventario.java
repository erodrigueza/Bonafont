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
import javax.persistence.Transient;

/**
 * @author Eduardo Rodriguez
 *
 */
@Entity
@Table(name = "QS_TBL_SAP_INVENTARIO", schema = "dbo")
public class SapInventario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)  
    @Column(name = "id_inventario", unique = true, nullable = false, precision = 10)  
    private Integer id_inventario;
	
	@Column(name = "nu_id_estatus", nullable = false)  
	private Integer nu_id_estatus;
	
	@Column(name = "da_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date da_registro;
	
	@Column(name = "nu_id_archivo", nullable = false)
	private Long nu_id_archivo;
	
	@Column(name = "da_proceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date da_proceso;

	@Column(name = "ch_distribuidora")
	private String ch_distribuidora;

	@Column(name = "ch_almacen")
	private String ch_almacen;

	@Column(name = "ch_producto")
	private String ch_producto;

	@Column(name = "ch_lote")
	private String ch_lote;

	@Column(name = "ch_edodesc")
	private String ch_edodesc;

	@Column(name = "nu_existencia")
	private String nu_existencia;

	@Column(name = "da_fechaprod")
    @Temporal(TemporalType.TIMESTAMP)
	private Date da_fechaprod;

	@Column(name = "ch_tipo_material")
	private String ch_tipo_material;
	
	@Transient
	private String dummy;

	public Integer getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(Integer id_inventario) {
		this.id_inventario = id_inventario;
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

	public String getCh_distribuidora() {
		return ch_distribuidora;
	}

	public void setCh_distribuidora(String ch_distribuidora) {
		this.ch_distribuidora = ch_distribuidora;
	}

	public String getCh_almacen() {
		return ch_almacen;
	}

	public void setCh_almacen(String ch_almacen) {
		this.ch_almacen = ch_almacen;
	}

	public String getCh_producto() {
		return ch_producto;
	}

	public void setCh_producto(String ch_producto) {
		this.ch_producto = ch_producto;
	}

	public String getCh_lote() {
		return ch_lote;
	}

	public void setCh_lote(String ch_lote) {
		this.ch_lote = ch_lote;
	}

	public String getCh_edodesc() {
		return ch_edodesc;
	}

	public void setCh_edodesc(String ch_edodesc) {
		this.ch_edodesc = ch_edodesc;
	}

	public String getNu_existencia() {
		return nu_existencia;
	}

	public void setNu_existencia(String nu_existencia) {
		this.nu_existencia = nu_existencia;
	}

	public Date getDa_fechaprod() {
		return da_fechaprod;
	}

	public void setDa_fechaprod(Date da_fechaprod) {
		this.da_fechaprod = da_fechaprod;
	}

	public String getCh_tipo_material() {
		return ch_tipo_material;
	}

	public void setCh_tipo_material(String ch_tipo_material) {
		this.ch_tipo_material = ch_tipo_material;
	}

	public String getDummy() {
		return dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}

}
