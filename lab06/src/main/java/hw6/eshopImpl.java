package hw6;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.juddi.v3.annotations.UDDIService;
import org.apache.juddi.v3.annotations.UDDIServiceBinding;

import java.util.Random;



@UDDIService(
		businessKey="uddi:apolicky.cz:l06t01",
		serviceKey="uddi:${keyDomain}:services-eshop${department}", 
		description = "Yoghurt eshop service")
@UDDIServiceBinding(
		bindingKey="uddi:${keyDomain}:${serverName}-${serverPort}-eshop${department}-wsdl",
	    description="WSDL endpoint for the eshop${department} Service. This service is used for "
				  + "selling yoghurts",
	    accessPointType="wsdlDeployment",
	    accessPoint="http://${serverName}:${serverPort}/lab06/services/eshop?wsdl")
@WebService(endpointInterface = "hw6.eshopInterface",
			targetNamespace="http://apolicky.cz/nswi145/hw6/yoghurtEshop",
			portName = "EshopImplPort",
			serviceName = "EshopImplService")
public class eshopImpl implements eshopInterface {
	
	/**
	 * randomly returns boolean value representing whether order of 'count' yoghurts can be done.
	 */
	@WebResult(name="add_success")
	public boolean addYoghurt(
			@WebParam(name="count") int count, 
			@WebParam(name="flavor_id") int flavor_id) {
		return true;
		
	}

	@WebResult(name="total_amount")
	public int totalAmount(@WebParam(name="total_amount") int total_count) {
		
		return total_count * 29;
		
	}
	
	@WebResult(name="cancel_success")
	public boolean cancelOrder() {
		return true;
		
	}
}