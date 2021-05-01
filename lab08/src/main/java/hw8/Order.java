package hw8;

import java.util.ArrayList;
import java.util.List;


public class Order {
	private List<Yoghurt> yoghs = new ArrayList<>();
	
	public Order() {
		
	}
	
	public Order(List<Yoghurt> _yoghs) {
		yoghs = _yoghs;
	}
	
	public void addYoghurt(int flavorId) {
		yoghs.add(new Yoghurt(flavorId));
	}
	
	public List<Yoghurt> getYoghurts(){
		return this.yoghs;
	}
	
}
