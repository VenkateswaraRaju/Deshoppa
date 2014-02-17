package requirementlogic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database_functions.*;

public class StateAdd {
	public List  getcountry() throws SQLException{
		Select sa= new Select();
		
		ArrayList list = new ArrayList();
		try {
			VariableIntialization vi = new VariableIntialization();
			ResultSet rs;
			String Countryid=null,Country =null;
			rs = sa.selectAll("menu");
			
			while(rs.next()){
				 Countryid = rs.getString(1);
				 Country = rs.getString(2);
				
				 vi.setcountry(Countryid);
				 vi.setcountry_id(Countryid);
				list.add(vi);
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
