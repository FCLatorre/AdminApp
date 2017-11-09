package es.uc3m.g3.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Recibo database table.
 * 
 */
@Entity
@Table(name="Recibo")
@NamedQuery(name="Recibo.findAll", query="SELECT r FROM Recibo r")
public class Recibo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="FechaCompra")
	private Date fechaCompra;

	@Column(name="Total")
	private BigDecimal total;

	//bi-directional many-to-one association to Entrada
	@OneToMany(mappedBy="recibo")
	private List<Entrada> entradas;

	//bi-directional many-to-one association to EntidadUsuario
	@ManyToOne
	@JoinColumn(name="IdComprador")
	private EntidadUsuario entidadUsuario;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="IdEvento")
	private Evento evento;

	public Recibo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<Entrada> getEntradas() {
		return this.entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Entrada addEntrada(Entrada entrada) {
		getEntradas().add(entrada);
		entrada.setRecibo(this);

		return entrada;
	}

	public Entrada removeEntrada(Entrada entrada) {
		getEntradas().remove(entrada);
		entrada.setRecibo(null);

		return entrada;
	}

	public EntidadUsuario getEntidadUsuario() {
		return this.entidadUsuario;
	}

	public void setEntidadUsuario(EntidadUsuario entidadUsuario) {
		this.entidadUsuario = entidadUsuario;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}