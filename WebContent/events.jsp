<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="ISO-8859-1">
  <title>Events</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
  <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</head>

<body>
  <main class="mdl-grid center-items">
    <div class="mdl-cell--8-col mdl-cell--2-offset">
      <h2 class="mdl-card__title-text">Listado de eventos</h2>
      <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--4dp">
        <thead>
          <tr>
            <th class="mdl-data-table__cell--non-numeric">Nombre</th>
            <th class="mdl-data-table__cell--non-numeric">Categoría</th>
            <th class="mdl-data-table__cell--non-numeric">Precio (€)</th>
            <th class="mdl-data-table__cell--non-numeric">Fecha y Hora</th>
            <th class="mdl-data-table__cell--non-numeric">Localización - Sala</th>
            <th class="mdl-data-table__cell--non-numeric">Entradas restantes</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <%
	         ArrayList<EventBean> events = (ArrayList<EventBean>) request.getAttribute("events");
	          for(EventBean event : events) { %>

            <tr>
              <td class="mdl-data-table__cell--non-numeric"><%=event.getTitle()%></td>
              <td class="mdl-data-table__cell--non-numeric"><%=event.getCategory()%></td>
              <td><%=event.getPrice()%></td>
              <td><%=event.getDate()%></td>
              <td class="mdl-data-table__cell--non-numeric"><%=event.getLocation()%>-<%=event.getHall()%></td>
              <td><%=event.getTickets()%></td>
              <td>
                <a href="eventdatail?id=<%=event.getId()%>"><button class="mdl-button mdl-js-button mdl-button--icon">
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

      <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">Eliminar todos
      </button>

    </div>

  </main>
</body>

</html>
