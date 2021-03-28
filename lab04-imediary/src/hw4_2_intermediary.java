

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
@WebServlet("/hw4_2_intermediary")
public class hw4_2_intermediary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		try {
			SOAPConnection soapc = SOAPConnectionFactory.newInstance().createConnection();
			QName tvik_qname = new QName("http://tviks.cz", "tvik");
			QName tvikt_qname = new QName("http://tviks.cz", "tvikt");
			String endpoint = "http://127.0.0.1:8000/eshopIfce";
			
			float discount = 0;
					
			SOAPMessage soapm = MessageFactory.newInstance().createMessage(new MimeHeaders(), request.getInputStream());
			SOAPHeader header = soapm.getSOAPHeader();
			
//			soapm.writeTo(System.out);
			
			// extract the 'tvik' element from soapheader
			if(header.hasChildNodes()) {
				Node n = header.getChildElements(tvik_qname).next();
				// get the applydiscount value
				String val = n.getAttributes().getNamedItem("applyDiscount").getNodeValue();
				discount = Float.parseFloat(val);
				header.removeChild(n);
			}
			else {
				System.out.println("no soap header");
			}
			
			// call eshop for total amount
			SOAPMessage eshop_response = soapc.call(soapm, endpoint);
			soapc.close();
			
			SOAPBody responseBody = eshop_response.getSOAPBody();
			if (responseBody.hasFault()) {
				System.out.println("intermediary recieved fault");
			    System.out.println(responseBody.getFault().getFaultString()); 
			} else {

				QName totalAmountResponseName = new QName("http://lab02/", "totalAmountResponse", "ns2");
				QName totalAmountResultName = new QName("http://lab02/", "total_amount", "ns2");
		
				
				// get the appropriate element where the total amount for the order is specified
				SOAPBodyElement totalAmountResponse = (SOAPBodyElement)
				       responseBody.getChildElements(totalAmountResponseName).next();
				SOAPBodyElement totalAmountResult = (SOAPBodyElement)
						totalAmountResponse.getChildElements().next();
		
		
				int ret = Integer.parseInt(totalAmountResult.getValue());
				
				
				// add new header where discount information is specified
				if(eshop_response.getSOAPHeader() != null) {
//					System.out.println("intermed nor null header");
					eshop_response.getSOAPHeader().addHeaderElement(tvikt_qname).addTextNode("discount " + discount*100 + "% applied. Without discount: " + ret);
				}
				else {
					SOAPHeader h = eshop_response.getSOAPPart().getEnvelope().addHeader();
					h.addHeaderElement(tvikt_qname).addTextNode("discount " + discount*100 + "% applied. Without discount: " + ret);
//					System.out.println("intermed header added");
				}
				
				// compute the new ottal amount
				ret = (int) Math.ceil(ret * (1-discount)); 
				totalAmountResult.setValue("" + ret);
				
//				eshop_response.writeTo(System.out);
//				System.out.println();
				
				// return the modified response
				eshop_response.writeTo(resp.getOutputStream());
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
