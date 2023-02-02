package javawebapplication.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javawebapplication.model.AdressModel;
import javawebapplication.utility.DataUtility;
import javawebapplication.utility.ServletUtility;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class UserListCTL
 */
@WebServlet(name="AdressListCTL" ,urlPatterns= {"/AdressListCTL"})
public class AdressListCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdressListCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    AdressModel model=new AdressModel();

	    long id=DataUtility.getLong(request.getParameter("id"));
	    if(id>0) {
	      AdressModel.delete(id);
	      ServletUtility.setSuccessMessage("Endereço excluído com sucesso", request);
	    }
	    
	    List list=null;
	    list=model.list();
	    if(list==null && list.size()==0){
	      ServletUtility.setErrorMessage("Sem endereços cadastrados", request);
	    }
	    
	    ServletUtility.setList(list, request);
		ServletUtility.forward(JWAView.AdressViewList, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
