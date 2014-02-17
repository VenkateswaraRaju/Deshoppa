package requirementlogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database_functions.*;
/**
 * Servlet implementation class DeleteInfo
 */
@WebServlet("/DeleteInfo")
public class DeleteInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  DataBase db;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInfo() {
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
		// TODO Auto-generated method stub
		String sql = null;
        PrintWriter pw = response.getWriter();

        response.setContentType("text/html");
        
        try {
        	String countryid_edit=request.getParameter("countryid_edit");
            sql= "DELETE FROM country WHERE country_id ='"+countryid_edit+"'";
            PreparedStatement pst = db.getConnection().prepareStatement(sql);
			int j=  pst.executeUpdate();
			if(j==1){
				response.sendRedirect("Retrive_country?stateadd_1=verified");
			}
		} catch (Exception e) {
			pw.println(e.getMessage());
		}
	}

}
