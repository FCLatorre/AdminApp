package es.uc3m.g3.handlers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConversationsRequestHandler implements RequestHandlerInterface {

	@Override
	public String handleGETRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Handling the request in ConversationsRequestHandler");
		request.setAttribute("conversations", getConversations());
		return "conversations.jsp";
	}

	@Override
	public String handlePOSTRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String handlePUTRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String handleDELETERequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String getConversations (){
		return null;
	}

}
