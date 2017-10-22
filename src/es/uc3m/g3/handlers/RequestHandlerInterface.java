package es.uc3m.g3.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RequestHandlerInterface {
	public String handleGETRequest(HttpServletRequest request, HttpServletResponse response);
	public String handlePOSTRequest(HttpServletRequest request, HttpServletResponse response);
	public String handlePUTRequest(HttpServletRequest request, HttpServletResponse response);
	public String handleDELETERequest(HttpServletRequest request, HttpServletResponse response);
}
