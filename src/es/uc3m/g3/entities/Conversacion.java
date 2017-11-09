package es.uc3m.g3.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Conversacion database table.
 * 
 */
@Entity
@Table(name="Conversacion")
@NamedQuery(name="Conversacion.findAll", query="SELECT c FROM Conversacion c")
public class Conversacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;

	//bi-directional many-to-one association to EntidadAdministrador
	@ManyToOne
	@JoinColumn(name="IdAdministrador")
	private EntidadAdministrador entidadAdministrador;

	//bi-directional many-to-one association to EntidadUsuario
	@ManyToOne
	@JoinColumn(name="IdUsuario")
	private EntidadUsuario entidadUsuario;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="conversacion")
	private List<Mensaje> mensajes;

	public Conversacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EntidadAdministrador getEntidadAdministrador() {
		return this.entidadAdministrador;
	}

	public void setEntidadAdministrador(EntidadAdministrador entidadAdministrador) {
		this.entidadAdministrador = entidadAdministrador;
	}

	public EntidadUsuario getEntidadUsuario() {
		return this.entidadUsuario;
	}

	public void setEntidadUsuario(EntidadUsuario entidadUsuario) {
		this.entidadUsuario = entidadUsuario;
	}

	public List<Mensaje> getMensajes() {
		return this.mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Mensaje addMensaje(Mensaje mensaje) {
		getMensajes().add(mensaje);
		mensaje.setConversacion(this);

		return mensaje;
	}

	public Mensaje removeMensaje(Mensaje mensaje) {
		getMensajes().remove(mensaje);
		mensaje.setConversacion(null);

		return mensaje;
	}

}