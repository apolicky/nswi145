package hw8;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="yoghurt")
public class Yoghurt {

	private int flavorID;
	private int price = 29;
	
	public Yoghurt() {
		
	}
	
	public Yoghurt(int flavor) {
		flavorID = flavor;
	}

	@XmlElement(name="price")
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@XmlElement(name="flavor")
	public int getFlavorID() {
		return flavorID;
	}

	public void setFlavorID(int flavorID) {
		this.flavorID = flavorID;
	}
	
	
}
