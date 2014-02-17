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
 * Servlet implementation class CategoryInsert
 */
@WebServlet("/CategoryInsert")
public class CategoryInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Insert in ; 
	Validation va;
	Select sa;
	Delete de;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryInsert() {
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
		String showmsg=null;
		String checkparameter = request.getParameter("checkparameter");
			if(checkparameter.equals("insert")){
				String Category = request.getParameter("Category");
				String menu = request.getParameter("menu");
				int cat_menu_id = 300;
				
				int k=1;
				Map<Integer, String> inputvalues = new HashMap<Integer, String>();
				if(!va.allvalidation(request,response,Category)){return;} 
				try {
					ResultSet rs;
					rs = sa.selectAll("category");
					while (rs.next()) {
						cat_menu_id=cat_menu_id+1;
					}
					String id_menuCat = Integer.toString(cat_menu_id);
					id_menuCat +="cat";
					System.out.println(id_menuCat);
					inputvalues.put(k, Category);k++;
					inputvalues.put(k, id_menuCat);k++;
					inputvalues.put(k, menu);k++;
					int i = in.insert("category", 3, inputvalues);
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
			else if(checkparameter.equals("Delete")){
				pw.println("in else block");
			}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
