package hw8;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customer")
public class Customer {

	private String name;
	private String address;
	
	public Customer() {
		this.name = "Jimbo Undefined";
		this.address = "Carlton bvd 420";
	}
	public Customer(String name, String addr) {
		this.setName(name);
		this.setAddress(addr);
	}
	
	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}

