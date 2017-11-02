package es.uc3m.g3.entities;

import java.io.Serializable;
import javax.persistence.*;


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

}