package Parser;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ParserMain {


	static final String OPERATION = "Operation";
	static final String INPUTSTREAM = "input-stream";
	static final String OUTPUTSTREAM = "output-stream";
	static final String BOX = "box";
	static final String JOIN = "join";
	
	File	fXmlFile = new File("Query1.sbapp");
	
	
	public static ArrayList<ArrayList<Elements>>  main(String arg) throws SAXException, ParserConfigurationException {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();	
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			ArrayList<Operation> operationList = new ArrayList<>();
			ArrayList<Aggregation> aggregationList = new ArrayList<>();
			ArrayList<Selection> selectionList = new ArrayList<>();
			ArrayList<Join> joinList = new ArrayList<>();
			ArrayList<Projection> projectionList = new ArrayList<>();
			ArrayList<InputStream>  inputStreamList = new ArrayList<>();
			ArrayList<OutputStream> outputStreamList = new ArrayList<>();

		File fXmlFile = new File(arg);	
		
		
		try {
			Document document = builder.parse(fXmlFile);
			NodeList nodeListOperation = document.getElementsByTagName("box");	
			NodeList nodeListInputStream = document.getElementsByTagName("stream");
			NodeList nodeListOutputStream = document.getElementsByTagName("output-stream");
			
			int counter =0;
			   
	        
			for(int i =0; i<nodeListInputStream.getLength(); i++){ //input stream
				Node node = nodeListInputStream.item(i);
				if(node instanceof Element){
					InputStream inputStream = new InputStream();
					inputStream.setName(node.getAttributes().getNamedItem("name").getNodeValue());
					inputStream = Parse.inputStreamParse(node, inputStream, counter);
					inputStreamList.add(inputStream);
					counter++;
				}
			}
			counter =0;
			
			for(int i =0; i<nodeListOutputStream.getLength(); i++){ //output stream
				Node node = nodeListOutputStream.item(i);
				if(node instanceof Element){
					OutputStream outputStream = new OutputStream();
					outputStream.setName(node.getAttributes().getNamedItem("name").getNodeValue());
					outputStreamList.add(outputStream);
				}
			}
			
			for (int i = 0; i < nodeListOperation.getLength(); i++){
				Node node = nodeListOperation.item(i);
				//System.out.println(node.getAttributes().getNamedItem("type").getNodeValue());
				if(node instanceof Element){				
					if(node.getAttributes().getNamedItem("type").getNodeValue().contains("join")) //join
					{
						Join join = new Join();
						join.setName(node.getAttributes().getNamedItem("name").getNodeValue());
						join = Parse.joinParse(node,join,counter);									
						joinList.add(join);
						Operation ops = (Operation) join; 			//upcasting
						operationList.add(ops);	
						counter++;
					}
					if(node.getAttributes().getNamedItem("type").getNodeValue().contains("map")) //projection
					{			
						Projection projection = new Projection();
						projection.setName(node.getAttributes().getNamedItem("name").getNodeValue());
						projection = Parse.projectionParse(node,projection,counter);									
						projectionList.add(projection);
						Operation ops = (Operation) projection; 			//upcasting
						operationList.add(ops);	
						counter++;
					}
					if(node.getAttributes().getNamedItem("type").getNodeValue().contains("aggregate")) //aggregation	
					{										
						Aggregation aggregation = new Aggregation();
						aggregation.setName(node.getAttributes().getNamedItem("name").getNodeValue());
						aggregation	= Parse.aggregationParse(node,aggregation,counter);									
						aggregationList.add(aggregation);					
						Operation ops = (Operation) aggregation; 			//upcasting
						operationList.add(ops);		
						counter++;
					}
					if(node.getAttributes().getNamedItem("type").getNodeValue().contains("filter")) //aggregation	
					{				
						Selection selection = new Selection();
						selection.setName(node.getAttributes().getNamedItem("name").getNodeValue());
						selection	= Parse.selectionParse(node,selection,counter);									
						selectionList.add(selection);					
						Operation ops = (Operation) selection; 			//upcasting
						operationList.add(ops);		
						counter++;
					}
				}									
			}


		} catch (IOException io) {
			System.out.println(io.getMessage());
		}

		
	/*	
		for(InputStream inputStream: inputStreamList ){
			System.out.println(inputStream);
		}
		for(Projection projection: projectionList ){
			System.out.println(projection);
		}		
		for(Join join: joinList ){
			System.out.println(join);
		}
		for(OutputStream outputStream: outputStreamList ){
			System.out.println(outputStream);
		}*/
		
		ArrayList<ArrayList<Elements>> deneme = new ArrayList<ArrayList<Elements>>(); 
		ArrayList<Elements> variable = (ArrayList<Elements>)(List<?>) inputStreamList; 
		ArrayList<Elements> variable2 = (ArrayList<Elements>)(List<?>) operationList;	
		ArrayList<Elements> variable3 = (ArrayList<Elements>)(List<?>) outputStreamList; 
		

		
		deneme.add(variable);
		deneme.add(variable2);
		deneme.add(variable3);
		

		return deneme;
}


	
}
