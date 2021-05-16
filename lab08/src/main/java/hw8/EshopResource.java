package hw8;

import java.util.*;
import java.util.Map.Entry;

import javafx.util.*;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.xml.bind.JAXBElement;
import lab08.Contact;

@Path("/eshop")
public class EshopResource {
	
	@Context
	UriInfo uriinfo;
	
	private static int i = 0;
	private static Map<Integer,Order> orders = new HashMap<>();
	private static Map<Integer,Customer> customers = new HashMap<>();
	private static Set<Integer> customerHashes = new HashSet<>();
	
	public EshopResource() {}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/shopping-cart/{id}/add")
//	@Path("/shopping-cart/{id}/add/{count}")	
	public Response addYoghurt(
			@PathParam("id") String orderId,
//			@PathParam("count") String count,
			JAXBElement<YoghurtOrder> yoghurtOrder) {
		
		Response r;
		int id;
//		int cnt = 0;
//    	try {
//    		cnt = Integer.parseInt(count);
//    	}
//    	catch(Exception e) {
//    		r = Response.status(Response.Status.NOT_ACCEPTABLE)
//    				.entity("Non integer flavor id").build();
//    		return r;
//    		
//    	}
    	
    	
    	try {
    		id = Integer.parseInt(orderId);
    	}
    	catch(Exception e){
    		r = Response.status(Response.Status.BAD_REQUEST).entity("Invalid id").build();
    		return r;
    	}
    	
    	if(!customers.containsKey(id)) {
    		return Response.status(Response.Status.NOT_FOUND).entity(
    				"Unknown order|customer id "+ id+". Create new order including customer on '/eshop/customer'").build();
    	}
    	
    	if(!orders.containsKey(id)) {
    		orders.put(id, new Order());
    	}
    	 
    	int flvr = yoghurtOrder.getValue().getFlavorID();
		for(int i = 0; i < yoghurtOrder.getValue().getCount(); i++)
			orders.get(id).addYoghurt(flvr);
		
		return Response.status(Response.Status.OK)
				.entity(yoghurtOrder.getValue().getCount() + " yoghurts with flavor " + flvr + " added to cart.").build();
    	
    	
//    	if(cnt == yoghurt.getValue().getCount()) {
//    		int flvr = yoghurt.getValue().getFlavorID();
//    		for(int i = 0; i < cnt; i++)
//    			o.addYoghurt(flvr);
//    		
//    		r = Response.ok(uriinfo.getAbsolutePath())
//    				.entity(cnt + " yoghurts with flavor " + flvr + " added to cart.").build();
//    	}
//    	else {
//    		r = Response.status(Response.Status.NOT_ACCEPTABLE)
//    				.entity("Count must be int").build();
//    	}
//    	    	
//    	return r;
	}
	
	@GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/shopping-cart/{id}")
	public Summary cart(
			@PathParam("id") String orderId) {
		int id;
		System.out.println("shopping cart request");
		try{
			id = Integer.parseInt(orderId);		
			
			if(orders.containsKey(id)) {
				return new Summary(customers.get(id),orders.get(id).getYoghurts());
			}
			else {
				throw new WebApplicationException();
			}
		}
		catch(Exception e) {
			throw new WebApplicationException();
		}
//		return new Summary(new Customer(), new Order().getYoghurts());
		
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/total-amount/{id}")
	public int totalAmount(
			@PathParam("id") String orderId) {
		
		int sum = 0;
		for(Yoghurt y : orders.get(Integer.parseInt(orderId)).getYoghurts()) {
			sum += y.getPrice();
		}
		return sum;
	}
	
	@DELETE
    @Produces(MediaType.TEXT_PLAIN)
	@Path("/shopping-cart/{id}")
	public Response cancelOrder(
			@PathParam("id") String orderId) {
		
		int id = Integer.parseInt(orderId);
		orders.remove(Integer.parseInt(orderId));
		
		Response r;
		r = Response.status(Response.Status.OK).entity("Order " + id + " canceled").build();
		return r;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/customer")
	public Response addCustomer(
			JAXBElement<Customer> cust) {
		
		Customer cstr = cust.getValue();
		
		System.out.println("recieved customer: (" + cstr.getName() + ","+cstr.getAddress()+")");
		
		if(customerHashes.contains(customerHash(cstr))) {
			System.out.println("recieved customer: (" + cstr.getName() + ","+cstr.getAddress()+") in customers");
			int id = -1;
			for (Entry<Integer, Customer> entry : customers.entrySet()) {
		        if (entry.getValue().getName().equals(cstr.getName()) && entry.getValue().getAddress().equals(cstr.getAddress())) {
		            id = entry.getKey();
		            break;
		        }
		    }			
			
			return Response.status(Response.Status.OK).entity("Customer " + customers.get(id).getName() + " has id " +id + ".").build();
		}
		else {
			System.out.println("recieved customer: (" + cstr.getName() + ","+cstr.getAddress()+") NOT in custormers");
			System.out.println("	there are:");
			for(Entry<Integer,Customer> c : customers.entrySet()) {
				System.out.println("		(" + c.getValue().getName() + ","+ c.getValue().getAddress()+")");
			}
		}
		
		int id = ++i; 
		customers.put(id, cstr); 
		orders.put(id, new Order());
		customerHashes.add(customerHash(cstr));
		
		Response r = Response.status(Response.Status.OK).entity("New customer " + customers.get(id).getName() + " with id " +id + " added.").build();
		return r;
		
	}
	
	private int customerHash(Customer c) {
		return (c.getName() + c.getAddress()).hashCode();
	}
	

}
