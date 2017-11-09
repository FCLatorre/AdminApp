package es.uc3m.g3.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Mensaje database table.
 * 
 */
@Entity
@Table(name="Mensaje")
@NamedQuery(name="Mensaje.findAll", query="SELECT m FROM Mensaje m")
public class Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MensajePK id;

	@Column(name="Contenido")
	private String contenido;

	@Column(name="Leido")
	private byte leido;

	@Column(name="Recibido")
	private byte recibido;

	//bi-directional many-to-one association to Conversacion
	@ManyToOne
	@JoinColumn(name="IdConversacion")
	private Conversacion conversacion;

	//bi-directional many-to-one association to EntidadRol
	@ManyToOne
	@JoinColumn(name="IdCreador")
	private EntidadRol entidadRol;

	public Mensaje() {
	}

	public MensajePK getId() {
		return this.id;
	}

	public void setId(MensajePK id) {
		this.id = id;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public byte getLeido() {
		return this.leido;
	}

	public void setLeido(byte leido) {
		this.leido = leido;
	}

	public byte getRecibido() {
		return this.recibido;
	}

	public void setRecibido(byte recibido) {
		this.recibido = recibido;
	}

	public Conversacion getConversacion() {
		return this.conversacion;
	}

	public void setConversacion(Conversacion conversacion) {
		this.conversacion = conversacion;
	}

	public EntidadRol getEntidadRol() {
		return this.entidadRol;
	}

	public void setEntidadRol(EntidadRol entidadRol) {
		this.entidadRol = entidadRol;
	}

}