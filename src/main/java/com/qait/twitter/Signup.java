package com.qait.twitter;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("signup")
public class Signup {

	@POST
	@Produces(MediaType.TEXT_HTML)
	public Response signup(@FormParam("fname") String fname, @FormParam("lname") String lname,
			@FormParam("email") String email, @FormParam("password") String password) throws URISyntaxException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter", "root", "root");

			PreparedStatement ps = con.prepareStatement("insert into information values(?,?,?,?)");

			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, password);
			ps.setString(4, email);

			ps.executeUpdate();

			System.out.println("Registered");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		String output = "<html><body>" + "<h1>Signup Successful</h1><br><br>"
				+ " <a href='http://localhost:8080/twitter/login.html'>Click here</a> to login." + "</body></html>";

		URI location = new URI("http://localhost:8080/twitter/signup.html");
		return Response.status(200).entity(output).build();
	}

}


/* 
  package com.qait.twitter;
 
 

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("signup")
public class Signup {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response signup(@FormParam("fname") String fname,@FormParam("lname") String lname,@FormParam("email") String email, @FormParam("password") String password) throws URISyntaxException{
		try{  
    		Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/twitter","root","root");  
    		  
    		PreparedStatement ps=con.prepareStatement("insert into information values(?,?,?,?,?)");  
    		
    		ps.setString(1,fname);  
    		ps.setString(2,lname);  
    		ps.setString(3,password);  
    		ps.setString(4,email);
    		ps.setString(5, "");
    		
    		ps.executeUpdate();
    		
    		System.out.println("Registered");
    		con.close();  
    		}catch(Exception e){ System.out.println(e);}  
    		  
    	URI location = new URI("http://localhost:8080/twitter/index.html");
    	return Response.seeOther(location).build(); 
    	}
	
	
	
	

}
*/