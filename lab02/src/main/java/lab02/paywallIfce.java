package lab02;

import javax.jws.WebParam;
import javax.jws.WebResult;

@javax.jws.WebService(name="PaywallSoap",
		targetNamespace="http://apolicky.cz/nswi145/paywall",
		serviceName="PaywallSoap",
		portName="PaywallSoap")
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
	@WebResult(targetNamespace="http://apolicky.cz/nswi145/paywall",name="reciept_pdf")
	public String getReciept(
			@WebParam(targetNamespace="http://apolicky.cz/nswi145/paywall",name="success")
			boolean succ);
}