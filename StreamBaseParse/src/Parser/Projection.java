package Parser;
import java.util.ArrayList;

public class Projection extends Operation {
	private String name;
	private String inputPort;
	private String outputPort;
	private ArrayList<ArrayList<String>> operations;
	private String firstInputSelection;
	private int number;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInputPort() {
		return inputPort;
	}
	public void setInputPort(String inputPort) {
		this.inputPort = inputPort;
	}
	public String getOutputPort() {
		return outputPort;
	}
	public void setOutputPort(String outputPort) {
		this.outputPort = outputPort;
	}
	public ArrayList<ArrayList<String>> getOperations() {
		return operations;
	}
	public String getFirstInputSelection() {
		return firstInputSelection;
	}
	public void setFirstInputSelection(String firstInputSelection) {
		this.firstInputSelection = firstInputSelection;
	}
	public void setOperations(ArrayList<ArrayList<String>> operations) {
		this.operations = operations;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String toString(){
		return "Name:"+getName() + " inputPort:" + getInputPort() + "  Operations:" + getOperations()
		+"  outputPort:" + getOutputPort() + "  Input Selection:" +getFirstInputSelection();
	}
	@Override
	public String getType() {		
		return "Projection";
	} 
	
}
