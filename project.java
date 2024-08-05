package Myproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class project extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 try{
			 PrintWriter print=res.getWriter();
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	PreparedStatement p=con.prepareStatement("insert into port values(?,?,?)");
	String industry_name=req.getParameter("industry_name");
	int percentage=Integer.parseInt(req.getParameter("percentage"));
	String message=req.getParameter("message");
	p.setString(1, industry_name);
	p.setInt(2, percentage);
	p.setString(3, message);
	int num=p.executeUpdate();
	if(num>0) {
	print.printf("successfully inserted");
	}
	con.close();
	p.close();
	
	}
		 catch(Exception e) {
			 System.out.println("error occured");
		 }

}
	}
