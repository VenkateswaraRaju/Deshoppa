package category;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validations.Validation;
import database_functions.Delete;
import database_functions.Insert;
import database_functions.Select;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Insert in ; 
	Validation va;
	Select sa;
	Delete de;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		in = new Insert(); va = new Validation();sa= new Select();de= new Delete();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/HTML");
		PrintWriter pw = response.getWriter();
		String insert = request.getParameter("menudelete");
		String showmsg=null;
	
			String menuname = request.getParameter("menu");
			int menu_id = 500;
			
			int k=1;
			Map<Integer, String> inputvalues = new HashMap<Integer, String>();
			if(!va.allvalidation(request,response,menuname)){return;} 
			try {
				ResultSet rs;
				rs = sa.selectAll("menu");
				while (rs.next()) {
					menu_id=menu_id+1;
				}
				String id_menu = Integer.toString(menu_id); 
				inputvalues.put(k, menuname);k++;
				inputvalues.put(k, id_menu);k++;
				int i = in.insert("menu", 2, inputvalues);
				showmsg="information has been submitted successfully";
				if(i == 1){
					pw.println(showmsg);
				}
				else{
					pw.println("Please try again there was an error");
				}
				
			} catch (Exception e) {
				System.out.println(e+"");
			}
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
