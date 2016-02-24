package Parser;
import java.util.ArrayList;

public class InputStream implements Elements{
	ArrayList<String> schema;
	private String name;
	private int number;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getSchema() {
		return schema;
	}	
	public void setSchema(ArrayList<String> schema) {
		this.schema = schema;
	}
	public String getType(){
		return "InputStream";
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String toString(){
		return "Name:"+ getName() +"  Schema:" + getSchema();
	}

	/*public ArrayList<String> list() {
		ArrayList<String> list = new ArrayList<String>();
		list.add();
		
		return list;
	}*/

	
	
	
}
