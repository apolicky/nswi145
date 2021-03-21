package yoghurt;

import javax.jws.WebService;
import java.util.Random;

@WebService(endpointInterface = "yoghurt.eshopIfce")
public class eshopImpl implements eshopIfce {

	private int yoghurt_price = 29;
	
	/**
	 * randomly returns boolean value representing whether order of 'count' yoghurts can be done.
	 */
	public boolean addYoghurt(int count, int flavor_id) {
		System.out.println("addYoghurtCalled");
		Random r = new Random();
		r.setSeed(count + 69420*flavor_id);
		return r.nextBoolean();
	}

	public int totalAmount(int total_count) {
		System.out.println("totalAmountCalled, total_count: " + total_count + " yogprice: " + this.yoghurt_price);
		System.out.println("   returning " + total_count * this.yoghurt_price);
		return total_count * this.yoghurt_price;
	}

	public boolean cancelOrder() {
		System.out.println("cancelCalled");
		return true;
	}
}