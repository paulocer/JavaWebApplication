package javawebapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javawebapplication.bean.AdressBean;
import javawebapplication.bean.UserBean;
import javawebapplication.utility.JDBCDataSource;

public class AdressModel {
	
	  public static long nextPk() {
		    long pk = 0;
		    Connection conn;
		    try {
		      conn = JDBCDataSource.getConnection();
		      PreparedStatement stmt = conn.prepareStatement("select Max(id) from adress");
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()){
		        pk = rs.getLong(1);
		      }
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    return pk+1;
		  }
		  
		  public static long addAdress(AdressBean adress) {
		    int i = 0;
		    try {
		      Connection conn = JDBCDataSource.getConnection();
		      PreparedStatement stmt = conn.prepareStatement("insert into adress values(?,?,?,?,?,?,?,?,?)");
		      stmt.setLong(1, nextPk());
		      stmt.setString(2 , adress.getLogin() );
		      stmt.setString(3 , adress.getCep() );
		      stmt.setString(4 , adress.getLogradouro() );
		      stmt.setString(5 , adress.getNumero() );
		      stmt.setString(6 , adress.getComplemento() );
		      stmt.setString(7 , adress.getBairro() );
		      stmt.setString(8 , adress.getCidade() );
		      stmt.setString(9 , adress.getUf() );
		      i =     stmt.executeUpdate();
		      
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    
		    return i;
		  }

		  //To get the data from database
		  public static List list() {
			  ArrayList list=new ArrayList();
			  Connection conn=null;
			  try {
			    conn=JDBCDataSource.getConnection();
			    PreparedStatement pstmt=conn.prepareStatement("Select * from adress");
			    ResultSet rs= pstmt.executeQuery();
			    while (rs.next()) {
			    AdressBean adress=new AdressBean();
		        adress.setId(rs.getLong("id"));
		        adress.setLogin(rs.getString("login"));
		        adress.setCep(rs.getString("cep"));
		        adress.setLogradouro(rs.getString("logradouro"));
		        adress.setNumero(rs.getString("numero"));
		        adress.setComplemento(rs.getString("complemento"));    
		        adress.setBairro(rs.getString("bairro"));
		        adress.setCidade(rs.getString("cidade"));
		        adress.setUf(rs.getString("uf"));    
			    list.add(adress);
			    }
			  } catch (Exception e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			  }finally {
			    JDBCDataSource.closeConnection(conn);
			  }
			  return list;
			}

		  // Edit Records
		  public static AdressBean FindByPk(long id) {
		    Connection con;
		    AdressBean adress = null;
		    try {
		      con = JDBCDataSource.getConnection();
		      PreparedStatement stmt = con.prepareStatement("Select * from adress where id=?");
		      stmt.setLong(1, id);
		      ResultSet rs = stmt.executeQuery();
		      if (rs.next()) {
			    adress = new AdressBean();
		        adress.setId(rs.getLong("id"));
		        adress.setLogin(rs.getString("login"));
		        adress.setCep(rs.getString("cep"));
		        adress.setLogradouro(rs.getString("logradouro"));
		        adress.setNumero(rs.getString("numero"));
		        adress.setComplemento(rs.getString("complemento"));    
		        adress.setBairro(rs.getString("bairro"));
		        adress.setCidade(rs.getString("cidade"));
		        adress.setUf(rs.getString("uf"));    
		      }
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    return adress;
		  }

		  public static long UpdateAdress(AdressBean adress) {
		      int i = 0;
		      try {
		        Connection conn = JDBCDataSource.getConnection();
		        PreparedStatement stmt = conn.prepareStatement("update adress set login=?, cep=?, logradouro=?, numero=?, complemento=?, bairro=?, cidade=?, uf=? where id=?");
		        
		        stmt.setString(1 , adress.getLogin() );
		        stmt.setString(2 , adress.getCep() );
		        stmt.setString(3 , adress.getLogradouro() );
		        stmt.setString(4 , adress.getNumero() );
		        stmt.setString(5 , adress.getComplemento() );
		        stmt.setString(6 , adress.getBairro() );
		        stmt.setString(7 , adress.getCidade() );
		        stmt.setString(8 , adress.getUf() );
		        stmt.setLong(9, adress.getId());
		          i =   stmt.executeUpdate();
		        
		      } catch (Exception e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      }
		      return i;
		    }
		  
		  public static long delete(long id) {
			  int i = 0;
			  try {
			    Connection conn = JDBCDataSource.getConnection();
			    PreparedStatement stmt = conn.prepareStatement("DELETE from adress where id=?");
			    stmt.setLong(1, id);
			    i = stmt.executeUpdate();
			  } catch (Exception e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			  }
			  return i;
		  }
}
