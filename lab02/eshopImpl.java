package lab02;

import javax.jws.WebService;
import java.util.Random;

@WebService(endpointInterface = "lab02.eshopIfce")
public class eshopImpl implements eshopIfce {

	/**
	 * randomly returns boolean value representing whether order of 'count' yoghurts can be done.
	 */
	public boolean orderYoghurt(int count){
		Random r = new Random();
		r.setSeed(count);
		return r.nextBoolean();
	}
}
