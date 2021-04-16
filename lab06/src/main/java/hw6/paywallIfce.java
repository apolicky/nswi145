package hw6;

import javax.jws.WebParam;
import javax.jws.WebResult;

@javax.jws.WebService(targetNamespace="http://apolicky.cz/nswi145/hw6/paywall")
public interface paywallIfce {

	@javax.jws.WebMethod
	@WebResult(name="new_balance_OR_failed_payment")
	public int pay(
		@WebParam(name="account_balance")
		int account_balance,
		@WebParam(name="amount")
		int amount);

	@javax.jws.WebMethod
	public void fillCredentials(
			@WebParam(name="card_owner")
			String name, 
			@WebParam(name="card_id")
			int card_id,
			@WebParam(name="expir_date")
			int expir_date);
	
	@javax.jws.WebMethod
	@WebResult(name="reciept_pdf")
	public String getReciept();
}