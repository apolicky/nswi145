package lab04;

import javax.xml.soap.*;
import javax.xml.namespace.*;

public class saaj {

	public static void main(String[] args) {
		task04();
	}
	
	private static void task03() {
		try {
			SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
			SOAPConnection soapc = soapcf.createConnection();

			MessageFactory mf = MessageFactory.newInstance();
			SOAPMessage soapm = mf.createMessage();
			    
			SOAPPart soapp = soapm.getSOAPPart();
			SOAPEnvelope soape = soapp.getEnvelope();
			SOAPBody soapb = soape.getBody();

			soape.getHeader().detachNode();
			QName name = new QName("http://tempuri.org/", "Add", "temp");
			SOAPElement soapel = soapb.addBodyElement(name);

			soapel.addChildElement(
			    new QName("http://tempuri.org/", "intA", "temp")).addTextNode("3");
			soapel.addChildElement(
			    new QName("http://tempuri.org/", "intB", "temp")).addTextNode("4");
			String endpoint = "http://www.dneonline.com/calculator.asmx";
			SOAPMessage response = soapc.call(soapm, endpoint);
			soapc.close();
			
			SOAPBody responseBody = response.getSOAPBody();
			if (responseBody.hasFault()) {
			    System.out.println(responseBody.getFault().getFaultString()); 
			} else {
			    
				QName AddResponseName = new QName("http://tempuri.org/", "AddResponse");
				QName AddResultName = new QName("http://tempuri.org/", "AddResult");
		
				SOAPBodyElement AddResponse = (SOAPBodyElement)
				       responseBody.getChildElements(AddResponseName).next();
				SOAPBodyElement AddResult = (SOAPBodyElement)
				       AddResponse.getChildElements(AddResultName).next();
		
				System.out.println(AddResult.getValue());
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void task04() {
		try {
			SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
			SOAPConnection soapc = soapcf.createConnection();

			MessageFactory mf = MessageFactory.newInstance();
			SOAPMessage soapm = mf.createMessage();
			    
			SOAPPart soapp = soapm.getSOAPPart();
			SOAPEnvelope soape = soapp.getEnvelope();
			SOAPBody soapb = soape.getBody();
 
			soape.getHeader().addHeaderElement(new QName("http://tweaks.com", "tweak")).addAttribute(new QName("multiplicationFactor"), "11");
			
			
			QName name = new QName("http://tempuri.org/", "Add", "temp");
			SOAPElement soapel = soapb.addBodyElement(name);

			soapel.addChildElement(
			    new QName("http://tempuri.org/", "intA", "temp")).addTextNode("3");
			soapel.addChildElement(
			    new QName("http://tempuri.org/", "intB", "temp")).addTextNode("4");
//			String endpoint = "http://www.dneonline.com/calculator.asmx";
			String endpoint = "http://localhost:8080/lab04-imediary/intermediary";
			
			
			System.out.print("task04: ");
			soapm.writeTo(System.out);
			
			
			SOAPMessage response = soapc.call(soapm, endpoint);
			soapc.close();
			
			SOAPBody responseBody = response.getSOAPBody();
			if (responseBody.hasFault()) {
			    System.out.println(responseBody.getFault().getFaultString()); 
			} else {
			    
				QName AddResponseName = new QName("http://tempuri.org/", "AddResponse");
				QName AddResultName = new QName("http://tempuri.org/", "AddResult");
		
				SOAPBodyElement AddResponse = (SOAPBodyElement)
				       responseBody.getChildElements(AddResponseName).next();
				SOAPBodyElement AddResult = (SOAPBodyElement)
				       AddResponse.getChildElements(AddResultName).next();
		
				System.out.println(AddResult.getValue());
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
