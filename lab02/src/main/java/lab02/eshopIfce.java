package lab02;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService( 
		name="EshopSoap",
		targetNamespace="http://apolicky.cz/nswi145/eshop",
		serviceName="EshopSoap",
		portName="EshopSoap")
public interface eshopIfce {

	@javax.jws.WebMethod
	@WebResult(name="add_success")
	public boolean addYoghurt(
			@WebParam(name="count")
			int count, 
			@WebParam(name="flavor_id")
			int flavor_id);
	
	@javax.jws.WebMethod
	@WebResult(targetNamespace="http://apolicky.cz/nswi145/eshop",name="total_amount")
	public int totalAmount(
			@WebParam(targetNamespace="http://apolicky.cz/nswi145/eshop",
				name="total_amount")
			int total_count);
	
	@javax.jws.WebMethod
	@WebResult(name="cancel_success")
	public boolean cancelOrder();
	
}