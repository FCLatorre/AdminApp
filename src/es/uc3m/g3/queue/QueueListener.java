package es.uc3m.g3.queue;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;

import es.uc3m.g3.entities.Conversacion;
import es.uc3m.g3.entities.EntidadRol;
import es.uc3m.g3.entities.Mensaje;
import es.uc3m.g3.entities.MensajePK;

public class QueueListener implements MessageListener {
	private EntityManager em;
	
	public QueueListener (EntityManager em){
		this.em = em;
	}
	@Override
	public void onMessage(Message arg0) {
		if(arg0 instanceof TextMessage){
			try {
				TextMessage msg = (TextMessage) arg0;
				System.out.println("AdminApp: Mensaje recibido: "+msg.getText());
				System.out.println("AdminApp: De: "+msg.getStringProperty("sendBy"));
				System.out.println("AdminApp: Hora: "+msg.getStringProperty("timestamp"));
				
				
				MensajePK key = new MensajePK();
				
				key.setIdConversacion(msg.getIntProperty("conversationId"));
				key.setIdCreador(msg.getStringProperty("sendBy"));
				key.setMarcaTemporal(new Date (msg.getLongProperty("timestamp")));
				
				Mensaje mensaje = new Mensaje();
				
				mensaje.setId(key);
				mensaje.setContenido(msg.getText());
				mensaje.setConversacion(em.find(Conversacion.class, msg.getIntProperty("conversationId")));
				mensaje.setEntidadRol(em.find(EntidadRol.class, msg.getStringProperty("sendBy")));
				
				em.persist(mensaje);
				
				System.out.println("Message saved!");
				
				
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Mensaje recibido de tipo distinto a TextMessage!");
		}
	}

}
