package requirementlogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database_functions.*;
/**
 * Servlet implementation class UpdateInfoState
 */
@WebServlet("/UpdateInfoState")
public class UpdateInfoState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DataBase db;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		db = new DataBase();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = null;
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
		 String state_edit =request.getParameter("state_edit");
         String stateid_edit =request.getParameter("stateid_edit");
         String country = request.getParameter("country");
         try {
        	
            		sql = "UPDATE state SET state ='"+state_edit+"' WHERE state_id='"+stateid_edit+"'";
     			PreparedStatement pst = db.getConnection().prepareStatement(sql);
     			int j=  pst.executeUpdate();
     			if(j==1){
     				//pw.println("true");
     			RequestDispatcher rd=request.getRequestDispatcher("CountryRetrive?stateadd_1=yes");
     				rd.forward(request, response);
     			}
     			else pw.println("noo");
              
     			pst.close();
		} 
        	
        	 catch (Exception e) {
        		 pw.println("exception is"+e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
