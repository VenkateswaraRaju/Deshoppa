package requirementlogic;

import java.io.File;
import java.io.FileInputStream;
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
 * Servlet implementation class InsertImage
 */
@WebServlet("/InsertImage")
public class InsertImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DataBase db;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertImage() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		  PrintWriter pw = response.getWriter();
			
		try
		{
			
		
		File imgfile = new File("C:\\www.jpg");
		FileInputStream fin = new FileInputStream(imgfile);
		String sql = "insert into uploadfile values(?)";
		PreparedStatement pre = db.getConnection().prepareStatement(sql);
		
		pre.setBinaryStream(1,fin,(int)imgfile.length());
		pw.println("til by");
		//pre.setString(2,"he");
		//pre.setLong(3,4);
		pre.executeUpdate();
		
		System.out.println("Inserting Successfully!");
		pre.close();
		pw.println("done");
		}
		catch(Exception e){
			pw.println("direct exception");
		pw.println("Exception is "+ e.getMessage());
		}
	}

}
