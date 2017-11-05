<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,es.uc3m.g3.bean.MessageBean" %>
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

          <%
          ArrayList<String> conversations = (ArrayList<String>) request.getAttribute("conversations");

          for(String conv : conversations) {%>

          <a href="conversations?id=<%=conv%>" class="no-style">
          <div class="conversation <%if (conv.equals(request.getAttribute("id"))) {%>active<%}%>">
            <img src="images/user.jpg" class="demo-avatar" />
            <span class="mdl-badge" data-badge="4"><%=conv%></span>
          </div>
          </a>

          <%} %>
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
</body>

</html>
