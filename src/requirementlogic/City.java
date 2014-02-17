package requirementlogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import database_functions.*;
import database_functions.*;/**
 * Servlet implementation class City
 */
@WebServlet("/City")
public class City extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DataBase db;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public City() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		db = new DataBase();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("Text/HTML");
		PrintWriter pw = response.getWriter();
		String City;
		String xxx = request.getParameter("state_ref");
		long state_ref = Long.parseLong(xxx);
		long City_id=state_ref;
		
		
		
		try {
			
			City = request.getParameter("city");
			//City_id = request.getParameter("City_id");
			pw.println(City);
			String quer="SELECT * FROM City";
			PreparedStatement pst1 = (PreparedStatement) db.getConnection().prepareStatement(quer);
		    ResultSet rs=pst1.executeQuery(quer);
				 while (rs.next()) {
					   City_id=City_id+100;
				}
				
			String query="insert into City values(?,?,?)";
			PreparedStatement pst = (PreparedStatement) db.getConnection().prepareStatement(query);
			pst.setLong(1, City_id);
			pst.setString(2, City);
			pst.setLong(3, state_ref);
			int i = pst.executeUpdate();
			if(i == 1){
				response.sendRedirect("CountryRetrive?stateadd_1=none");			
			}
			else {
				pw.println("not done");
			}
			
		}
		catch (Exception e) {
		     pw.println("Exception is "+ e.getMessage());
		    //out.println(e.getMessage());
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
