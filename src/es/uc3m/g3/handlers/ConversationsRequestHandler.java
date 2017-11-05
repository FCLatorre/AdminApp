package es.uc3m.g3.handlers;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.g3.bean.MessageBean;

public class ConversationsRequestHandler implements RequestHandlerInterface {

  @Override
  public String handleGETRequest(HttpServletRequest request,
                                 HttpServletResponse response) {
    System.out.println("Handling the request in ConversationsRequestHandler");
    request.setAttribute("conversations", getDiferentConvId());
    if (request.getParameter("id") != null) {
      request.setAttribute(
          "messages", getConversationsById((String)request.getParameter("id")));
      request.setAttribute("id", request.getParameter("id"));
    } else {
      request.setAttribute("messages", null);
    }
    return "conversations.jsp";
  }

  @Override
  public String handlePOSTRequest(HttpServletRequest request,
                                  HttpServletResponse response) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String handlePUTRequest(HttpServletRequest request,
                                 HttpServletResponse response) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String handleDELETERequest(HttpServletRequest request,
                                    HttpServletResponse response) {
    // TODO Auto-generated method stub
    return null;
  }

  private ArrayList<MessageBean> getConversations() {
    ArrayList<MessageBean> conversations = new ArrayList<MessageBean>();

    Date date = new Date();

    conversations.add(
        new MessageBean("conv1", "ferchas@admin.com", "Hola, que tal"));
    conversations.add(
        new MessageBean("conv1", "admin@admin.com", "Hola, bien y tu"));
    conversations.add(
        new MessageBean("conv1", "ferchas@admin.com", "Bien gracias"));
    conversations.add(new MessageBean("conv1", "admin@admin.com", "que haces"));
    conversations.add(
        new MessageBean("conv2", "ernesto@admin.com", "Hey, me ayudas??"));
    conversations.add(
        new MessageBean("conv2", "admin@admin.com", "Que necesitas??"));
    conversations.add(
        new MessageBean("conv2", "ernesto@admin.com", "Hacer GET a UserApp"));
    conversations.add(
        new MessageBean("conv2", "admin@admin.com", "Hazlo a /messages"));
    return conversations;
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
