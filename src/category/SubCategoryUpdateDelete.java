package category;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import database_functions.Select;

/**
 * Servlet implementation class CategoryUpdateDelete
 */
@WebServlet("/CategoryUpdateDelete")
public class SubCategoryUpdateDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Select sa;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategoryUpdateDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		sa = new Select();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("Text/HTML");
			PrintWriter pw = response.getWriter();
			try {
				ResultSet rs;
				String SubCategory=null,Category=null,Menu=null,SubcategoryId =null;
				ArrayList<String> Sub_Category = new ArrayList<String>();
				ArrayList<String> category = new ArrayList<String>();
				ArrayList<String> menu = new ArrayList<String>();
				ArrayList<String> Subcategory_Id = new ArrayList<String>();
				rs = sa.selectAll("subcategory");
				JSONObject obj = new JSONObject();
				pw.println("[");
				 while (rs.next()) {
					  SubCategory = rs.getString(1);
					  Category = rs.getString(2);
					  Menu = rs.getString(3);
					  SubcategoryId = rs.getString(4);
					  
				      Sub_Category.add(SubCategory);
				      category.add(Category);
				      menu.add(Menu);
				      Subcategory_Id.add(SubcategoryId);
				      
				  }
				  obj.put("Sub_Category",Sub_Category);
				   obj.put("category",category);
				   obj.put("menu",menu);
				   obj.put("Subcategory_Id",Subcategory_Id);
				  pw.println(obj);
				  pw.println("]");
				
			} catch (Exception e) {
				pw.println(e.getMessage());
			}
	}
}
