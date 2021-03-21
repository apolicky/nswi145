package yoghurt;

@javax.jws.WebService
public interface paywallIfce {

	@javax.jws.WebMethod
	public int pay(int account_balance, int amount);

	@javax.jws.WebMethod
	public void fillCredentials(String name, int card_id, int expir_date);
	
	@javax.jws.WebMethod
	public String getReciept();
}