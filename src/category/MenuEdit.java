package category;

import java.io.IOException;

import java.io.PrintWriter;

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
 * Servlet implementation class MenuEdit
 */
@WebServlet("/MenuEdit")
public class MenuEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Delete de;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuEdit() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		de= new Delete();
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/HTML");
		PrintWriter pw = response.getWriter();
		String showmsg=null;
		String menuname = request.getParameter("menu");
		String menuid = request.getParameter("menu_Id");
			
		try {
			int j=0;
			j = de.deletewhere("menu", "menuid", menuid);
			showmsg="information has been deleted successfully";
			if(j == 1){
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
