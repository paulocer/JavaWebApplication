package javawebapplication.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javawebapplication.bean.UserBean;
import javawebapplication.model.UserModel;
import javawebapplication.utility.DataUtility;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class UserCTL
 */
@WebServlet(name = "UserCTL", urlPatterns = {"/UserCTL"})
public class UserCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Edit		
		  UserModel model = new UserModel();
		  long id = DataUtility.getLong(request.getParameter("id"));
		  if(id>0) {
		    UserBean bean = null;
		    bean = UserModel.FindByPk(id);
		    request.setAttribute("bean", bean);
		  }
		  
		ServletUtility.forward(JWAView.UserView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    UserBean user = new UserBean();
	    user.setLogin(request.getParameter("login"));
	    user.setNome(request.getParameter("nome"));
	    user.setEmail(request.getParameter("email"));
	    user.setPerfil(request.getParameter("perfil"));
	    user.setSenha(request.getParameter("senha"));
	    
	    user.setId(DataUtility.getLong(request.getParameter("id")));
	    if(user.getId()>0) {
	         //To Update the records
	         long i = UserModel.UpdateUser(user);
	            if(i>0) {
	              ServletUtility.setSuccessMessage("Usuário alterado com sucesso.", request);
	              
	            }else {
	              ServletUtility.setErrorMessage("Alteração não efetuada.", request);
	            }
	    } else {
		    long i = UserModel.addUser(user);
		    if(i>0) {
		      ServletUtility.setSuccessMessage("Usuário cadastrado com sucesso.", request);
		      
		    } else {
		      ServletUtility.setErrorMessage("Usuário não inserido.", request);
		    	}
	    	}
	    request.getRequestDispatcher(JWAView.UserView).forward(request, response);
		}
	}
