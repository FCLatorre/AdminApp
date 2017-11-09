package es.uc3m.g3.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EntidadRol database table.
 * 
 */
@Entity
@Table(name="EntidadRol")
@NamedQuery(name="EntidadRol.findAll", query="SELECT e FROM EntidadRol e")
public class EntidadRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private String id;

	@Column(name="Contraseña")
	private String contraseña;

	@Column(name="Desafio")
	private String desafio;

	@Column(name="Email")
	private String email;

	@Column(name="IdEntidad")
	private String idEntidad;

	@Column(name="Respuesta")
	private String respuesta;

	@Column(name="TipoEntidad")
	private String tipoEntidad;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="entidadRol")
	private List<Mensaje> mensajes;

	public EntidadRol() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getDesafio() {
		return this.desafio;
	}

	public void setDesafio(String desafio) {
		this.desafio = desafio;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getTipoEntidad() {
		return this.tipoEntidad;
	}

	public void setTipoEntidad(String tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	public List<Mensaje> getMensajes() {
		return this.mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Mensaje addMensaje(Mensaje mensaje) {
		getMensajes().add(mensaje);
		mensaje.setEntidadRol(this);

		return mensaje;
	}

	public Mensaje removeMensaje(Mensaje mensaje) {
		getMensajes().remove(mensaje);
		mensaje.setEntidadRol(null);

		return mensaje;
	}

}