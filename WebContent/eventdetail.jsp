<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="ISO-8859-1">
    <title>Event Info</title>
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
                <form action="#" class="mdl-cell--8-col mdl-cell--2-offset">
                    <hgroup class="mdl-card__title">
                        <h2 class="mdl-card__title-text">Estos son los datos del&nbsp;<b>EVENTO</b></h2>
                    </hgroup>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="username" value="Nombre" readonly/>
                        <label class="mdl-textfield__label" for="username">Nombre del evento</label>
                        <span class="mdl-textfield__error">Only alphabet and no spaces, please!</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="username" value="Categoría" readonly/>
                        <label class="mdl-textfield__label" for="username">Categoría</label>
                        <span class="mdl-textfield__error">Only alphabet and no spaces, please!</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="username" value="Precio" readonly/>
                        <label class="mdl-textfield__label" for="username">Precio</label>
                        <span class="mdl-textfield__error">Only alphabet and no spaces, please!</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="username" value="Fecha y hora" readonly/>
                        <label class="mdl-textfield__label" for="username">Fecha y hora</label>
                        <span class="mdl-textfield__error">Only alphabet and no spaces, please!</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="username" value="Localización" readonly/>
                        <label class="mdl-textfield__label" for="username">Localización y sala</label>
                        <span class="mdl-textfield__error">Only alphabet and no spaces, please!</span>
                    </div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="username" value="Entradas restantes" readonly/>
                        <label class="mdl-textfield__label" for="username">Entradas restantes</label>
                        <span class="mdl-textfield__error">Only alphabet and no spaces, please!</span>
                    </div>
                </form>
                <div class="mdl-cell--8-col mdl-cell--2-offset">
                    <button id="edit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">Modificar
                    </button>
                    <button id="save" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" disabled>Guardar
                    </button>
                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored">Eliminar evento
                    </button>
                </div>
            </div>
        </main>
    </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
    $("#edit").on("click", function() {
        $("input").prop("readonly", false);
        $("#save").prop("disabled", false);
        $(this).prop("disabled", true);
        $(this).removeClass("mdl-button--accent");
        $("#save").addClass("mdl-button--accent");
    });
    $("#save").on("click", function() {
        $("input").prop("readonly", true);
        $("#edit").prop("disabled", false);
        $(this).prop("disabled", true);
        $(this).removeClass("mdl-button--accent");
        $("#edit").addClass("mdl-button--accent");
    });
</script>

</html>
