package blorb;

import javax.jws.WebService;

@WebService(endpointInterface = "blorb.paywallIfce")
public class paywallImpl implements paywallIfce{
	
	/**
	 * returns new account balance > 0, or -1 if account_balance < amount
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
