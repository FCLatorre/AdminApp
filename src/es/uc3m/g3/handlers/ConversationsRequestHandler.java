package es.uc3m.g3.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import es.uc3m.g3.models.Conversation;
import es.uc3m.g3.models.User;
import es.uc3m.g3.models.Message;

public class ConversationsRequestHandler implements RequestHandlerInterface {
  
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

  private List<Conversation> getConversations() {
	Client client = ClientBuilder.newClient(); 
    List<Conversation> conversations = new ArrayList<Conversation>();
    WebTarget webResource = client.target("http://localhost:13305").path("/api/events");
    conversations = webResource.request().accept("application/json").get(java.util.ArrayList.class);
	
    return conversations;
  }

  private ArrayList<String> getDiferentConvId() {
    /*ArrayList<String> convs = new ArrayList<String>();
    for (Mensaje m : getConversations()) {
      if (!convs.contains(m.getIdConversation())) {
        convs.add(m.getIdConversation());
      }
    }
    return convs;*/
	  return null;
  }

  private ArrayList<Message> getConversationsById(String id) {
    /*ArrayList<Mensaje> messages = new ArrayList<Mensaje>();
    for (Mensaje m : getConversations()) {
      if (m.getIdConversation().equals(id)) {
        messages.add(m);
      }
    }
    return messages;*/
	  return null;
  }
}
