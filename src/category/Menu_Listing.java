package category;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import database_functions.*;


public class Menu_Listing {
	public List  getMenu() throws SQLException{
		Select sa= new Select();
		
		ArrayList list = new ArrayList();
		try {
			MenuVariables Mv = new MenuVariables();
			ResultSet rs;
			String menu=null,menuid =null;
			rs = sa.selectAll("menu");
			
			while(rs.next()){
				menu = rs.getString(1);
				menuid = rs.getString(2);
				
				 Mv.setmenu(menu);
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
	
	public List  getMenuWhereId(String menu_id) throws SQLException{
		Select sa= new Select();
		
		ArrayList list = new ArrayList();
		try {
			MenuVariables Mv = new MenuVariables();
			ResultSet rs;
			String menu=null,menuid =null;
			rs = sa.selectwhere("menu", "menuid", menu_id);
			
			while(rs.next()){
				menu = rs.getString(1);
				menuid = rs.getString(2);
				
				 Mv.setmenu(menu);
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
	
}

