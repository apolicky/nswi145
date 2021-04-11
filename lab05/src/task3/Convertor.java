package task3;

import javax.jws.WebService;

@javax.jws.WebService(targetNamespace="http://task3/")
public interface Convertor {

	@javax.jws.WebMethod
	public double f2c(double fahrenheit);
	
}