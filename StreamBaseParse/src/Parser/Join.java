package Parser;
import java.util.ArrayList;

public class Join extends Operation {

	private String conditionValue;
	private String inputPort1;
	private String inputPort2;
	private String outputPort;
	private ArrayList<ArrayList<String>> outputAttributes;
	private String name;
	private int number;


	public String getConditionValue() {
		return conditionValue;
	}

	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

	public String getInputPort1() {
		return inputPort1;
	}

	public void setInputPort1(String inputPort1) {
		this.inputPort1 = inputPort1;
	}

	public String getInputPort2() {
		return inputPort2;
	}

	public void setInputPort2(String inputPort2) {
		this.inputPort2 = inputPort2;
	}
	
	public String getOutputPort() {
		return outputPort;
	}

	public void setOutputPort(String outputPort) {
		this.outputPort = outputPort;
	}

	public ArrayList<ArrayList<String>> getOutputAttributes() {
		return outputAttributes;
	}

	public void setOutputAttributes(ArrayList<ArrayList<String>> outputAttributes) {
		this.outputAttributes = outputAttributes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String toString(){
		return "name:"+ getName() +" inputPort1:" + getInputPort1()+ " inputPort2:" + getInputPort2()+ "  outputPort:" + getOutputPort()+ " outputs:" + getOutputAttributes();
				
	}

	@Override
	public String getType() {
		return "Join";
	}



	/*

	public String getType() {
		return "Operation";
	}
	public String getSpecific(){
		return "Join";
	}
	*/
	

}
