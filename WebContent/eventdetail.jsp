<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,es.uc3m.g3.bean.EventBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="ISO-8859-1">
  <title>Event Detail</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
      <link rel="stylesheet" href="styles.css">
  <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</head>

<body>
    <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
        <jsp:include page="header.jsp">
        	<jsp:param name="title" value="Event Detail"/>
    	</jsp:include>
        <main class="mdl-layout__content mdl-color--grey-100">
            <div class="mdl-grid demo-content">
                <form action="eventdetail" method="post" class="mdl-cell--8-col mdl-cell--2-offset" id="event-form">
                <%EventBean event = (EventBean) request.getAttribute("event"); %>
                    <hgroup class="mdl-card__title">
                        <h2 class="mdl-card__title-text">Estos son los datos del&nbsp;<b><%=event.getTitle()%></b></h2>
                    </hgroup>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="([A-Z,a-z]*\d*)*" name="id" value="<%=event.getId()%>" readonly/>
                        <label class="mdl-textfield__label" for="id">id del evento</label>
                        <span class="mdl-textfield__error">Introduzca un nombre sin espacios ni sÃ­mbolos.</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="([A-Z,a-z]*\d*)*" name="eventName" value="<%=event.getTitle()%>" readonly/>
                        <label class="mdl-textfield__label" for="eventName">Nombre del evento</label>
                        <span class="mdl-textfield__error">Introduzca un nombre sin espacios ni sÃ­mbolos.</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="([A-Z,a-z]+\s?)*" name="category" value="<%=event.getCategory()%>" readonly/>
                        <label class="mdl-textfield__label" for="category">CategorÃ­a</label>
                        <span class="mdl-textfield__error">Introduzca una palabra o frase, sin sÃ­mbolos ni dÃ­gitos.</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="^[0-9]{2}([.][0-9]{2})?" name="price" value="<%=event.getPrice()%>" readonly/>
                        <label class="mdl-textfield__label" for="price">Precio</label>
                        <span class="mdl-textfield__error">Introduzca el precio del evento con punto como separaciï¿½n decimal.</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="\d{2}/\d{2}/\d{4}" name="date" value="<%=event.getDate()%>" readonly/>
                        <label class="mdl-textfield__label" for="date">Fecha y hora</label>
                        <span class="mdl-textfield__error">Introduzca la fecha en el sigueinte formato: dd/mm/yy</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" name="location" value="<%=event.getLocation()%>" readonly/>
                        <label class="mdl-textfield__label" for="location">LocalizaciÃ³n</label>
                        <span class="mdl-textfield__error">Only alphabet and no spaces, please!</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" name="hall" value="<%=event.getHall()%>" readonly/>
                        <label class="mdl-textfield__label" for="halle">Sala</label>
                        <span class="mdl-textfield__error">Only alphabet and no spaces, please!</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="\d*" name="tickets" value="<%=event.getTickets()%>" readonly/>
                        <label class="mdl-textfield__label" for="tickets">Entradas restantes</label>
                        <span class="mdl-textfield__error">Introduzca un nÃºmero sin decimales ni espacios.</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input type="file" name="img" class="mdl-textfield__input" accept="image/*" disabled/>
                        <span class="mdl-textfield__error">Elija un archivo.</span>
                    </div>
                    <button id="edit-event" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">Modificar
                    </button>
                    <button id="save-event" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" formaction="eventdetail" formmethod="post">Guardar</button>
                    <button id="delete-event" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored" type="submit" formaction="eventdetail" formmethod="delete">Eliminar evento</button>
                    <div id="delete-event-snackbar" class="mdl-js-snackbar mdl-snackbar">
                      <div class="mdl-snackbar__text"></div>
                      <button class="mdl-snackbar__action" type="button"></button>
                    </div>
                </form>
            </div>
        </main>
    </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
    $("#edit-event").on("click", function() {
        $("input").prop("readonly", false);
        $("#save-event").prop("disabled", false);
        $(this).prop("disabled", true);
        $(this).removeClass("mdl-button--accent");
        $("#save-event").addClass("mdl-button--accent");
    });
    $("#save-event").on("click", function() {
        $("input").prop("readonly", true);
        $("#edit-event").prop("disabled", false);
        $(this).prop("disabled", true);
        $(this).removeClass("mdl-button--accent");
        $("#edit-event").addClass("mdl-button--accent");
    });
    // $('#event-form').submit(function(e){
    //     e.preventDefault();
    //     $.ajax({
    //         url:'eventdetail?id=id001',
    //         type:'delete',
    //         // data:$('#event-form').serialize(),
    //         success:function(){
    //             //whatever you wanna do after the form is successfully submitted
    //         }
    //     });
    // });
    (function() {
      'use strict';
      var snackbarContainer = document.querySelector('#delete-event-snackbar');
      var showSnackbarButton = document.querySelector('#delete-event');
      var handler = function(event) {
        showSnackbarButton.style.backgroundColor = '';

      };
      showSnackbarButton.addEventListener('click', function() {
        'use strict';
        var data = {
          message: '¿Está seguro de eliminar el evento?',
          timeout: 3000,
          actionHandler: handler,
          actionText: 'Aceptar'
        };
        snackbarContainer.MaterialSnackbar.showSnackbar(data);
      });
    }());
</script>

</html>
