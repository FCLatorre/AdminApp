package es.uc3m.g3.models;

import java.io.Serializable;
import javax.persistence.*;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MessagePK id;

	private String content;

	private byte readed;

	private byte received;

	//bi-directional many-to-one association to Conversation
	@ManyToOne
	@JoinColumn(name="idconversation")
	private Conversation conversation;

	public Message() {
	}

	public MessagePK getId() {
		return this.id;
	}

	public void setId(MessagePK id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte getReaded() {
		return this.readed;
	}

	public void setReaded(byte readed) {
		this.readed = readed;
	}

	public byte getReceived() {
		return this.received;
	}

	public void setReceived(byte received) {
		this.received = received;
	}

	public Conversation getConversation() {
		return this.conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

}