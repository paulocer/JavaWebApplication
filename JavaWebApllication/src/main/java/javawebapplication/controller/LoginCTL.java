package javawebapplication.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javawebapplication.bean.UserBean;
import javawebapplication.model.UserModel;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class LoginCTL
 */
@WebServlet(name = "LoginCTL", urlPatterns = {"/LoginCTL"})
public class LoginCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String op = request.getParameter("operation");
		if(op != null) {
			if (op.equals("logout")) {
			      session.invalidate();
			      ServletUtility.setSuccessMessage("Logout com sucesso!",request);
			}
		}
		ServletUtility.forward(JWAView.LoginView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       UserBean user = new UserBean();
	       String login=request.getParameter("login");
	       String pwd=request.getParameter("password");
	       HttpSession session = request.getSession(true);
	       user = UserModel.UserLogin(login,pwd);
	       if(user != null) {
	           //ServletUtility.setSuccessMessage(request.getParameter("login")+ " is login successfully", request);
	    	   
	    	   //Set attribute for session
	           session.setAttribute("user", user.getLogin());
	    	   ServletUtility.redirect(JWAView.WelcomeCTL, request, response);
	       }else {
	           ServletUtility.setErrorMessage("Credenciais inválidas", request);
	           ServletUtility.forward(JWAView.LoginView, request, response);
	       }
	}

}
