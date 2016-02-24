package Parser;

public class OutputStream implements Elements{

	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return "Name:"+ getName();
	}
	@Override
	public String getType() {
		return "OutputStream";
	}
}
