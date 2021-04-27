package lab02;

import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.WebParam;

@WebService(name="PaywallSoap",
		endpointInterface = "lab02.paywallIfce",
targetNamespace="http://apolicky.cz/nswi145/paywall",
serviceName="PaywallSoap",
portName="PaywallSoap")
public class paywallImpl implements paywallIfce {

	/**
	 * returns new account_balance > 0 or -1 if the balance is insufficient
	 */
	@WebResult(name="new_balance_OR_failed_payment")
	public int pay(
			@WebParam(name="account_balance")
			int account_balance,
			@WebParam(name="amount")
			int amount) {
		System.out.println("payCalled, balance: " + account_balance + " amount: " + amount);
		if (account_balance >= amount) {
			System.out.println("   returning " + (account_balance - amount));
			return account_balance - amount;
		}
		else {
			System.out.println("   returning " + (-1));
			return -1;
		}
	
	}

	@WebResult(targetNamespace="http://apolicky.cz/nswi145/paywall",name="reciept_pdf")
	public String getReciept(
			@WebParam(targetNamespace="http://apolicky.cz/nswi145/paywall",name="success")
			boolean succ) {
		System.out.println("Recieved: " + succ);
		return succ ? "Payment details:\n"
				+ "you just bought some great yoghurts\n"
				+ "Best regards, Yoghurt inc." 
				
				:
					
				"Payment details:\n" +
				"you did not have enough money to buy great yoghurts.\n" +
				"Best regards, Yoghurt inc.";
	}

	public void fillCredentials(
			@WebParam(name="card_owner")
			String name, 
			@WebParam(name="card_id")
			int card_id,
			@WebParam(name="expir_date")
			int expir_date) {
		// payment is being processed
		System.out.println("fillCredsCalled");
		return;
	}

}
