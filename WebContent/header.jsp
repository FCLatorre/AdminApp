<%@ page import="java.util.*,es.uc3m.g3.entities.EntidadRol" %>
<header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
    <div class="mdl-layout__header-row">
        <span class="mdl-layout-title"><%= request.getParameter("title")%></span>
        <div class="mdl-layout-spacer"></div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
            <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
      <i class="material-icons">search</i>
    </label>
            <div class="mdl-textfield__expandable-holder">
                <input class="mdl-textfield__input" type="text" id="search">
                <label class="mdl-textfield__label" for="search">Enter your query...</label>
            </div>
        </div>
        <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
    <i class="material-icons">more_vert</i>
  </button>
        <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
            <li class="mdl-menu__item">About</li>
            <li class="mdl-menu__item">Contact</li>
            <li class="mdl-menu__item">Legal information</li>
        </ul>
    </div>
</header>
<div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
    <header class="demo-drawer-header">
        <img src="images/user.jpg" class="demo-avatar">
        <div class="demo-avatar-dropdown">
        	<% EntidadRol user = (EntidadRol) request.getSession().getAttribute("user");%>
            <span> <%= user.getEmail()%> </span>
            <div class="mdl-layout-spacer"></div>
            <button id="accbtn" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">
	      		<i class="material-icons" role="presentation">arrow_drop_down</i>
	      		<span class="visuallyhidden">Accounts</span>
    		</button>
            <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="accbtn">
                <li class="mdl-menu__item"><a href="logout"><i class="material-icons">exit</i>Logout </a></li>
            </ul>
        </div>
    </header>
    <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
        <a class="mdl-navigation__link" href="events"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">card_membership</i>Eventos</a>
        <a class="mdl-navigation__link" href="users"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">date_range</i>Usuarios</a>
        <a class="mdl-navigation__link" href="conversations"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">inbox</i>Chat</a>
        <div class="mdl-layout-spacer"></div>
        <a class="mdl-navigation__link" href=""><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">help_outline</i><span class="visuallyhidden">Help</span></a>
    </nav>
</div>
