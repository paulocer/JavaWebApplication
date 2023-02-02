package javawebapplication.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javawebapplication.model.UserModel;
import javawebapplication.utility.DataUtility;
import javawebapplication.utility.ServletUtility;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class UserListCTL
 */
@WebServlet(name="UserListCTL" ,urlPatterns= {"/UserListCTL"})
public class UserListCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    UserModel model=new UserModel();

	    long id=DataUtility.getLong(request.getParameter("id"));
	    if(id>0) {
	      UserModel.delete(id);
	      ServletUtility.setSuccessMessage("Usuário excluído com sucesso", request);
	    }
	    
	    List list=null;
	    list=model.list();
	    if(list==null && list.size()==0){
	      ServletUtility.setErrorMessage("Sem usuários cadastrados", request);
	    }
	    
	    ServletUtility.setList(list, request);
		ServletUtility.forward(JWAView.UserViewList, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
