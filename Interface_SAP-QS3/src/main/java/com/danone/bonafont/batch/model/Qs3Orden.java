package com.danone.bonafont.batch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "QS_TBL_QS3_ORDEN", schema = "dbo")
public class Qs3Orden implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id  
    @Column(name = "nu_id_orden", unique = true, nullable = false, precision = 10)  
	private Long nu_id_orden    ;
	
	@Column(name = "nu_id_estatus", nullable = false)  
    private Integer nu_id_estatus  ;
	
	@Column(name = "da_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date da_registro    ;
	
	@Column(name = "nu_id_archivo")
	private Long nu_id_archivo  ;
	
	@Column(name = "da_proceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date da_proceso     ;
	
	@Column(name = "ch_tipopedido")
	private String ch_tipopedido  ;
	
	@Column(name = "ch_orgventas")
	private String ch_orgventas   ;
	
	@Column(name = "ch_canaldist")
	private String ch_canaldist   ;
	
	@Column(name = "ch_division")
	private String ch_division    ;
	
	@Column(name = "ch_destino")
	private String ch_destino     ;
	
	@Column(name = "ch_pedfecha")
	private String ch_pedfecha    ;
	
	@Column(name = "ch_pedfechaemb")
	private String ch_pedfechaemb ;
	
	@Column(name = "ch_pedfechaent")
	private String ch_pedfechaent ;
	
	@Column(name = "ch_producto")
	private String ch_producto    ;
	
	@Column(name = "ch_cantidad")
	private String ch_cantidad    ;
	
	@Column(name = "ch_origen")
	private String ch_origen      ;
	
	@Column(name = "ch_almacen")
	private String ch_almacen     ;
	
	@Column(name = "ch_foliopedido")
	private String ch_foliopedido ;
	
	@Column(name = "ch_estadopedido")
	private String ch_estadopedido;
	
	@Column(name = "ch_observa")
	private String ch_observa     ;
	
	@Column(name = "ch_ocedi")
	private String ch_ocedi       ;
	
	@Column(name = "ch_cubicuadre")
	private String ch_cubicuadre  ;
	
	@Column(name = "ch_pedidos3")
	private String ch_pedidos3    ;
	
	@Column(name = "ch_occamion")
	private String ch_occamion    ;
	
	@Column(name = "ch_pedtipo")
	private String ch_pedtipo     ;
	
	@Column(name = "nu_prioridad")
	private Integer nu_prioridad   ;
	
	@Column(name = "ch_razonpedido")
	private String ch_razonpedido ;

	@Column(name = "ch_tipofactura")
	private String ch_tipofactura ;
	
	@Transient
	private String dummy;

	public Long getNu_id_orden() {
		return nu_id_orden;
	}

	public void setNu_id_orden(Long nu_id_orden) {
		this.nu_id_orden = nu_id_orden;
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

	public String getCh_tipopedido() {
		return ch_tipopedido;
	}

	public void setCh_tipopedido(String ch_tipopedido) {
		this.ch_tipopedido = ch_tipopedido;
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

	public String getCh_destino() {
		return ch_destino;
	}

	public void setCh_destino(String ch_destino) {
		this.ch_destino = ch_destino;
	}

	public String getCh_pedfecha() {
		return ch_pedfecha;
	}

	public void setCh_pedfecha(String ch_pedfecha) {
		this.ch_pedfecha = ch_pedfecha;
	}

	public String getCh_pedfechaemb() {
		return ch_pedfechaemb;
	}

	public void setCh_pedfechaemb(String ch_pedfechaemb) {
		this.ch_pedfechaemb = ch_pedfechaemb;
	}

	public String getCh_pedfechaent() {
		return ch_pedfechaent;
	}

	public void setCh_pedfechaent(String ch_pedfechaent) {
		this.ch_pedfechaent = ch_pedfechaent;
	}

	public String getCh_producto() {
		return ch_producto;
	}

	public void setCh_producto(String ch_producto) {
		this.ch_producto = ch_producto;
	}

	public String getCh_cantidad() {
		return ch_cantidad;
	}

	public void setCh_cantidad(String ch_cantidad) {
		this.ch_cantidad = ch_cantidad;
	}

	public String getCh_origen() {
		return ch_origen;
	}

	public void setCh_origen(String ch_origen) {
		this.ch_origen = ch_origen;
	}

	public String getCh_almacen() {
		return ch_almacen;
	}

	public void setCh_almacen(String ch_almacen) {
		this.ch_almacen = ch_almacen;
	}

	public String getCh_foliopedido() {
		return ch_foliopedido;
	}

	public void setCh_foliopedido(String ch_foliopedido) {
		this.ch_foliopedido = ch_foliopedido;
	}

	public String getCh_estadopedido() {
		return ch_estadopedido;
	}

	public void setCh_estadopedido(String ch_estadopedido) {
		this.ch_estadopedido = ch_estadopedido;
	}

	public String getCh_observa() {
		return ch_observa;
	}

	public void setCh_observa(String ch_observa) {
		this.ch_observa = ch_observa;
	}

	public String getCh_ocedi() {
		return ch_ocedi;
	}

	public void setCh_ocedi(String ch_ocedi) {
		this.ch_ocedi = ch_ocedi;
	}

	public String getCh_cubicuadre() {
		return ch_cubicuadre;
	}

	public void setCh_cubicuadre(String ch_cubicuadre) {
		this.ch_cubicuadre = ch_cubicuadre;
	}

	public String getCh_pedidos3() {
		return ch_pedidos3;
	}

	public void setCh_pedidos3(String ch_pedidos3) {
		this.ch_pedidos3 = ch_pedidos3;
	}

	public String getCh_occamion() {
		return ch_occamion;
	}

	public void setCh_occamion(String ch_occamion) {
		this.ch_occamion = ch_occamion;
	}

	public String getCh_pedtipo() {
		return ch_pedtipo;
	}

	public void setCh_pedtipo(String ch_pedtipo) {
		this.ch_pedtipo = ch_pedtipo;
	}

	public Integer getNu_prioridad() {
		return nu_prioridad;
	}

	public void setNu_prioridad(Integer nu_prioridad) {
		this.nu_prioridad = nu_prioridad;
	}

	public String getCh_razonpedido() {
		return ch_razonpedido;
	}

	public void setCh_razonpedido(String ch_razonpedido) {
		this.ch_razonpedido = ch_razonpedido;
	}

	public String getCh_tipofactura() {
		return ch_tipofactura;
	}

	public void setCh_tipofactura(String ch_tipofactura) {
		this.ch_tipofactura = ch_tipofactura;
	}

	public String getDummy() {
		return dummy;
	}
	
	public void setDummy(String dummy) {
		this.dummy = dummy;
	}
	
}
