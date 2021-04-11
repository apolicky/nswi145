package hw5;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Random;

@WebService(endpointInterface = "hw5.eshopInterface",
			targetNamespace="http://apolicky.cz/nswi145/yoghurtEshop",
			portName = "EshopImplPort",
			serviceName = "EshopImplService")
public class eshopImpl implements eshopInterface {

	private int yoghurt_price = 29;
	
	/**
	 * randomly returns boolean value representing whether order of 'count' yoghurts can be done.
	 */
	@WebResult(name="add_success")
	public boolean addYoghurt(
			@WebParam(name="count") int count, 
			@WebParam(name="flavor_id") int flavor_id) {
		
		System.out.println("addYoghurtCalled");
		Random r = new Random();
		r.setSeed(count + 69420*flavor_id);
		return r.nextBoolean();
		
	}

	@WebResult(name="total_amount")
	public int totalAmount(@WebParam(name="total_amount") int total_count) {
		
		System.out.println("totalAmountCalled, total_count: " + total_count + " yogprice: " + this.yoghurt_price);
		System.out.println("   returning " + total_count * this.yoghurt_price);
		return total_count * this.yoghurt_price;
		
	}
	
	@WebResult(name="cancel_success")
	public boolean cancelOrder() {
		
		System.out.println("cancelCalled");
		return true;
		
	}
}