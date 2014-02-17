package category;

import java.util.ArrayList;

public class MenuVariables {

	
	
	private ArrayList<String> menu =new ArrayList<String>();
	private ArrayList<String> menuid = new ArrayList<String>();
	private ArrayList<String> category =new ArrayList<String>();
	private ArrayList<String> categoryid = new ArrayList<String>();
	

		public void setmenu(String value)
	    {
		 this.menu.add(value);
	    }
		public ArrayList<String> getmenu() { return menu; }
		public void setmenuid(String value)
	    {
		this.menuid.add(value);
	    }
		public ArrayList<String> getmenuid() { return menuid; }
		public void setcategory(String value)
	    {
		 this.category.add(value);
	    }
		public ArrayList<String> getcategory() { return category; }
		public void setcategoryid(String value)
	    {
		this.categoryid.add(value);
	    }
		public ArrayList<String> getcategoryid() { return categoryid; }
 

}
