package es.uc3m.g3.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import es.uc3m.g3.bean.UserBean;

public class RestrictedRequestHandler {
	protected boolean checkRegisteredUser (HttpServletRequest request, UserBean user) {		
		HttpSession session = request.getSession();
		
		return session.getAttribute("user") != null;
	}
}
