package es.uc3m.g3.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Entrada database table.
 * 
 */
@Entity
@Table(name="Entrada")
@NamedQuery(name="Entrada.findAll", query="SELECT e FROM Entrada e")
public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;

	@Column(name="Titular")
	private String titular;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="IdEvento")
	private Evento evento;

	//bi-directional many-to-one association to Recibo
	@ManyToOne
	@JoinColumn(name="IdRecibo")
	private Recibo recibo;

	public Entrada() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Recibo getRecibo() {
		return this.recibo;
	}

	public void setRecibo(Recibo recibo) {
		this.recibo = recibo;
	}

}