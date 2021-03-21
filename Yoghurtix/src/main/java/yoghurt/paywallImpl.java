package yoghurt;


import javax.jws.WebService;

@WebService(endpointInterface = "yoghurt.paywallIfce")
public class paywallImpl implements paywallIfce {

	/**
	 * returns new account_balance > 0 or -1 if the balance is insufficient
	 */
	public int pay(int account_balance, int amount) {
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

	public String getReciept() {
		System.out.println("getReciptCalled");
		System.out.println("   returning " + "somthing");
		return "Payment details: XY\n"
				+ "dnk asdfk ZY\n"
				+ "Best regards, Yoghurt inc.";
	}

	public void fillCredentials(String name, int card_id, int expir_date) {
		// payment is being processed
		System.out.println("fillCredsCalled");
		return;
	}

}