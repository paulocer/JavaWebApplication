<%@page import="javawebapplication.bean.AdressBean"%>
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
      <th scope="col">Logradouro</th>
      <th scope="col">Numero</th>
      <th scope="col">Complemento</th>
      <th scope="col">Bairro</th>
      <th scope="col">Cep</th>
      <th scope="col">Cidade</th>
      <th scope="col">UF</th>
    </tr>
  </thead>

  <%
          int index=1;
          List list=ServletUtility.getList(request);
          Iterator it=list.iterator();
          while(it.hasNext()){
          AdressBean adress=(AdressBean)it.next();
  %>

  <tbody>
    <tr>
      <th scope="row"><%=adress.getId()%></th>
      <td><%=adress.getLogin()%></td>
      <td><%=adress.getLogradouro() %></td>
      <td><%=adress.getNumero()%></td>
      <td><%=adress.getComplemento()%></td>
      <td><%=adress.getBairro()%></td>
      <td><%=adress.getCep()%></td>
      <td><%=adress.getCidade()%></td>
      <td><%=adress.getUf()%></td>
      <td><a class="btn btn-info" href="AdressCTL?id=<%=adress.getId()%>">Alterar</a>&nbsp;
      <a class="btn btn-danger" href="AdressListCTL?id=<%=adress.getId()%>">Excluir</a></td>
    </tr>
  </tbody>
  <% }%>
</table>
<%@ include file="footer.jsp"%>