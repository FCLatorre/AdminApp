<html>

<body>
    <div class='cntt-wrapper'>
      <div id="fab-hdr">
        <h3><%= request.getParameter("title")%></h3>
      </div>

      <div class="cntt">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
          <h5><%= request.getParameter("text")%></h5>
          <p>
            <%= request.getParameter("description")%>
          </p>
        </div>
      </div>

      <div class="btn-wrapper">
        <button class="mdl-button mdl-js-button" id="cancel">Cancelar</button>
        <button class="mdl-button mdl-js-button mdl-button--primary" id="confirm">Confirmar</button>
      </div>

    </div>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
  //Variables
  var fab = $(".fab"),
    cancel = $("#cancel"),
    confirm= $("#confirm"),
    isConfirm = false;

  //fab click
  function popup(callback){
    confirm.on('click', function(){
      isConfirm = true;
      closeFAB();
      callback(isConfirm);
    });
    cancel.on('click', function(){
      isConfirm = false;
      closeFAB();
      callback(isConfirm);
    });
  }

  function closeFAB(event) {
    fab.removeClass('fab active');
  }

</script>

</html>
