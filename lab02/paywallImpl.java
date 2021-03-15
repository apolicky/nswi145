package lab02;

import javax.jws.WebService;

@WebService(endpointInterface = "lab02.paywallIfce")
public class paywallImpl implements paywallIfce {

	/**
	 * returns new account_balance > 0 or -1 if the balance is insufficient
	 */
	public int pay(int account_balance, int amount) {
		if (account_balance >= amount) {
			return account_balance - amount;
		}
		else {
			return -1;
		}
	
	}

}
