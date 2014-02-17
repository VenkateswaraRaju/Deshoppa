package requirementlogic;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import database_functions.*;
/**
 * Servlet implementation class CountryRetrive
 */
@WebServlet("/CountryRetrive")
public class CountryRetrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataBase db; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryRetrive() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	super.init(config);
		db = new DataBase();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String one=request.getParameter("stateadd_1");
		VariableIntialization location = new VariableIntialization();
		HttpSession session = request.getSession();
		try {
			if(one.equals("none")){
				String sql = "SELECT * FROM country";
			  PreparedStatement pst = db.getConnection().prepareStatement(sql);
			 ResultSet i = pst.executeQuery();

				while (i.next()) {
					String country_id = i.getString(1);
					String country = i.getString(2);
					//countries.add(country);
					location.setcountry(country);
					location.setcountry_id(country_id);
				}
				session.setAttribute("deshopa_country", location);
				response.sendRedirect("admin/cityadd.jsp");
			}
			if(one.equals("cityedit")){
				String sql = "SELECT * FROM country";
			  PreparedStatement pst = db.getConnection().prepareStatement(sql);
			 ResultSet i = pst.executeQuery();

				while (i.next()) {
					String country_id = i.getString(1);
					String country = i.getString(2);
					//countries.add(country);
					location.setcountry(country);
					location.setcountry_id(country_id);
				}
				session.setAttribute("deshopa_country", location);
				response.sendRedirect("admin/cityedit.jsp");
			}
			if(one.equals("yes")){
				String sql = "SELECT * FROM country";
			  PreparedStatement pst = db.getConnection().prepareStatement(sql);
			 ResultSet i = pst.executeQuery();

				while (i.next()) {
					String country_id = i.getString(1);
					String country = i.getString(2);
					//countries.add(country);
					location.setcountry(country);
					location.setcountry_id(country_id);
				}
				session.setAttribute("deshopa_country", location);
				response.sendRedirect("admin/stateeditdelete.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
