package requirementlogic;

import java.util.ArrayList;
import java.util.HashMap;

public class VariableIntialization {
	
			private ArrayList<String> country =new ArrayList<String>();
			private ArrayList<String> country_id =new ArrayList<String>();
			private ArrayList<String> country_ref =new ArrayList<String>();
			private ArrayList<String> State =new ArrayList<String>();
			private ArrayList<String> State_id =new ArrayList<String>();
			private ArrayList<String> City =new ArrayList<String>();
			private ArrayList<String> menu =new ArrayList<String>();
			private ArrayList<String> menuid = new ArrayList<String>();
			public void setcountry(String value)
		    {
				this.country.add(value);
		    }
		 public ArrayList<String> getcountry() { return country; }
		 
		 public void setcountry_id(String value)
		    {
				this.country_id.add(value);
			}
		 public ArrayList<String> getcountry_id() { return country_id; }
		 
		 public void setcountry_ref(String value)
		    {
				this.country_ref.add(value);
		    }
		 public ArrayList<String> getcountry_ref() { return country_ref; }
		 
		 public void setState(String value)
		    {
			 this.State.add(value);
		    }
		 public ArrayList<String> getState() { return State; }
		 
		 public void setState_id(String value)
		    {
			 this.State_id.add(value);
		    }
		 public ArrayList<String> getState_id() { return State_id; }
		 
		 public void setCity(String value)
		    {
			this.City.add(value);
		    }
		 public ArrayList<String> getCity() { return City; }
		 public void setmenu(String value)
		    {
			 
			this.menu.add(value);
			//System.out.println(menu);
		    }
		 public ArrayList<String> getmenu() { return menu; }
		 public void setmenuid(String value)
		    {
			this.menuid.add(value);
		    }
		 public ArrayList<String> getmenuid() { return menuid; }
		 
}
