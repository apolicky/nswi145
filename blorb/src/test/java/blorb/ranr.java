package blorb;

import javax.xml.ws.Endpoint;

public class ranr {

	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:8000/eshopIfce", new eshopImpl());
		Endpoint.publish("http://127.0.0.1:8001/paywallIfce", new paywallImpl());
	}
	
}
