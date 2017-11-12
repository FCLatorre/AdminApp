package es.uc3m.g3.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import es.uc3m.g3.entities.Conversacion;
import es.uc3m.g3.entities.EntidadUsuario;

import es.uc3m.g3.bean.MessageBean;

public class ConversationsRequestHandler implements RequestHandlerInterface {
  private EntityManager em;
  private UserTransaction ut;
  public ConversationsRequestHandler(EntityManager em, UserTransaction ut) {
    this.em = em;
    this.ut = ut;
  }
  @Override
  public String handleGETRequest(HttpServletRequest request,
                                 HttpServletResponse response) {
    System.out.println("Handling the request in ConversationsRequestHandler");
    request.setAttribute("conversations", getConversations());
    return "conversations.jsp";
  }

  @Override
  public String handlePOSTRequest(HttpServletRequest request,
                                  HttpServletResponse response) {
    // TODO Auto-generated method stub
    return handleGETRequest(request, response);
  }

  @Override
  public String handlePUTRequest(HttpServletRequest request,
                                 HttpServletResponse response) {
    // TODO Auto-generated method stub
    return handleGETRequest(request, response);
  }

  @Override
  public String handleDELETERequest(HttpServletRequest request,
                                    HttpServletResponse response) {
    // TODO Auto-generated method stub
    return handleGETRequest(request, response);
  }

  private ArrayList<Conversacion> getConversations() {
    Query query = em.createNamedQuery("Conversacion.findAll");
    List<Conversacion> conversations = query.getResultList();
    for (Conversacion conversation : conversations) {
      System.out.println(conversation.getEntidadAdministrador().getNombre() +
                         conversation.getEntidadUsuario().getNombre());
    }
    return new ArrayList<Conversacion>(conversations);
  }

  private ArrayList<String> getDiferentConvId() {
    ArrayList<String> convs = new ArrayList<String>();
    for (MessageBean m : getConversations()) {
      if (!convs.contains(m.getIdConversation())) {
        convs.add(m.getIdConversation());
      }
    }
    return convs;
  }

  private ArrayList<MessageBean> getConversationsById(String id) {
    ArrayList<MessageBean> messages = new ArrayList<MessageBean>();
    for (MessageBean m : getConversations()) {
      if (m.getIdConversation().equals(id)) {
        messages.add(m);
      }
    }
    return messages;
  }
}
