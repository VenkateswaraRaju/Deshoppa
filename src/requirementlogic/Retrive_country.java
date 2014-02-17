package requirementlogic;

import requirementlogic.VariableIntialization;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import database_functions.Select;
import database_functions.*;



/**
 * Servlet implementation class Retrive_country
 */
@WebServlet("/Retrive_country")
public class Retrive_country extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DataBase db;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Retrive_country() {
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
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			String one=request.getParameter("stateadd_1");
			String countryref= request.getParameter("countryREF");
			String check = request.getParameter("check");
			VariableIntialization location = new VariableIntialization();
			HttpSession session = request.getSession();
			String state = null,country_ref = null;String state_id = null;
			ArrayList<String> statelist = new ArrayList<String>();
			ArrayList<String> stateidlist = new ArrayList<String>();
			ArrayList<String> country_ref_list = new ArrayList<String>();
			
		try {
			
			if(one.equals("none")){
				//String sql1 = "SELECT * FROM state WHERE country_ref="+countryref+" ";
				  String sql = "SELECT * FROM country";
				  PreparedStatement pst = db.getConnection().prepareStatement(sql);
				//  PreparedStatement pst1 = db.getConnection().prepareStatement(sql1);
				//  ResultSet j = pst1.executeQuery();
				  ResultSet i = pst.executeQuery();
				 
				  Select sw = new Select();
				 
				  ResultSet j =  sw.selectwhere("state", "country_ref", countryref);
				  JSONObject obj = new JSONObject();
				  pw.println("[");
				  while (j.next()) {
					  
					 
				      state_id = j.getString(1);
				      state = j.getString(2);
				      
				      stateidlist.add(state_id);
				      statelist.add(state);
				  }
				   obj.put("statelist",statelist);
				  obj.put("stateidlist",stateidlist);
				  pw.println(obj);
				 
			               
				 pw.println("]");
				 pw.close();
					session.setAttribute("deshopa_country1", location);	
				 // session.setAttribute("deshopa_country", location);
				 //response.sendRedirect("admin/cityadd.jsp");
			}
			if(one.equals("stateedit")){
				String sql1 = "SELECT * FROM state WHERE country_ref="+countryref+" ";
				  String sql = "SELECT * FROM country";
				  PreparedStatement pst = db.getConnection().prepareStatement(sql);
				  PreparedStatement pst1 = db.getConnection().prepareStatement(sql1);
				  ResultSet j = pst1.executeQuery();
				  ResultSet i = pst.executeQuery();
				  while (j.next()) {
						state_id = j.getString(1);
						state = j.getString(2);
						country_ref = j.getString(3);
						location.setState(state);
						location.setState_id(state_id);
						location.setcountry_ref(country_ref);
					}
				  
				while (i.next()) {
					String country_id = i.getString(1);
					String country = i.getString(2);
					location.setcountry(country);
					location.setcountry_id(country_id);
				}
			//	pw.println(state);
					//session.setAttribute("deshopa_country1", location);	
				  session.setAttribute("deshopa_country", location);
				 response.sendRedirect("admin/stateeditdelete.jsp");
			}
			if(one.equals("cop")){
				String sql1 = "SELECT * FROM state WHERE country_ref="+countryref+" ";
				  String sql = "SELECT * FROM country";
				  PreparedStatement pst = db.getConnection().prepareStatement(sql);
				  PreparedStatement pst1 = db.getConnection().prepareStatement(sql1);
				  ResultSet j = pst1.executeQuery();
				  ResultSet i = pst.executeQuery();
				  while (j.next()) {
						state_id = j.getString(1);
						state = j.getString(2);
						country_ref = j.getString(3);
						location.setState(state);
						location.setState_id(state_id);
						location.setcountry_ref(country_ref);
					}
				while (i.next()) {
					String country_id = i.getString(1);
					String country = i.getString(2);
					location.setcountry(country);
					location.setcountry_id(country_id);
				}
				
				 session.setAttribute("deshopa_country", location);
				 response.sendRedirect("admin/stateeditdelete.jsp");
			}	
			if(one.equals("zero")){
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
				 response.sendRedirect("admin/stateadd.jsp");
}
			if(one.equals("verified")){
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
	response.sendRedirect("admin/countryedit.jsp");
}
			} catch (Exception e) {
			pw.println("exception is " +e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
