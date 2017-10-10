package es.uc3m.g3.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.g3.handlers.LoginRequestHandler;
import es.uc3m.g3.handlers.RequestHandlerInterface;
import es.uc3m.g3.handlers.UserRequestHandler;

/**
 * Servlet implementation class RequestController
 */
@WebServlet(urlPatterns = {"/login", "/users"})
public class RequestController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private HashMap<String, RequestHandlerInterface> requestHandlers =
      new HashMap<String, RequestHandlerInterface>();
  /**
   * @see HttpServlet#HttpServlet()
   */
  public RequestController() {
    super();
    requestHandlers.put("/login", new LoginRequestHandler());
    requestHandlers.put("/users", new UserRequestHandler());
    requestHandlers.put("/events", new EventRequestHandler());
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   * response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("Handling the request in RequestController");
    RequestHandlerInterface rhi = requestHandlers.get(request.getServletPath());

    String view = rhi.handleRequest(request, response);

    request.getRequestDispatcher(view).forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   * response)
   */
  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}
