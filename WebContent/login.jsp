<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
	<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</head>
<body>
	<main class="mdl-grid center-items" style="justify-content:center;">
		<form class="mdl-cell--4-col mdl-shadow--4dp" style="margin-top:15%; width:30%; min-width:260px;" method="post" action="login">
			<hgroup class="mdl-card__title">
				<h2 class="mdl-card__title-text">Login</h2>
			</hgroup>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="email" id="email" name="email">
				<label class="mdl-textfield__label" for="email">Email</label>
				<span class="mdl-textfield__error">Enter valid email please</span>
			</div>
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="password" id="password" pattern="[A-Z,a-z, ]*" name="password">
				<label class="mdl-textfield__label" for="password">Password</label>
				<span class="mdl-textfield__error">Enter valid email please</span>
			</div>
			<div style="width:100%;">
				<div class="mdl-layout-spacer"></div>
				<button type="submit" value="login" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">
				  Button
				</button>
			</div>		  
		</form>
		<% if (request.getAttribute("nologin")!=null){%>
			<%=(String) request.getAttribute("nologin") %>
		<%} %>
	</main>
</body>
</html>