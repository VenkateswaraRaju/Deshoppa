package category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database_functions.Select;

public class CategoryListing {
	public List  getCategory() throws SQLException{
		Select sa= new Select();
		ArrayList list = new ArrayList();
		try {
			MenuVariables Mv = new MenuVariables();
			ResultSet rs;
			String category=null,categoryid=null,menuid =null;
			rs = sa.selectAll("category");
			
			while(rs.next()){
				category = rs.getString(1);
				categoryid=rs.getString(2);
				menuid = rs.getString(3);
				
				 Mv.setcategory(category);
				 Mv.setcategoryid(categoryid);
				 Mv.setmenuid(menuid);
				list.add(Mv);
				
}
		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}
		finally{
			
			sa=null;
		}
		return list;
	}
	
	
	public List  getCategoryWhereCatId(String catid) throws SQLException{
		Select sa= new Select();
		
		ArrayList list = new ArrayList();
		try {
			MenuVariables Mv = new MenuVariables();
			ResultSet rs;
			String category=null,categoryid=null,menuid =null;
			rs = sa.selectwhere("category", "categoryid", catid);
			
			while(rs.next()){
				category = rs.getString(1);
				categoryid=rs.getString(2);
				menuid = rs.getString(3);
				
				 Mv.setcategory(category);
				 Mv.setcategoryid(categoryid);
				 Mv.setmenuid(menuid);
				list.add(Mv);
				System.out.println(list);
}
		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}
		finally{
			
			sa=null;
		}
		return list;
	}
}
