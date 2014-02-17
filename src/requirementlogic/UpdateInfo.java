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
import javax.servlet.http.HttpSession;
import database_functions.*;
/**
 * Servlet implementation class UpdateInfo
 */
@WebServlet("/UpdateInfo")
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DataBase db;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
			super.init(config);
			db = new DataBase();
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = null;
        PrintWriter pw = response.getWriter();

        response.setContentType("text/html");
    	 String country_edit=request.getParameter("country_edit");
         String countryid_edit =request.getParameter("countryid_edit");
         String state_edit =request.getParameter("state_edit");
         String stateid_edit =request.getParameter("stateid_edit");
         String country = request.getParameter("country");
		try {
			
       		sql = "UPDATE country SET country ='"+country_edit+"' WHERE country_id='"+countryid_edit+"'";
			  PreparedStatement pst = db.getConnection().prepareStatement(sql);
			int j=  pst.executeUpdate();
			if(j==1){
				RequestDispatcher rd=request.getRequestDispatcher("Retrive_country?stateadd_1=verified");
				rd.forward(request, response);
			}
			else pw.println("noo");
         
			pst.close();
       
       	
    
		} catch (Exception e) {
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
