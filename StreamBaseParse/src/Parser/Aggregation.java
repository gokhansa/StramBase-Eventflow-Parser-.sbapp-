package Parser;

import java.util.ArrayList;

public class Aggregation extends Operation {

	private String name;
	private ArrayList<String> function; // first value is new field, second value is function,with its parameter like = avgValue, avg(input1.Price)
	private String outputPort;
	private String inputPort;
	private int number;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public ArrayList<String> getFunction() {
		return function;
	}
	public void setFunction(ArrayList<String> function) {
		this.function = function;
	}
	public String getOutputPort() {
		return outputPort;
	}
	public void setOutputPort(String outputPort) {
		this.outputPort = outputPort;
	}
	public String getInputPort() {
		return inputPort;
	}
	public void setInputPort(String inputPort) {
		this.inputPort = inputPort;
	}
	public String toString(){
		return "Name:"+getName() + " inputPort:" + getInputPort()+ "  Function: " + getFunction() +"  outputPort:" + getOutputPort();
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String getType() {
		return "Aggregation";
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public Aggregation(String elementType, String name){
		super(elementType,name);
	}
	

	
	public String getType() {
		return "Operation";
	}
	
	public String getSpecific(){
		return "Aggregation";
	}*/

}
