

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.*;

/**
 * Servlet implementation class intermediary
 */
@WebServlet("/intermediary")
public class intermediary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("intermed: " + request.toString());
		
		askForResponse(request, response);
	}
	
	private void askForResponse(HttpServletRequest r, HttpServletResponse resp) {
		try {
			SOAPConnection soapc = SOAPConnectionFactory.newInstance().createConnection();
			String endpoint = "http://www.dneonline.com/calculator.asmx";
			
			int multifactor = 0;
					
			SOAPMessage soapm = MessageFactory.newInstance().createMessage(new MimeHeaders(), r.getInputStream());
			
			System.out.println("intermed has soapm.");
			
			if(soapm.getSOAPHeader().hasChildNodes()) {
				System.out.println("intermed: soapm has header ");
				Iterator<Node> it = soapm.getSOAPHeader().getChildElements();
				while(it.hasNext()) {
					Node n = it.next();
					if(n.getNodeName() == "tweak") {
						System.out.println("intermed: has tweak header");
						String val = n.getAttributes().getNamedItem("multiplicationFactor").getNodeValue();
						System.out.println("intermed val: " + val);
						multifactor = Integer.parseInt(val);
					}
				}
				
			}
			
			
			SOAPMessage response = soapc.call(soapm, endpoint);
			System.out.println("intermed has response");
			soapc.close();
			
			SOAPBody responseBody = response.getSOAPBody();
			if (responseBody.hasFault()) {
				System.out.println("intermed recieved fault");
			    System.out.println(responseBody.getFault().getFaultString()); 
			} else {
				System.out.println("intermed no fault");
				QName AddResponseName = new QName("http://tempuri.org/", "AddResponse");
				QName AddResultName = new QName("http://tempuri.org/", "AddResult");
		
				SOAPBodyElement AddResponse = (SOAPBodyElement)
				       responseBody.getChildElements(AddResponseName).next();
				SOAPBodyElement AddResult = (SOAPBodyElement)
				       AddResponse.getChildElements(AddResultName).next();
		
				int ret = Integer.parseInt(AddResult.getValue()); // .toInt(AddResult.getValue());
				System.out.println("intermed: parsed value:" + ret);
				
				if(response.getSOAPHeader() != null) {
					System.out.println("intermed nor null header");
					response.getSOAPHeader().addHeaderElement(new QName("http://tweaks.com/","tweaked")).addTextNode("multiplied by:" + multifactor);
				}
				else {
					SOAPHeader h = response.getSOAPPart().getEnvelope().addHeader();
					h.addHeaderElement(new QName("http://tweaks.com/","tweaked")).addTextNode("multiplied by:" + multifactor);
					System.out.println("intermed header added");
				}
				
				
//				resp.writeTo();
				
				ret = Integer.parseInt(AddResult.getValue()) * multifactor; // .toInt(AddResult.getValue());
				AddResult.setValue("" + ret);
				System.out.println("intermed addresult value: " + AddResult.getValue());
				
				response.writeTo(System.out);
				System.out.println();
				response.writeTo(resp.getOutputStream());
				System.out.println("intermed resp.writeTo called");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
