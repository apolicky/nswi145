package hw8;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name="orderSummary")
public class Summary {
	
	private Customer c;
	private List<Yoghurt> yoghs;
	
	public Summary() {
		this.setCustomer(new Customer());
		this.setYoghs(new ArrayList<>());
	}
	public Summary(Customer c, List<Yoghurt> yoghs) {
		this.setCustomer(c);
		this.setYoghs(yoghs);
	}
	
	@XmlElement(name="customer")
	public Customer getCustomer() {
		return c;
	}
	public void setCustomer(Customer c) {
		this.c = c;
	}
	
	@XmlElement(name="yoghurts")
	public List<Yoghurt> getYoghs() {
		return yoghs;
	}
	public void setYoghs(List<Yoghurt> yoghs) {
		this.yoghs = yoghs;
	}
	
	

}
