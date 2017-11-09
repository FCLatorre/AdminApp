package es.uc3m.g3.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EntidadUsuario database table.
 * 
 */
@Entity
@Table(name="EntidadUsuario")
@NamedQuery(name="EntidadUsuario.findAll", query="SELECT e FROM EntidadUsuario e")
public class EntidadUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private String id;

	@Column(name="Apellidos")
	private String apellidos;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional many-to-one association to Conversacion
	@OneToMany(mappedBy="entidadUsuario")
	private List<Conversacion> conversacions;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="entidadUsuario")
	private List<Evento> eventos;

	//bi-directional many-to-one association to Recibo
	@OneToMany(mappedBy="entidadUsuario")
	private List<Recibo> recibos;

	public EntidadUsuario() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Conversacion> getConversacions() {
		return this.conversacions;
	}

	public void setConversacions(List<Conversacion> conversacions) {
		this.conversacions = conversacions;
	}

	public Conversacion addConversacion(Conversacion conversacion) {
		getConversacions().add(conversacion);
		conversacion.setEntidadUsuario(this);

		return conversacion;
	}

	public Conversacion removeConversacion(Conversacion conversacion) {
		getConversacions().remove(conversacion);
		conversacion.setEntidadUsuario(null);

		return conversacion;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setEntidadUsuario(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setEntidadUsuario(null);

		return evento;
	}

	public List<Recibo> getRecibos() {
		return this.recibos;
	}

	public void setRecibos(List<Recibo> recibos) {
		this.recibos = recibos;
	}

	public Recibo addRecibo(Recibo recibo) {
		getRecibos().add(recibo);
		recibo.setEntidadUsuario(this);

		return recibo;
	}

	public Recibo removeRecibo(Recibo recibo) {
		getRecibos().remove(recibo);
		recibo.setEntidadUsuario(null);

		return recibo;
	}

}