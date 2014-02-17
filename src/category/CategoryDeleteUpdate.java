package category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database_functions.Delete;

/**
 * Servlet implementation class CategoryDeleteUpdate
 */
@WebServlet("/CategoryDeleteUpdate")
public class CategoryDeleteUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Delete de;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDeleteUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		 de = new Delete();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/HTML");
		PrintWriter pw = response.getWriter();
		String showmsg=null;
		String checkparameter = request.getParameter("checkparameter");
		if(checkparameter.equals("delete")){
			String id_cat = request.getParameter("Categoryid");
			
			int j=0;
			try {
				
				j= de.deletewhere("category","categoryid", id_cat);
				
				showmsg="information has been Deleted successfully";
				if(j == 1){
					pw.println(showmsg);
				}
				else{
					pw.println("Please try again there was an error");
				}
			} catch (Exception e) {
				System.out.println("Exception is ;" + e);
			}
			finally{
				
			}
		}
		else{
			pw.print("in the else block");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
