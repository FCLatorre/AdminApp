package es.uc3m.g3.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uc3m.g3.bean.UserBean;

public class LoginRequestHandler implements RequestHandlerInterface {
	private Connection con;
	
	public LoginRequestHandler(Connection con){
		super();
		this.con = con;
	}
	@Override
	public String handleGETRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Handling the request in LoginRequestHandler");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email == null || password== null) {
			System.out.println("LoginRequestHandler: no parameters");
			request.setAttribute("nologin", "No parameters where received");
			return "login.jsp";
		}

		if(checkLogin(email, password)){
			System.out.println("LoginRequestHandler: login correct!");
			saveUserToSession(request, email, password);
			String newURL = (String) request.getSession().getAttribute("from");
			request.getSession().setAttribute("from", null);
			if(newURL==null){
				newURL="users";
			}
			return newURL;
		}else{
			System.out.println("LoginRequestHandler: login incorrect!");
			request.setAttribute("nologin", "Incorrect username or password");
			return "login.jsp";
		}
	}
	@Override
	public String handlePOSTRequest(HttpServletRequest request, HttpServletResponse response) {
		return handleGETRequest(request, response);
	}
	@Override
	public String handlePUTRequest(HttpServletRequest request, HttpServletResponse response) {
		return handleGETRequest(request, response);
	}
	@Override
	public String handleDELETERequest(HttpServletRequest request, HttpServletResponse response) {
		return handleGETRequest(request, response);
	}

	private boolean checkLogin (String email, String password){
		try{
			PreparedStatement ps = con.prepareStatement("select * from EntidadAdministrador where Id=SHA1(?)");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("El usuario es un administrador. Recuperando información de login...");
				ps = con.prepareStatement("select * from EntidadRol where Email=? and Contraseña=SHA1(?)");
				ps.setString(1, email);
				ps.setString(2, password);
				rs = ps.executeQuery();
				boolean bool = rs.next()!=false;
				ps.close();
				return bool;
			} else {
				System.out.println("El usuario no es un administrador de esta aplicación");
				return false;
			}
		} catch (SQLException e){
			return false;
		}
	}

	private void saveUserToSession(HttpServletRequest request, String email, String password){
		request.getSession().setAttribute("user", new UserBean(email, password));
	}

}
