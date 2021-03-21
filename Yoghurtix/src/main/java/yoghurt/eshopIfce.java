package yoghurt;


@javax.jws.WebService
public interface eshopIfce {

	@javax.jws.WebMethod
	public boolean addYoghurt(int count, int flavor_id);
	
	@javax.jws.WebMethod
	public int totalAmount(int total_count);
	
	@javax.jws.WebMethod
	public boolean cancelOrder();
	
}