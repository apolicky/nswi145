package hw6;

import javax.jws.WebService;

import org.apache.juddi.v3.annotations.UDDIService;
import org.apache.juddi.v3.annotations.UDDIServiceBinding;

import javax.jws.WebResult;
import javax.jws.WebParam;


@UDDIService(
		businessKey="uddi:apolicky.cz:l06t01",
		serviceKey="uddi:${keyDomain}:services-paywall${department}", 
		description = "Paywall service")
@UDDIServiceBinding(
		bindingKey="uddi:${keyDomain}:${serverName}-${serverPort}-paywall${department}-wsdl",
	    description="WSDL endpoint for the paywall${department} Service. This service is used for "
				  + "paywall of yoghtrt eshop",
	    accessPointType="wsdlDeployment",
	    accessPoint="http://${serverName}:${serverPort}/lab06/services/paywall?wsdl")
@WebService(endpointInterface = "hw6.paywallIfce",
			targetNamespace="http://apolicky.cz/nswi145/hw6/paywall",
			portName = "PaywallImplPort",
			serviceName = "PaywallImplService")
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
			return account_balance - amount;
		}
		else {
			return -1;
		}
	
	}

	@WebResult(name="reciept_pdf")
	public String getReciept() {
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
		
		return;
	}

}
