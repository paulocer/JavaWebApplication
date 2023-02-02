<%@page import="javawebapplication.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="javawebapplication.utility.ServletUtility"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>

<h2 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h2>
<h2 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h2>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Login</th>
      <th scope="col">Nome</th>
      <th scope="col">E-mail</th>
      <th scope="col">Perfil</th>
      <th scope="col">Senha</th>
      <th scope="col">Action</th>
    </tr>
  </thead>

  <%
          int index=1;
          List list=ServletUtility.getList(request);
          Iterator it=list.iterator();
          while(it.hasNext()){
          UserBean user=(UserBean)it.next();
  %>

  <tbody>
    <tr>
      <th scope="row"><%=user.getId()%></th>
      <td><%=user.getLogin()%></td>
      <td><%=user.getNome() %></td>
      <td><%=user.getEmail()%></td>
      <td><%=user.getPerfil()%></td>
      <td><%=user.getSenha()%></td>
      <td><a class="btn btn-info" href="UserCTL?id=<%=user.getId()%>">Alterar</a>&nbsp;
      <a class="btn btn-danger" href="UserListCTL?id=<%=user.getId()%>">Excluir</a></td>
    </tr>
  </tbody>
  <% }%>
</table>
<%@ include file="footer.jsp"%>