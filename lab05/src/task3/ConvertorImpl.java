package task3;

import javax.jws.WebService;

@WebService(targetNamespace = "http://task3/", endpointInterface = "task3.Convertor", portName = "ConvertorImplPort", serviceName = "ConvertorImplService")
public class ConvertorImpl implements Convertor {

	
	// remove wsdl and task2.jaxws folders
	// create web service with sei convertor
	// uncheck annotations
	// generate wsdl without separate xsd
	
	@javax.jws.WebMethod(operationName="f2c")
	public double f2c(double fahrenheit) {
		return (fahrenheit - 32) * 5 /9;
	}

}
