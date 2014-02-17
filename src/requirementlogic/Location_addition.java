package requirementlogic;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import database_functions.Insert;
import database_functions.Select;
import database_functions.*;
/**
 * Servlet implementation class Location_addition
 */
@WebServlet("/Location_addition")
public class Location_addition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DataBase db;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Location_addition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		db= new DataBase();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/HTML");
		PrintWriter pw = response.getWriter();
		String country;
		int country_id = 1300;
		int k=1;
		
		//ArrayList<String> inputvalues = new ArrayList<String>();
		Map<Integer, String> inputvalues = new HashMap<Integer, String>();
		Insert in = new Insert();
		try {
			
			country = request.getParameter("country");
			ResultSet rs;
			
			Select sa = new Select();
			
			  rs = sa.selectAll("country");
				  
				   while (rs.next()) {
					   country_id=country_id+1;
				}
				String id_country = Integer.toString(country_id); 
				inputvalues.put(k, id_country);
			k++;
			inputvalues.put(k,country);
			int i = in.insert("country", 2, inputvalues);
		if(i == 1){
				RequestDispatcher rd=request.getRequestDispatcher("Retrive_country?stateadd_1=zero&dd=ccc");
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
		
		
		
		
	}

