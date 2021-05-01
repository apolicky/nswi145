package hw8;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="yoghurtOrder")
public class YoghurtOrder {
	
	private int count;
	private int flavorID;
	
	public YoghurtOrder() {
		
	}
	
	public YoghurtOrder(int count, int flavor) {
		this.setCount(count);
		this.setFlavorID(flavor);
	}

	@XmlElement(name="count")
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name="flavorID")
	public int getFlavorID() {
		return flavorID;
	}

	public void setFlavorID(int flavorID) {
		this.flavorID = flavorID;
	}
	

}
