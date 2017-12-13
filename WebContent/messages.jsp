<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,es.uc3m.g3.models.Conversation" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META http-equiv="Content-Style-Type" content="text/css">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>SendMenssageToQueue.html</TITLE>
</HEAD>
<BODY bgcolor="#99ffff">
<% 
	//Conversacion conver = (Conversacion) request.getAttribute("conversation");
	//conver.setId(11);
	String sender = "840123e34b30f2d8b0579fe2dacdbc99fccc0357";
	int conversationId = 11;
%>
<BR>
<A href="ReadMessageQueueBrowser.html">Ver mis mensajes</A><BR>
<BR>
<FORM NAME="miForm", method="POST" action="SendMessageQueue?sender=<%=sender%>&conversationId=<%=conversationId%>">
<label color="#0000ff" face="Times New Roman"> Mandar mensaje </label>:
<TEXTAREA rows="2" cols="64" name="message"></TEXTAREA>
<INPUT type="submit" name="enviar" value="Send message to queue"></FORM>
</BODY>
</HTML>
