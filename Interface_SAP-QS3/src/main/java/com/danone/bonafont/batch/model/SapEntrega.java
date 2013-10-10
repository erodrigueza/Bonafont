package com.danone.bonafont.batch.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author Eduardo Rodriguez
 *
 */
@Entity
@Table(name = "QS_TBL_SAP_ENTREGA", schema = "dbo")
@NamedQuery(name="SapEntrega.findByFolioProducto", query="SELECT t FROM SapEntrega t, Archivo s WHERE t.ch_foliopedido = :ch_foliopedido AND t.ch_producto = :ch_producto AND s.nu_id_archivo = t.nu_id_archivo AND s.nu_id_estatus = 1001")
public class SapEntrega implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)  
    @Column(name = "nu_id_orden_ent", unique = true, nullable = false, precision = 10)  
    private Integer nu_id_orden_ent;
	
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

	@Column(name = "ch_origen")
	private String ch_origen;

	@Column(name = "ch_seriepedido")
	private String ch_seriepedido;

	@Column(name = "ch_foliopedido")
	private String ch_foliopedido;

	@Column(name = "ch_destino")
	private String ch_destino;

	@Column(name = "ch_pedfecha")
	private String ch_pedfecha;

	@Column(name = "ch_pedfechaemb")
	private String ch_pedfechaemb;

	@Column(name = "ch_pedfechaent")
	private String ch_pedfechaent;

	@Column(name = "ch_estadopedido")
	private String ch_estadopedido;

	@Column(name = "ch_observa")
	private String ch_observa;

	@Column(name = "ch_producto")
	private String ch_producto;

	@Column(name = "ch_cantidad")
	private String ch_cantidad;

	@Column(name = "ch_fechaembarque")
	private String ch_fechaembarque;

	@Column(name = "ch_ocedi")
	private String ch_ocedi;

	@Column(name = "da_avisos")
    @Temporal(TemporalType.TIMESTAMP)
	private Date da_avisos;

	@Column(name = "ch_comentario")
	private String ch_comentario;

	@Column(name = "ch_occamion")
	private String ch_occamion;

	@Column(name = "ch_proveedoredi")
	private String ch_proveedoredi;

	@Column(name = "ch_fecha_transito")
	private String ch_fecha_transito;

	@Column(name = "ch_cubicuadre")
	private String ch_cubicuadre;

	@Column(name = "ch_pedidos3")
	private String ch_pedidos3;

	@Column(name = "ch_tarimas")
	private String ch_tarimas;

	@Column(name = "ch_peso")
	private String ch_peso;

	@Column(name = "ch_status")
	private String ch_status;

	@Column(name = "da_escrito")
    @Temporal(TemporalType.TIMESTAMP)
	private Date da_escrito;

	@Column(name = "da_leido")
    @Temporal(TemporalType.TIMESTAMP)
	private Date da_leido;

	@Column(name = "nu_id")
	private Long nu_id;

	@Column(name = "ch_almacen")
	private String ch_almacen;

	@Transient
	private String dummy;

	public Integer getNu_id_orden_ent() {
		return nu_id_orden_ent;
	}

	public void setNu_id_orden_ent(Integer nu_id_orden_ent) {
		this.nu_id_orden_ent = nu_id_orden_ent;
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

	public String getCh_origen() {
		return ch_origen;
	}

	public void setCh_origen(String ch_origen) {
		this.ch_origen = ch_origen;
	}

	public String getCh_seriepedido() {
		return ch_seriepedido;
	}

	public void setCh_seriepedido(String ch_seriepedido) {
		this.ch_seriepedido = ch_seriepedido;
	}

	public String getCh_foliopedido() {
		return ch_foliopedido;
	}

	public void setCh_foliopedido(String ch_foliopedido) {
		this.ch_foliopedido = ch_foliopedido;
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

	public String getCh_fechaembarque() {
		return ch_fechaembarque;
	}

	public void setCh_fechaembarque(String ch_fechaembarque) {
		this.ch_fechaembarque = ch_fechaembarque;
	}

	public String getCh_ocedi() {
		return ch_ocedi;
	}

	public void setCh_ocedi(String ch_ocedi) {
		this.ch_ocedi = ch_ocedi;
	}

	public Date getDa_avisos() {
		return da_avisos;
	}

	public void setDa_avisos(Date da_avisos) {
		this.da_avisos = da_avisos;
	}

	public String getCh_comentario() {
		return ch_comentario;
	}

	public void setCh_comentario(String ch_comentario) {
		this.ch_comentario = ch_comentario;
	}

	public String getCh_occamion() {
		return ch_occamion;
	}

	public void setCh_occamion(String ch_occamion) {
		this.ch_occamion = ch_occamion;
	}

	public String getCh_proveedoredi() {
		return ch_proveedoredi;
	}

	public void setCh_proveedoredi(String ch_proveedoredi) {
		this.ch_proveedoredi = ch_proveedoredi;
	}

	public String getCh_fecha_transito() {
		return ch_fecha_transito;
	}

	public void setCh_fecha_transito(String ch_fecha_transito) {
		this.ch_fecha_transito = ch_fecha_transito;
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

	public String getCh_tarimas() {
		return ch_tarimas;
	}

	public void setCh_tarimas(String ch_tarimas) {
		this.ch_tarimas = ch_tarimas;
	}

	public String getCh_peso() {
		return ch_peso;
	}

	public void setCh_peso(String ch_peso) {
		this.ch_peso = ch_peso;
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

	public Long getNu_id() {
		return nu_id;
	}

	public void setNu_id(Long nu_id) {
		this.nu_id = nu_id;
	}

	public String getCh_almacen() {
		return ch_almacen;
	}

	public void setCh_almacen(String ch_almacen) {
		this.ch_almacen = ch_almacen;
	}

	public String getDummy() {
		return dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}



}
