<%@ include file="header.jsp"%>
<body>

	<!-- header end here -->
	
	<!-- content starts here -->
	<div class="home-content-wrapper">
		<div class="overlay-box">
			<div class="container">
				<div class="welcome-text">Bem-vindo<%if(userSession!=null) {%><%=" "+session.getAttribute("user") %><%} %>! <br/>Resid�ncia UFBA - Exerc�cio 01</div>
			</div>
		</div>
	</div>
	<!-- content ends here -->
	
</body>
<%@ include file="footer.jsp"%>
</html>