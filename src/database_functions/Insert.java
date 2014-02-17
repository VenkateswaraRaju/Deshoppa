package database_functions;

import java.sql.PreparedStatement;
import java.util.*;

public class Insert {
	DataBase db = new DataBase();
	
	
	@SuppressWarnings("unused")
					public final int insert(String insertTable, int insert_num ,Map<Integer, String> inputvalues){
						 int j = 0;
						 try {
							 
							 String x ="?";
							 for(int i=1; i<insert_num; i++){
								 
								 x= x.concat(",?");
							 }
							 String NOIV = x;
							 String query="insert into "+insertTable+" values("+NOIV+")";
								
								PreparedStatement pst = db.getConnection().prepareStatement(query);
						
								for(int k=1; k<=insert_num;k++){
									pst.setString(k, inputvalues.get(k));
								}
								j = pst.executeUpdate();
							pst.closeOnCompletion();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						 return j;
					}
					
					
}
