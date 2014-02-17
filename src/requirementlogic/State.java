package requirementlogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database_functions.*;
/**
 * Servlet implementation class State
 */
@WebServlet("/State")
public class State extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DataBase db;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public State() {
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
		String state;
		String xxx = request.getParameter("country_ref");
		long Country_ref = Long.parseLong(xxx);
		long state_id=Country_ref;
		try {
			
			state = request.getParameter("state");
			//state_id = request.getParameter("state_id");
			
			String quer="SELECT * FROM state";
			PreparedStatement pst1 = db.getConnection().prepareStatement(quer);
		    ResultSet rs=pst1.executeQuery(quer);
				 while (rs.next()) {
					   state_id=state_id+1;
				}
				
			String query="insert into state values(?,?,?)";
			PreparedStatement pst = db.getConnection().prepareStatement(query);
			pst.setLong(1, state_id);
			pst.setString(2, state);
			pst.setLong(3, Country_ref);
			int i = pst.executeUpdate();
			if(i == 1){
				RequestDispatcher rd=request.getRequestDispatcher("CountryRetrive?stateadd_1=none");
				rd.forward(request, response);
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
