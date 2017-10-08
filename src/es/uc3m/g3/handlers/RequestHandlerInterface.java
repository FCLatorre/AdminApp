package es.uc3m.g3.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RequestHandlerInterface {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
