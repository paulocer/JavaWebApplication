
<%@page import="javax.swing.JViewport"%>
<%@page import="javawebapplication.utility.ServletUtility"%>
<body>
  <%@ include file="header.jsp"%>
  <main class="login-form">
  <div class="cotainer">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">
            Login 

            <h6 style="color: green;"></h6>
            <h2 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h2>
            <h2 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h2>
          </div>
          <div class="card-body">
          
            <form action="<%=JWAView.LoginCTL%>" method="post">
            
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Login<font color="red">*</font></label>
                <div class="col-md-6">
                  <input type="text" id="login"  class="form-control" placeholder="Digite o seu login"
                    name="login" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="password"
                  class="col-md-4 col-form-label text-md-right">Senha<font color="red">*</font></label>
                <div class="col-md-6">
                  <input type="password" id="password" class="form-control" placeholder="Digite a sua senha"
                    name="password" value="" >
                    <font color="red"> </font>
                </div>
              </div>
              
              <div class="col-md-6 offset-md-4">
                <input type="submit" class="btn btn-primary" name="operation" value="Login">
                <a href="" class="btn btn-link"> Esqueceu sua senha? </a>
              </div>
              
            </form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
  </main>
  <div style="margin-top: 170px">
    <%@ include file="footer.jsp"%>
  </div>