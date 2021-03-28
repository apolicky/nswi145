package lab02;

import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.WebParam;

@WebService(endpointInterface = "lab02.paywallIfce")
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

	@WebResult(name="reciept_pdf")
	public String getReciept() {
		System.out.println("getReciptCalled");
		System.out.println("   returning " + "somthing");
		return "Payment details: XY\n"
				+ "dnk asdfk ZY\n"
				+ "Best regards, Yoghurt inc.";
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
