package blorb;

import javax.jws.WebService;

@WebService(endpointInterface = "blorb.eshopIfce")
public class eshopImpl implements eshopIfce {
	
	/**
	 * returns true if the order of 'count' yoghurts can be done
	 */
	public boolean orderYoghurt(int count) {
		this.r.setSeed(count);
		return this.r.nextBoolean();
	}
}
