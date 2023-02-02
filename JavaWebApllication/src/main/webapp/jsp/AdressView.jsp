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
</head>
<body>
<%@ include file="header.jsp"%>
  <main class="login-form">
  <div class="cotainer">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">
            Cadastro de Endereço
            
          </div>

          <div class="card-body">
          
            <h3 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h3>
            <h3 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h3>
            <jsp:useBean id="bean" class="javawebapplication.bean.AdressBean" scope="request"></jsp:useBean>
          
            <form action="<%=JWAView.AdressCTL%>" method="post">
            
            <input type="hidden" name="id" value="<%=DataUtility.getStringData(bean.getId())%>">

              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Login<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="login" class="form-control" placeholder="Digite seu login"
                    name="login" value="<%=session.getAttribute("user")%>" readonly>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">CEP<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="cep" class="form-control" placeholder="CEP"
                    name="cep" <%if(bean.getCep()==null) {%> value="" <% } else {%> value="<%=bean.getCep()%>" <%} %>>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Logradouro<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="nome" class="form-control" placeholder="Logradouro"
                    name="logradouro" <%if(bean.getLogradouro()==null) {%> value="" <% } else {%> value="<%=bean.getLogradouro()%>" <%} %>>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Número<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="numero" class="form-control" placeholder="Número"
                    name="numero" <%if(bean.getNumero()==null) {%> value="" <% } else {%> value="<%=bean.getNumero()%>" <%} %>>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Complemento<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="complemento" class="form-control" placeholder="Complemento"
                    name="complemento" <%if(bean.getComplemento()==null) {%> value="" <% } else {%> value="<%=bean.getComplemento()%>" <%} %>>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Bairro<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="bairro" class="form-control" placeholder="Bairro"
                    name="bairro" <%if(bean.getBairro()==null) {%> value="" <% } else {%> value="<%=bean.getBairro()%>" <%} %>>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Cidade<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="cidade" class="form-control" placeholder="Cidade"
                    name="cidade" <%if(bean.getCidade()==null) {%> value="" <% } else {%> value="<%=bean.getCidade()%>" <%} %>>
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">UF<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="uf" class="form-control" placeholder="UF"
                    name="uf" <%if(bean.getUf()==null) {%> value="" <% } else {%> value="<%=bean.getUf()%>" <%} %>>
                    <font  color="red"></font>
                </div>
              </div>
              
              <%if(bean.getId()>0){ %>
              <div class="col-md-6 offset-md-4">
                <input type="submit" class="btn btn-primary" name="operation" value="Alterar">
              </div>
              <%} else {%>
              <div class="col-md-6 offset-md-4">
                <input type="submit" class="btn btn-primary" name="operation" value="Inserir">
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