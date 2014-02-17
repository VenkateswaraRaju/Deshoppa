package database_functions;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import database_functions.*;


public class Select {
	DataBase db = new DataBase();
	
	public final ResultSet selectAll(String fromvalue){
		 ResultSet j = null;
		try {
			String sql1 = "SELECT * FROM "+fromvalue+"";
			PreparedStatement pst1 = db.getConnection().prepareStatement(sql1);
			  j = pst1.executeQuery();
			  pst1.closeOnCompletion();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return j;
		
	}
	
	
		public final ResultSet selectwhere(String fromvalue, String wherevalue, String wheresearchvalue){
					 ResultSet j = null;
					try {
						String sql1 = "SELECT * FROM "+fromvalue+" WHERE "+wherevalue+"= ? ";
						PreparedStatement pst1 = db.getConnection().prepareStatement(sql1);
						pst1.setString( 1, wheresearchvalue);
						  j = pst1.executeQuery();
						  pst1.closeOnCompletion();
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					return j;
					
				}
	
	
}
