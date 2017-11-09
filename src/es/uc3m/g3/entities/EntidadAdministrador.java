package es.uc3m.g3.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EntidadAdministrador database table.
 * 
 */
@Entity
@Table(name="EntidadAdministrador")
@NamedQuery(name="EntidadAdministrador.findAll", query="SELECT e FROM EntidadAdministrador e")
public class EntidadAdministrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private String id;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional many-to-one association to Conversacion
	@OneToMany(mappedBy="entidadAdministrador")
	private List<Conversacion> conversacions;

	public EntidadAdministrador() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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
		conversacion.setEntidadAdministrador(this);

		return conversacion;
	}

	public Conversacion removeConversacion(Conversacion conversacion) {
		getConversacions().remove(conversacion);
		conversacion.setEntidadAdministrador(null);

		return conversacion;
	}

}