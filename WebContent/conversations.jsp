<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,es.uc3m.g3.entities.Conversacion" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="ISO-8859-1">
  <title>Conversations</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
  <link rel="stylesheet" href="styles.css">
  <link rel="stylesheet" href="conversations.css">
  <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</head>

<body>

  <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Chat"/>
    </jsp:include>
    <main class="mdl-layout__content mdl-color--grey-100">
      <div class="mdl-grid demo-content center-items">
        <div id="conversations" class="mdl-cell--3-col">
        <main class="mdl-layout__content mdl-color--grey-100">
            <div class="mdl-grid demo-content">
                <div class="mdl-cell--12-col" style="overflow-x:auto;">
                  <h2 class="mdl-card__title-text">Listado de conversaciones</h2>
                  	<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--4dp">
                    <thead>
                      <tr>
                        <th class="mdl-data-table__cell--non-numeric">Id</th>
                        <th class="mdl-data-table__cell--non-numeric">Usuario</th>
                        <th class="mdl-data-table__cell--non-numeric">Administrador</th>
                        <th></th>
                        <th></th>
                      </tr>
                   	</thead>
                    <tbody>
                      <%
            	         ArrayList<Conversacion> conversations = (ArrayList<Conversacion>) request.getAttribute("conversations");
            	          for(Conversacion conver : conversations) { %>

			            <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
			                for="demo-menu-lower-right">
			              <li class="mdl-menu__item">Eliminar chat</li>
			              <li class="mdl-menu__item">Marcar como leído</li>
			              <li disabled class="mdl-menu__item">marcar como no leído</li>
			            </ul>
			          </div>

                        <tr>
                          <td class="mdl-data-table__cell--non-numeric"><%=conver.getId()%></td>
                          <td class="mdl-data-table__cell--non-numeric"><%=conver.getEntidadUsuario().getNombre()%></td>
                          <td class="mdl-data-table__cell--non-numeric"><%=conver.getEntidadAdministrador().getNombre()%></td>
                          <td>
                            <a href="messages.jsp"><button class="mdl-button mdl-js-button mdl-button--icon">
                              <i class="material-icons">remove_red_eye</i>
                            </button></a>
                          </td>
                          <td>
                            <button class="mdl-button mdl-js-button mdl-button--icon">
                              <i class="material-icons">clear</i>
                            </button>
                          </td>
                        </tr>
                      <%} %>
                    </tbody>
                  </table>
        </div>
        <%if (request.getAttribute("messages") != null) {%>
        <div id="chat-content" class="mdl-cell--9-col">
          <jsp:include page="chat.jsp">
                  <jsp:param name="messages" value="<%=request.getAttribute("messages")%>"/>
              </jsp:include>
        </div>
        <%}%>
      </div>
    </main>
  </div>
>>>>>>> feature/ChatManagement
</body>

</html>
