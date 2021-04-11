package hw5;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@javax.jws.WebService(targetNamespace="http://apolicky.cz/nswi145/yoghurtEshop")
public interface eshopInterface {

	@javax.jws.WebMethod
	@WebResult(name="add_success")
	public boolean addYoghurt(
			@WebParam(name="count")
			int count, 
			@WebParam(name="flavor_id")
			int flavor_id);
	
	@javax.jws.WebMethod
	@WebResult(name="total_amount")
	public int totalAmount(
			@WebParam(name="total_amount")
			int total_count);
	
	@javax.jws.WebMethod
	@WebResult(name="cancel_success")
	public boolean cancelOrder();
	
}