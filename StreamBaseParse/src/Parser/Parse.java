package Parser;

import java.util.ArrayList;


import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.css.Counter;

public class Parse {

	static Join joinParse(Node node, Join join, int position ) {

		NodeList childNodes = node.getChildNodes();
		ArrayList<ArrayList<String>> big = new ArrayList<ArrayList<String>>();
		ArrayList<String> value = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		for(int i =0; i < childNodes.getLength() ; i++){
			Node cNode = childNodes.item(i);
			if(cNode instanceof Element){
			//	String content = cNode.getLastChild().getTextContent().trim();
				switch (cNode.getNodeName()){
				case "input":
					if(Integer.valueOf(cNode.getAttributes().getNamedItem("port").getNodeValue()) == 1){   //(element cNode)  diye downcast vardı
						join.setInputPort1(cNode.getAttributes().getNamedItem("stream").getNodeValue());
					}
					else{
						join.setInputPort2(cNode.getAttributes().getNamedItem("stream").getNodeValue());
					}
					break;
				case "param":
						if(cNode.getAttributes().getNamedItem("name").getNodeValue().contains("expression")){
							if(cNode.getAttributes().getNamedItem("name").getNodeValue().contains("expression-name")){	
							name.add(cNode.getAttributes().getNamedItem("value").getNodeValue());
							}
							else{
							value.add(cNode.getAttributes().getNamedItem("value").getNodeValue());
							}
						}
						else if(cNode.getAttributes().getNamedItem("name").getNodeValue().contains("predicate")) {
							join.setConditionValue(cNode.getAttributes().getNamedItem("value").getNodeValue());
						}
					break;
				case "output":
						join.setOutputPort(cNode.getAttributes().getNamedItem("stream").getNodeValue());
				
					break;
				case "a":
					
					break;
					
				}				
			}
			
		}
		big.add(name);
		big.add(value);
		join.setOutputAttributes(big);
		join.setNumber(position);
		return join;
	}

	
	static Projection projectionParse(Node node, Projection projection, int position){
		NodeList childNodes = node.getChildNodes();
		ArrayList<ArrayList<String>> first = new ArrayList<ArrayList<String>>();
		ArrayList<String> value = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		
		for(int i =0; i < childNodes.getLength() ; i++){
			Node cNode = childNodes.item(i);
			if(cNode instanceof Element){
			//	String content = cNode.getLastChild().getTextContent().trim();
				switch (cNode.getNodeName()){
			
				case "input":
					projection.setInputPort(cNode.getAttributes().getNamedItem("stream").getNodeValue());
					break;
				case "output":
					projection.setOutputPort(cNode.getAttributes().getNamedItem("stream").getNodeValue());
					break;
				case "target-list":
					NodeList ccNodes = cNode.getChildNodes();

					for( int j =0; j<ccNodes.getLength(); j++   ){
						Node ccNode = ccNodes.item(j);
						if(ccNode instanceof Element){
							if(ccNode.getNodeName().contains("expressions")){
								//LISTE HALINDE OLABILIR HEPSINI DOUBLEARRAYLIST E KAYDET
								NodeList cccNodes = ccNode.getChildNodes();
								for(int k=0; k<cccNodes.getLength(); k++){
									Node cccNode = cccNodes.item(k);
									if(cccNode instanceof Element){
										name.add(cccNode.getNodeName());
										name.add(cccNode.getAttributes().getNamedItem("field").getNodeValue());
										if(cccNode.getLastChild() != null)
										name.add(cccNode.getLastChild().getTextContent().trim());
										value = cloner(name);
										first.add(value);
										name.clear();
									}									
								}
							}										
							else if(ccNode.getNodeName().contains("item")){ //sadece all yada none secıldıgını varsayıyorum
								projection.setFirstInputSelection(ccNode.getAttributes().getNamedItem("selection").getNodeValue());
							}
						}
					}
					break;					
				}				
			}
			
		}
		projection.setOperations(first);
		projection.setNumber(position);
		return projection;
	}

	
	static Aggregation aggregationParse(Node node, Aggregation aggregation, int position){
		NodeList childNodes = node.getChildNodes();
	
		ArrayList<String> name = new ArrayList<String>();
		
		for(int i =0; i < childNodes.getLength() ; i++){
			Node cNode = childNodes.item(i);
			if(cNode instanceof Element){
			//	String content = cNode.getLastChild().getTextContent().trim();
				switch (cNode.getNodeName()){
			
				case "input":
					aggregation.setInputPort(cNode.getAttributes().getNamedItem("stream").getNodeValue());
					break;
				case "output":
					aggregation.setOutputPort(cNode.getAttributes().getNamedItem("stream").getNodeValue());
					break;
				case "target-list":
					
					NodeList ccNodes = cNode.getChildNodes();
					for( int j =0; j<ccNodes.getLength(); j++   ){
						Node ccNode = ccNodes.item(j);
						if(ccNode instanceof Element){
							if(ccNode.getNodeName().contains("expressions")){								
								NodeList cccNodes = ccNode.getChildNodes();
								for(int k=0; k<cccNodes.getLength(); k++){
									Node cccNode = cccNodes.item(k);
									if(cccNode instanceof Element){
										name.add(cccNode.getNodeName());
										name.add(cccNode.getAttributes().getNamedItem("field").getNodeValue());
										if(cccNode.getLastChild() != null)
										name.add(cccNode.getLastChild().getTextContent().trim());																				
									}									
								}
							}																
						}
					}			
					aggregation.setFunction(name);	
					aggregation.setNumber(position);
					break;					
				}				
			}			
		}
		return aggregation;
	}
	
	
	static Selection selectionParse(Node node, Selection selection, int position){
		NodeList childNodes = node.getChildNodes();
	
		ArrayList<String> operations = new ArrayList<String>();
		
		for(int i =0; i < childNodes.getLength() ; i++){
			Node cNode = childNodes.item(i);
			if(cNode instanceof Element){
			//	String content = cNode.getLastChild().getTextContent().trim();
				switch (cNode.getNodeName()){
			
				case "input":
					selection.setInputPort(cNode.getAttributes().getNamedItem("stream").getNodeValue());
					break;
				case "output":
					selection.setOutputPort(cNode.getAttributes().getNamedItem("stream").getNodeValue());
					break;
				case "param":
					if(cNode.getAttributes().getNamedItem("name").getNodeValue().contains("expression")){					
						operations.add(cNode.getAttributes().getNamedItem("value").getNodeValue());
						selection.setFunction(operations);
					}					
				break;				
				}				
			}			
		}
		return selection;
	}	
	
	
static InputStream inputStreamParse(Node node, InputStream inputStream, int position){
		
		
		ArrayList<String> value = new ArrayList<String>();				
		int counter=0;
		NodeList aNodeList = node.getChildNodes();
		for(int i=0; i<aNodeList.getLength(); i++){			
			if(aNodeList.item(i).getNodeName().contains("schema"))
				counter=i;
		}
		Node aNode = aNodeList.item(counter);
		NodeList list = aNode.getChildNodes();
		
		for(int i =0; i < list.getLength() ; i++){
			Node aaNode = list.item(i);
			if(aaNode instanceof Element){
			 value.add(aaNode.getAttributes().getNamedItem("name").getNodeValue());
			}
					
		}
		inputStream.setSchema(value);
		inputStream.setNumber(position);
		return inputStream;
}

/*
static OutputStream outputStreamParse(Node node, OutputStream outputStream){
	
	ArrayList<String> value = new ArrayList<String>();				
	
	Node aNode = node.getChildNodes().item(1);
	NodeList list = aNode.getChildNodes();
	for(int i =0; i < list.getLength() ; i++){
		Node aaNode = list.item(i);
		if(aaNode instanceof Element){
		 value.add(aaNode.getAttributes().getNamedItem("name").getNodeValue());
		}
	}	
	outputStream.setSchema(value);
	
	return outputStream;
}
*/
static public ArrayList<String> cloner(ArrayList<String> original){
	ArrayList<String> clone = new ArrayList<String>();
	
	for(String s: original){
		clone.add(s);
	}
			
	return clone;		
}
}
