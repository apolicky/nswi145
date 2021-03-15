package blorb;

import java.util.Random;

@javax.jws.WebService
public interface eshopIfce {
	
	public static final Random r = new Random();
	
	@javax.jws.WebMethod
	public boolean orderYoghurt(int count);
	
}