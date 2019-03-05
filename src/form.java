
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class form
 */
@WebServlet("/form")
public class form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String Name=request.getParameter("n1");
	        String UserName=request.getParameter("n2");
	        String Password=request.getParameter("p1");
	        String Gender=request.getParameter("r1");
	        
	        String Subjects[] =request.getParameterValues("checkbox");
	        String City =request.getParameter("select");
	        PrintWriter out=response.getWriter();
	    String sub="";
	    for(int i=0;i<Subjects.length;i++)
	    {
	        sub+=Subjects[i]+",";
	    }

	             try{
	                  Class.forName("oracle.jdbc.driver.OracleDriver");
	                  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","REGISTRATION_FORM","123");
	                 PreparedStatement ps=con.prepareStatement("insert into TABLE1 values(?,?,?,?,?,?)");
	                 // PreparedStatement ps=con.prepareStatement("insert into Table1 ('"+Name+"','"+UserName+"','"+Password+"','"+Gender+"')");
	                  
	                ps.setString(1,Name);
	                ps.setString(2,UserName);
	                ps.setString(3,Password);
	                ps.setString(4,Gender);
	                ps.setString(5,sub);
	                ps.setString(6,City);
	                
	                  
	                
	                  int i=ps.executeUpdate();
	                
	                  
	                  if(i>0)
	                  {
	                  
	                  
	                    out.println("Successfully Registered"+" "+"Welcome User");
	                  }
	                  
	              }catch(Exception e){System.out.print(e.toString());}

	}

}
