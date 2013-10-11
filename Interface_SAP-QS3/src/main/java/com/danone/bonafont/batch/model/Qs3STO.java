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

	@Column(name = "ch_producto")
	private String ch_producto;

	@Column(name = "ch_destino")
	private String ch_destino;
	
	@Column(name = "ch_almacen")
	private String ch_almacen;

	@Column(name = "ch_cantidad")
	private String ch_cantidad;

	@Column(name = "ch_lote")
	private String ch_lote;
	
	@Column(name = "nu_posicionitem")
	private Integer nu_posicionitem;

	@Column(name = "ch_numerolinea")
	private String ch_numerolinea;

	@Column(name = "ch_pedfechaemb")
	private String ch_pedfechaemb;

	@Column(name = "ch_observa")
	private String ch_observa;
	
	@Column(name = "ch_status")
	private String ch_status;
	
	@Column(name = "da_escrito")
	@Temporal(TemporalType.TIMESTAMP)
	private Date da_escrito;
	
	@Column(name = "da_leido")
	@Temporal(TemporalType.TIMESTAMP)
	private Date da_leido;
	
	@Column(name = "nu_prioridad")
	private Integer nu_prioridad;
	
	@Column(name = "ch_purch_org")
	private String ch_purch_org;
	
	@Column(name = "ch_pur_group")
	private String ch_pur_group;
	
	@Column(name = "ch_currency")
	private String ch_currency;
	
	@Column(name = "ch_orderunit")
	private String ch_orderunit;

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

	public Date getDa_escrito() {
		return da_escrito;
	}

	public void setDa_escrito(Date da_escrito) {
		this.da_escrito = da_escrito;
	}

	public Date getDa_leido() {
		return da_leido;
	}

	public void setDa_leido(Date da_leido) {
		this.da_leido = da_leido;
	}

	public Integer getNu_prioridad() {
		return nu_prioridad;
	}

	public void setNu_prioridad(Integer nu_prioridad) {
		this.nu_prioridad = nu_prioridad;
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

	public String getCh_orderunit() {
		return ch_orderunit;
	}

	public void setCh_orderunit(String ch_orderunit) {
		this.ch_orderunit = ch_orderunit;
	}


}
