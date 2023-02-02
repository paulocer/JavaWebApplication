package javawebapplication.controller;

public interface JWAView {
	
	public String APP_CONTEXT = "/JavaWebApplication";
	public String PAGE_FOLDER = "/jsp";
	
	public String NavView = APP_CONTEXT + "/index.jsp";
	public String LoginView = PAGE_FOLDER + "/LoginView.jsp";
	public String UserView = PAGE_FOLDER + "/UserView.jsp";
	public String AdressView = PAGE_FOLDER + "/AdressView.jsp";
	public String UserViewList = PAGE_FOLDER + "/UserViewList.jsp";
	public String AdressViewList = PAGE_FOLDER + "/AdressViewList.jsp";
	public String HomeView = APP_CONTEXT + PAGE_FOLDER + "/home.jsp";
	public String WelcomeView = PAGE_FOLDER + "/WelcomeView.jsp";
	
	public String LoginCTL = APP_CONTEXT + "/LoginCTL";
	public String UserCTL = APP_CONTEXT + "/UserCTL";
	public String AdressCTL = APP_CONTEXT + "/AdressCTL";
	public String UserListCTL = APP_CONTEXT + "/UserListCTL";
	public String AdressListCTL = APP_CONTEXT + "/AdressListCTL";
	public String WelcomeCTL = APP_CONTEXT + "/WelcomeCTL";

}
