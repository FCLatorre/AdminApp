<%@ page import="java.util.*,es.uc3m.g3.entities.*" %>
<%ArrayList<Mensaje> messages = (ArrayList<Mensaje>) request.getAttribute("messages");%>
<%EntidadUsuario user = (EntidadUsuario) request.getSession().getAttribute("user");%>
<%String email = user.getNombre();%>

<div class="wrapper">
  <div class="inner" id="inner">
    <div class="content" id="content">
      <%for(Mensaje m : messages){%>
      <div class="message-wrapper <%if(email.equals(m.getEntidadRol().getId())) {%>me<%}else{%>them<%}%>">
        <img src="images/user.jpg" class="demo-avatar circle-wrapper" />
        <div class="text-wrapper">
          <%=m.getContenido()%>
        </div>
      </div>
      <%}%>
    </div>
  </div>
  <form class="bottom" id="bottom" action="conversations?id=<%=request.getAttribute("id")%>" method="post">
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label send">
      <textarea class="mdl-textfield__input" type="text" name="message"></textarea>
      <label class="mdl-textfield__label send" for="message">Mensaje</label>
      <button class="mdl-button mdl-js-button mdl-button--fab mdl-button--colored" type="submit" style="right: -70px;">
          <i class="material-icons">send</i>
      </button>
    </div>

  </div>
</div>
