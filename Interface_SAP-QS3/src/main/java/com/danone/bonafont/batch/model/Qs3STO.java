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
@Table(name = "QS_TBL_QS3_STO", schema = "dbo")
public class Qs3STO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nu_id_orden_sto", unique = true, nullable = false, precision = 10)
	private Long nu_id_orden_sto;

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

	@Column(name = "ch_codecomp")
	private String ch_codecomp;

	@Column(name = "ch_tipopedido")
	private String ch_tipopedido;

	@Column(name = "ch_idioma")
	private String ch_idioma;

	@Column(name = "ch_orgventas")
	private String ch_orgventas;

	@Column(name = "ch_pedidos3")
	private String ch_pedidos3;

	@Column(name = "ch_origen")
	private String ch_origen;

	@Column(name = "ch_cubicuadre")
	private String ch_cubicuadre;

	@Column(name = "ch_estadopedido")
	private String ch_estadopedido;

	@Column(name = "ch_producto")
	private String ch_producto;

	@Column(name = "ch_destino")
	private String ch_destino;
	
	@Column(name = "ch_almacen")
	private String ch_almacen;

	@Column(name = "ch_cantidad")
	private String ch_cantidad;

	@Column(name = "ch_ordenunidad")
	private String ch_ordenunidad;

	@Column(name = "ch_lote")
	private String ch_lote;
	
	@Column(name = "nu_posicionitem")
	private Integer nu_posicionitem;

	@Column(name = "ch_numerolinea")
	private String ch_numerolinea;

	@Column(name = "ch_pedfechaemb")
	private String ch_pedfechaemb;

	@Column(name = "ch_carrier")
	private String ch_carrier;

	@Column(name = "ch_pedfechaent")
	private String ch_pedfechaent;

	@Column(name = "ch_pedfecha")
	private String ch_pedfecha;

	@Column(name = "ch_observa")
	private String ch_observa;
	
	@Column(name = "ch_status")
	private String ch_status;
	
	@Column(name = "ch_escrito")
	private String ch_escrito;
	
	@Column(name = "ch_leido")
	private String ch_leido;
	
	@Column(name = "ch_prioridad")
	private String ch_prioridad;
	
	@Column(name = "ch_purch_org")
	private String ch_purch_org;
	
	@Column(name = "ch_pur_group")
	private String ch_pur_group;
	
	@Column(name = "ch_currency")
	private String ch_currency;
	
	@Column(name = "ch_existencia")
	private String ch_existencia;
	
	public Long getNu_id_orden_sto() {
		return nu_id_orden_sto;
	}

	public void setNu_id_orden_sto(Long nu_id_orden_sto) {
		this.nu_id_orden_sto = nu_id_orden_sto;
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

	public String getCh_codecomp() {
		return ch_codecomp;
	}

	public void setCh_codecomp(String ch_codecomp) {
		this.ch_codecomp = ch_codecomp;
	}

	public String getCh_tipopedido() {
		return ch_tipopedido;
	}

	public void setCh_tipopedido(String ch_tipopedido) {
		this.ch_tipopedido = ch_tipopedido;
	}

	public String getCh_idioma() {
		return ch_idioma;
	}

	public void setCh_idioma(String ch_idioma) {
		this.ch_idioma = ch_idioma;
	}

	public String getCh_orgventas() {
		return ch_orgventas;
	}

	public void setCh_orgventas(String ch_orgventas) {
		this.ch_orgventas = ch_orgventas;
	}

	public String getCh_pedidos3() {
		return ch_pedidos3;
	}

	public void setCh_pedidos3(String ch_pedidos3) {
		this.ch_pedidos3 = ch_pedidos3;
	}

	public String getCh_origen() {
		return ch_origen;
	}

	public void setCh_origen(String ch_origen) {
		this.ch_origen = ch_origen;
	}

	public String getCh_cubicuadre() {
		return ch_cubicuadre;
	}

	public void setCh_cubicuadre(String ch_cubicuadre) {
		this.ch_cubicuadre = ch_cubicuadre;
	}

	public String getCh_estadopedido() {
		return ch_estadopedido;
	}

	public void setCh_estadopedido(String ch_estadopedido) {
		this.ch_estadopedido = ch_estadopedido;
	}

	public String getCh_producto() {
		return ch_producto;
	}

	public void setCh_producto(String ch_producto) {
		this.ch_producto = ch_producto;
	}

	public String getCh_destino() {
		return ch_destino;
	}

	public void setCh_destino(String ch_destino) {
		this.ch_destino = ch_destino;
	}

	public String getCh_almacen() {
		return ch_almacen;
	}

	public void setCh_almacen(String ch_almacen) {
		this.ch_almacen = ch_almacen;
	}

	public String getCh_cantidad() {
		return ch_cantidad;
	}

	public void setCh_cantidad(String ch_cantidad) {
		this.ch_cantidad = ch_cantidad;
	}

	public String getCh_ordenunidad() {
		return ch_ordenunidad;
	}

	public void setCh_ordenunidad(String ch_ordenunidad) {
		this.ch_ordenunidad = ch_ordenunidad;
	}

	public String getCh_lote() {
		return ch_lote;
	}

	public void setCh_lote(String ch_lote) {
		this.ch_lote = ch_lote;
	}

	public Integer getNu_posicionitem() {
		return nu_posicionitem;
	}

	public void setNu_posicionitem(Integer nu_posicionitem) {
		this.nu_posicionitem = nu_posicionitem;
	}

	public String getCh_numerolinea() {
		return ch_numerolinea;
	}

	public void setCh_numerolinea(String ch_numerolinea) {
		this.ch_numerolinea = ch_numerolinea;
	}

	public String getCh_pedfechaemb() {
		return ch_pedfechaemb;
	}

	public void setCh_pedfechaemb(String ch_pedfechaemb) {
		this.ch_pedfechaemb = ch_pedfechaemb;
	}

	public String getCh_carrier() {
		return ch_carrier;
	}

	public void setCh_carrier(String ch_carrier) {
		this.ch_carrier = ch_carrier;
	}

	public String getCh_pedfechaent() {
		return ch_pedfechaent;
	}

	public void setCh_pedfechaent(String ch_pedfechaent) {
		this.ch_pedfechaent = ch_pedfechaent;
	}

	public String getCh_pedfecha() {
		return ch_pedfecha;
	}

	public void setCh_pedfecha(String ch_pedfecha) {
		this.ch_pedfecha = ch_pedfecha;
	}

	public String getCh_observa() {
		return ch_observa;
	}

	public void setCh_observa(String ch_observa) {
		this.ch_observa = ch_observa;
	}

	public String getCh_status() {
		return ch_status;
	}

	public void setCh_status(String ch_status) {
		this.ch_status = ch_status;
	}

	public String getCh_escrito() {
		return ch_escrito;
	}

	public void setCh_escrito(String ch_escrito) {
		this.ch_escrito = ch_escrito;
	}

	public String getCh_leido() {
		return ch_leido;
	}

	public void setCh_leido(String ch_leido) {
		this.ch_leido = ch_leido;
	}

	public String getCh_prioridad() {
		return ch_prioridad;
	}

	public void setCh_prioridad(String ch_prioridad) {
		this.ch_prioridad = ch_prioridad;
	}

	public String getCh_purch_org() {
		return ch_purch_org;
	}

	public void setCh_purch_org(String ch_purch_org) {
		this.ch_purch_org = ch_purch_org;
	}

	public String getCh_pur_group() {
		return ch_pur_group;
	}

	public void setCh_pur_group(String ch_pur_group) {
		this.ch_pur_group = ch_pur_group;
	}

	public String getCh_currency() {
		return ch_currency;
	}

	public void setCh_currency(String ch_currency) {
		this.ch_currency = ch_currency;
	}

	public String getCh_existencia() {
		return ch_existencia;
	}

	public void setCh_existencia(String ch_existencia) {
		this.ch_existencia = ch_existencia;
	}

}
