package lab02;

import javax.jws.WebParam;
import javax.jws.WebResult;

@javax.jws.WebService
public interface eshopIfce {

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