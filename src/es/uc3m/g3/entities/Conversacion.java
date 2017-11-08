package es.uc3m.g3.entities;

import java.io.Serializable;
import javax.persistence.*;


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

	//bi-directional many-to-one association to EntidadUsuario
	@ManyToOne
	@JoinColumn(name="IdUsuario")
	private EntidadUsuario entidadUsuario;

	//bi-directional many-to-one association to EntidadAdministrador
	@ManyToOne
	@JoinColumn(name="IdAdministrador")
	private EntidadAdministrador entidadAdministrador;

	public Conversacion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EntidadUsuario getEntidadUsuario() {
		return this.entidadUsuario;
	}

	public void setEntidadUsuario(EntidadUsuario entidadUsuario) {
		this.entidadUsuario = entidadUsuario;
	}

	public EntidadAdministrador getEntidadAdministrador() {
		return this.entidadAdministrador;
	}

	public void setEntidadAdministrador(EntidadAdministrador entidadAdministrador) {
		this.entidadAdministrador = entidadAdministrador;
	}

}