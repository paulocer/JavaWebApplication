<%@page import="javawebapplication.utility.DataUtility"%>
<%@page import="javawebapplication.utility.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuário</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
 $( function() {
      $( "#datepicker" ).datepicker({
          dateFormat : 'dd/mm/yy',
          changeMonth: true,
        changeYear: true
      });
    } );
  </script>
</head>
<body>
<%@ include file="header.jsp"%>
  <main class="login-form">
  <div class="cotainer">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">
            Cadastro de Usuário
            
          </div>

          <div class="card-body">
          
            <h3 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h3>
            <h3 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h3>
            <jsp:useBean id="bean" class="javawebapplication.bean.UserBean" scope="request"></jsp:useBean>
          
            <form action="<%=JWAView.UserCTL%>" method="post">
            
            <input type="hidden" name="id" value="<%=DataUtility.getStringData(bean.getId())%>">

              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Login<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="login" class="form-control" placeholder="Digite seu login"
                    name="login" <%if(userSession==null) {%> value="" <% } else {%> value="<%=bean.getLogin()%>" <%} %>>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Nome<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="nome" class="form-control" placeholder="Digite seu nome completo"
                    name="nome" <%if(userSession==null) {%> value="" <% } else {%> value="<%=bean.getNome()%>" <%} %>>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">E-mail<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="email" class="form-control" placeholder="Digite seu e-mail"
                    name="email" <%if(userSession==null) {%> value="" <% } else {%> value="<%=bean.getEmail()%>" <%} %>>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Perfil<font color="red"></font></label>
                <div class="col-md-6">
                  <select type="text" id="perfil"  class="form-control" placeholder="Escolha seu perfil"
                    name="perfil" value="<%=bean.getPerfil()%>" required>
                    <option value="" selected disabled hidden>Escolha o perfil do usuário</option>
                    <option value="Administrador">Administrador
                    <option value="Comum">Comum
                    </option>
                    </select>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Senha<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="password" id="senha"  class="form-control" placeholder="Digite sua senha"
                    name="senha" <%if(userSession==null) {%> value="" <% } else {%> value="<%=bean.getSenha()%>" <%} %>>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Confirmação de Senha<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="password" id="confsenha"  class="form-control" placeholder="Repita sua senha"
                    name="confsenha" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <%if(bean.getId()>0){ %>
              <div class="col-md-6 offset-md-4">
                <input type="submit" class="btn btn-primary" name="operation" value="Alterar">
              </div>
              <%} else {%>
              <div class="col-md-6 offset-md-4">
                <input type="submit" class="btn btn-primary" name="operation" value="Cadastrar">
              </div>
              <%} %>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  </main>
  <div style="margin-top: 120px">
    <%@ include file="footer.jsp"%>
  </div>
</body>
</html>