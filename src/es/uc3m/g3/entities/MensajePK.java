package es.uc3m.g3.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Mensaje database table.
 * 
 */
@Embeddable
public class MensajePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="IdConversacion", insertable=false, updatable=false)
	private int idConversacion;

	@Column(name="IdCreador", insertable=false, updatable=false)
	private String idCreador;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MarcaTemporal")
	private java.util.Date marcaTemporal;

	public MensajePK() {
	}
	public int getIdConversacion() {
		return this.idConversacion;
	}
	public void setIdConversacion(int idConversacion) {
		this.idConversacion = idConversacion;
	}
	public String getIdCreador() {
		return this.idCreador;
	}
	public void setIdCreador(String idCreador) {
		this.idCreador = idCreador;
	}
	public java.util.Date getMarcaTemporal() {
		return this.marcaTemporal;
	}
	public void setMarcaTemporal(java.util.Date marcaTemporal) {
		this.marcaTemporal = marcaTemporal;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MensajePK)) {
			return false;
		}
		MensajePK castOther = (MensajePK)other;
		return 
			(this.idConversacion == castOther.idConversacion)
			&& this.idCreador.equals(castOther.idCreador)
			&& this.marcaTemporal.equals(castOther.marcaTemporal);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idConversacion;
		hash = hash * prime + this.idCreador.hashCode();
		hash = hash * prime + this.marcaTemporal.hashCode();
		
		return hash;
	}
}