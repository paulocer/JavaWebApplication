package javawebapplication.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javawebapplication.bean.AdressBean;
import javawebapplication.model.AdressModel;
import javawebapplication.utility.DataUtility;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class AdressCTL
 */
@WebServlet(name = "AdressCTL", urlPatterns = {"/AdressCTL"})
public class AdressCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdressCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Edit		
		  AdressModel model = new AdressModel();
		  long id = DataUtility.getLong(request.getParameter("id"));
		  if(id>0) {
		    AdressBean bean = null;
		    bean = AdressModel.FindByPk(id);
		    request.setAttribute("bean", bean);
		  }
		  
		ServletUtility.forward(JWAView.AdressView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    AdressBean adress = new AdressBean();
	    adress.setLogin(request.getParameter("login"));
	    adress.setCep(request.getParameter("cep"));
	    adress.setLogradouro(request.getParameter("logradouro"));
	    adress.setNumero(request.getParameter("numero"));
	    adress.setComplemento(request.getParameter("complemento"));
	    adress.setBairro(request.getParameter("bairro"));
	    adress.setCidade(request.getParameter("cidade"));
	    adress.setUf(request.getParameter("uf"));
	    
	    adress.setId(DataUtility.getLong(request.getParameter("id")));
	    if(adress.getId()>0) {
	         //To Update the records
	         long i = AdressModel.UpdateAdress(adress);
	            if(i>0) {
	              ServletUtility.setSuccessMessage("Endereço alterado com sucesso.", request);
	              
	            }else {
	              ServletUtility.setErrorMessage("Alteração não efetuada.", request);
	            }
	    } else {
		    long i = AdressModel.addAdress(adress);
		    if(i>0) {
		      ServletUtility.setSuccessMessage("Endereço cadastrado com sucesso.", request);
		      
		    } else {
		      ServletUtility.setErrorMessage("Endereço não inserido.", request);
		    	}
	    	}
	    request.getRequestDispatcher(JWAView.AdressView).forward(request, response);
		}
	}
