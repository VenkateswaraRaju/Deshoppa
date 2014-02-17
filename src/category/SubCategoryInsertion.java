package category;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database_functions.Insert;
import database_functions.Select;
import validations.*;

/**
 * Servlet implementation class CategoryInsertion
 */
@WebServlet("/CategoryInsertion")
public class SubCategoryInsertion extends HttpServlet {
	Insert in ; 
	Validation va;
	Select sa;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategoryInsertion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
					in = new Insert(); va = new Validation(); sa= new Select();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/HTML");
		PrintWriter pw = response.getWriter();
		String categorys = request.getParameter("categorys");
		String subcategorys = request.getParameter("subcategorys");
		String SubCategoryvalue = request.getParameter("SubCategoryvalue");
		int subcategoryId = 1300;
		String showmsg=null;
		int k=1;
		Map<Integer, String> inputvalues = new HashMap<Integer, String>();
				if(!va.allvalidation(request,response,SubCategoryvalue)){return;}
				
		try {
				ResultSet rs;
				rs = sa.selectAll("subcategory");
				while (rs.next()) {
					subcategoryId=subcategoryId+1;
				}
				String id_Subcategory = Integer.toString(subcategoryId); 
				inputvalues.put(k, SubCategoryvalue);k++;
				inputvalues.put(k, subcategorys);k++;
				inputvalues.put(k, categorys);k++;
				inputvalues.put(k,id_Subcategory);k++;
				int i = in.insert("subcategory", 4, inputvalues);
				if(i == 1){
					showmsg="information has been submitted successfully";
					pw.println(showmsg);
				}
				else{
					pw.println("Please try again there was an error");
				}
				
		} catch (Exception e) {
			pw.println("Exception is "+e.getMessage());
		}
		finally{
			pw.close();
		}
	}



}
