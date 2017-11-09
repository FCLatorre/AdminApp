package es.uc3m.g3.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Evento database table.
 * 
 */
@Entity
@Table(name="Evento")
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;

	@Column(name="Descripcion")
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="Fecha")
	private Date fecha;

	@Column(name="Hora")
	private Time hora;

	@Lob
	@Column(name="Imagen")
	private byte[] imagen;

	@Column(name="Localizacion")
	private String localizacion;

	@Column(name="NumeroEntradas")
	private short numeroEntradas;

	@Column(name="Precio")
	private BigDecimal precio;

	@Column(name="Sala")
	private String sala;

	@Column(name="Titulo")
	private String titulo;

	//bi-directional many-to-one association to Entrada
	@OneToMany(mappedBy="evento")
	private List<Entrada> entradas;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="Categoria")
	private Categoria categoriaBean;

	//bi-directional many-to-one association to EntidadUsuario
	@ManyToOne
	@JoinColumn(name="IdCreador")
	private EntidadUsuario entidadUsuario;

	//bi-directional many-to-one association to Recibo
	@OneToMany(mappedBy="evento")
	private List<Recibo> recibos;

	public Evento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getLocalizacion() {
		return this.localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public short getNumeroEntradas() {
		return this.numeroEntradas;
	}

	public void setNumeroEntradas(short numeroEntradas) {
		this.numeroEntradas = numeroEntradas;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getSala() {
		return this.sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Entrada> getEntradas() {
		return this.entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Entrada addEntrada(Entrada entrada) {
		getEntradas().add(entrada);
		entrada.setEvento(this);

		return entrada;
	}

	public Entrada removeEntrada(Entrada entrada) {
		getEntradas().remove(entrada);
		entrada.setEvento(null);

		return entrada;
	}

	public Categoria getCategoriaBean() {
		return this.categoriaBean;
	}

	public void setCategoriaBean(Categoria categoriaBean) {
		this.categoriaBean = categoriaBean;
	}

	public EntidadUsuario getEntidadUsuario() {
		return this.entidadUsuario;
	}

	public void setEntidadUsuario(EntidadUsuario entidadUsuario) {
		this.entidadUsuario = entidadUsuario;
	}

	public List<Recibo> getRecibos() {
		return this.recibos;
	}

	public void setRecibos(List<Recibo> recibos) {
		this.recibos = recibos;
	}

	public Recibo addRecibo(Recibo recibo) {
		getRecibos().add(recibo);
		recibo.setEvento(this);

		return recibo;
	}

	public Recibo removeRecibo(Recibo recibo) {
		getRecibos().remove(recibo);
		recibo.setEvento(null);

		return recibo;
	}

}