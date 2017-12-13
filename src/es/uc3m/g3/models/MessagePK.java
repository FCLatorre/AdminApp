package es.uc3m.g3.models;

import java.io.Serializable;
import javax.persistence.*;

public class MessagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idconversation;

	private byte user;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date timestamp;

	public MessagePK() {
	}
	public int getIdconversation() {
		return this.idconversation;
	}
	public void setIdconversation(int idconversation) {
		this.idconversation = idconversation;
	}
	public byte getUser() {
		return this.user;
	}
	public void setUser(byte user) {
		this.user = user;
	}
	public java.util.Date getTimestamp() {
		return this.timestamp;
	}
	public void setTimestamp(java.util.Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MessagePK)) {
			return false;
		}
		MessagePK castOther = (MessagePK)other;
		return 
			(this.idconversation == castOther.idconversation)
			&& (this.user == castOther.user)
			&& this.timestamp.equals(castOther.timestamp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idconversation;
		hash = hash * prime + ((int) this.user);
		hash = hash * prime + this.timestamp.hashCode();
		
		return hash;
	}
}