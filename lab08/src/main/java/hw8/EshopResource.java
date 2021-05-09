package hw8;

import java.util.*;
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
	private static Order o = new Order();
	private static Customer c = new Customer();
	
	public EshopResource() {}
			
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{count}")
	public Response addYoghurt(
			@PathParam("count") String count, JAXBElement<YoghurtOrder> yoghurt) {
		
		Response r;
		int cnt = 0;
    	try {
    		cnt = Integer.parseInt(count);
    	}
    	catch(Exception e) {
    		r = Response.status(Response.Status.NOT_ACCEPTABLE)
    				.entity("Non integer flavor id").build();
    		return r;
    		
    	}
    	 
    	if(cnt == yoghurt.getValue().getCount()) {
    		int flvr = yoghurt.getValue().getFlavorID();
    		for(int i = 0; i < cnt; i++)
    			o.addYoghurt(flvr);
    		
    		r = Response.created(uriinfo.getAbsolutePath())
    				.entity(cnt + " yoghurts with flavor " + flvr + " added to cart.").build();
    	}
    	else {
    		r = Response.status(Response.Status.NOT_ACCEPTABLE)
    				.entity("Count must be int").build();
    	}
    	    	
    	return r;
	}
	
	@GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Summary cart() {
		return new Summary(c,o.getYoghurts());
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/totalAmount")
	public int totalAmount() {
		
		int i = 0;
		for(Yoghurt y : o.getYoghurts()) {
			i += y.getPrice();
		}
		return i;
	}
	
	@DELETE
    @Produces(MediaType.TEXT_PLAIN)
	public Response cancelOrder() {
		System.out.println("cancel called");
		o = new Order();
		Response r;
		r = Response.status(Response.Status.OK).entity("Order canceled").build();
		return r;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/customer")
	public Response setCustomer(
			JAXBElement<Customer> cust) {
		Customer cstr = cust.getValue();
		this.c = cstr; 
		Response r = Response.status(Response.Status.OK).entity("Customer changed to " + this.c.getName()).build();
		return r;
		
	}
	

}
