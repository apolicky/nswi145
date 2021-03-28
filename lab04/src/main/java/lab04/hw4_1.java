package lab04;

import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class hw4_1 {
	
	public static void main(String[] args) {
		hw4();
	}
	
	
	private static void hw4() {
		try {

			SOAPConnection soapc = SOAPConnectionFactory.newInstance().createConnection();
			SOAPMessage soapm = MessageFactory.newInstance().createMessage();
			    
			SOAPPart soapp = soapm.getSOAPPart();
			SOAPEnvelope soape = soapp.getEnvelope();
			SOAPBody soapb = soape.getBody();

			soape.getHeader().addHeaderElement(new QName("http://tviks.cz", "tvik")).addAttribute(new QName("applyDiscount"), "0.2");
			QName name = new QName("http://lab02/", "totalAmount","tns");
			SOAPElement soapel = soapb.addBodyElement(name);

			soapel.addChildElement(
			    new QName("total_amount")).addTextNode("5");
			String endpoint = "http://127.0.0.1:8000/eshopIfce";
			
			soapm.writeTo(System.out);
			System.out.println();
			
			
			SOAPMessage response = soapc.call(soapm, endpoint);
			soapc.close();
			
			SOAPBody responseBody = response.getSOAPBody();
			if (responseBody.hasFault()) {
			    System.out.println(responseBody.getFault().getFaultString()); 
			} else {
			    
				QName totalAmountResponseName = new QName("http://lab02/", "totalAmountResponse", "ns2");
				QName totalAmountResultName = new QName("http://lab02/", "total_amount", "ns2");
		
				SOAPBodyElement totalAmountResponse = (SOAPBodyElement)
				       responseBody.getChildElements(totalAmountResponseName).next();
			
				
				SOAPBodyElement totalAmountResult = (SOAPBodyElement)
						totalAmountResponse.getChildElements().next();
		
				System.out.println(totalAmountResult.getValue());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
