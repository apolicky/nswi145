package blorb;

@javax.jws.WebService
public interface paywallIfce {

	@javax.jws.WebMethod
	public int pay(int account_balance, int amount);
	
}
