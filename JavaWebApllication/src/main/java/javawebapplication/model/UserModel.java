package javawebapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javawebapplication.bean.UserBean;
import javawebapplication.utility.JDBCDataSource;

public class UserModel {
	
	  public static long nextPk() {
		    long pk = 0;
		    Connection conn;
		    try {
		      conn = JDBCDataSource.getConnection();
		      PreparedStatement stmt = conn.prepareStatement("select Max(id) from user");
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
		  
		  public static long addUser(UserBean user) {
		    int i = 0;
		    try {
		      Connection conn = JDBCDataSource.getConnection();
		      PreparedStatement stmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?)");
		      stmt.setLong(1, nextPk());
		      stmt.setString(2 , user.getLogin() );
		      stmt.setString(3 , user.getNome() );
		      stmt.setString(4 , user.getEmail() );
		      stmt.setString(5 , user.getPerfil() );
		      stmt.setString(6 , user.getSenha() );
		      i =     stmt.executeUpdate();
		      
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    return i;
		  }

		  public static UserBean UserLogin(String login,String password) {
			    Connection con;
			    UserBean user = null;
			    try {
			      con = JDBCDataSource.getConnection();
			      PreparedStatement stmt = con.prepareStatement("Select * from user where login = ? and senha = ?");
			      stmt.setString(1,login);
			      stmt.setString(2,password);
			      ResultSet rs = stmt.executeQuery();
			      if(rs.next()) {
			        user = new UserBean();
			        user.setId(rs.getLong("id"));
			        user.setLogin(rs.getString("login"));
			        user.setNome(rs.getString("nome"));
			        user.setEmail(rs.getString("email"));
			        user.setPerfil(rs.getString("perfil"));
			        user.setSenha(rs.getString("senha"));    
			      }
			    } catch (Exception e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }
			    return user;
			  }

		  //To get the data from database
		  public static List list() {
			  ArrayList list=new ArrayList();
			  Connection conn=null;
			  try {
			    conn=JDBCDataSource.getConnection();
			    PreparedStatement pstmt=conn.prepareStatement("Select * from user");
			    ResultSet rs= pstmt.executeQuery();
			    while (rs.next()) {
			    UserBean user=new UserBean();
		        user.setId(rs.getLong("id"));
		        user.setLogin(rs.getString("login"));
		        user.setNome(rs.getString("nome"));
		        user.setEmail(rs.getString("email"));
		        user.setPerfil(rs.getString("perfil"));
		        user.setSenha(rs.getString("senha"));    
			    list.add(user);
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
		  public static UserBean FindByPk(long id) {
		    Connection con;
		    UserBean user = null;
		    try {
		      con = JDBCDataSource.getConnection();
		      PreparedStatement stmt = con.prepareStatement("Select * from user where id=?");
		      stmt.setLong(1, id);
		      ResultSet rs = stmt.executeQuery();
		      if (rs.next()) {
		        user = new UserBean();
		        user.setId(rs.getLong("id"));
		        user.setLogin(rs.getString("login"));
		        user.setNome(rs.getString("nome"));
		        user.setEmail(rs.getString("email"));
		        user.setPerfil(rs.getString("perfil"));
		        user.setSenha(rs.getString("senha"));    
		      }
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    return user;
		  }

		  public static long UpdateUser(UserBean user) {
		      int i = 0;
		      try {
		        Connection conn = JDBCDataSource.getConnection();
		        PreparedStatement stmt = conn.prepareStatement("update user set login=?, nome=?, email=?, perfil=?, senha=? where id=?");
		        
		        stmt.setString(1 , user.getLogin() );
		        stmt.setString(2 , user.getNome() );
		        stmt.setString(3 , user.getEmail() );
		        stmt.setString(4 , user.getPerfil() );
		        stmt.setString(5 , user.getSenha() );
		        stmt.setLong(6, user.getId());
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
			    PreparedStatement stmt = conn.prepareStatement("DELETE from user where id=?");
			    stmt.setLong(1, id);
			    i = stmt.executeUpdate();
			  } catch (Exception e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			  }
			  return i;
			}
	}
