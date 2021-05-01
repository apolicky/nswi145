package lab08;

import java.util.*;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.xml.bind.JAXBElement;

@Path("/contact-list")
public class ContactResource {
	@Context
	UriInfo uriinfo;
	
	private static Map<Integer, Contact> contacts = new HashMap<Integer, Contact>();

	public ContactResource() {
		contacts.put(1, new Contact(1, "Jane Doe", "jane.doe@yahoo.com"));
	    contacts.put(2, new Contact(2, "John Doe", "john.doe@yahoo.com"));
	}
	
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{contact}")
    public Contact getContact(
    	@PathParam("contact") String contactID) {
    		return contacts.get(Integer.parseInt(contactID));
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{contact}")
    public Response putContact(
    	@PathParam("contact") String contactID, JAXBElement<Contact> contact) {
    	Contact c = contact.getValue();
    	
    	Response r;
    	
    	try {
    		if(Integer.parseInt(contactID) != c.getID()) {
    			r = Response.status(Response.Status.CONFLICT)
		       	         .entity("Numbers don't match").build();
    			return r;
        	}
    	}
    	catch(Exception e) {
    		r = Response.status(Response.Status.NOT_ACCEPTABLE)
    				.entity("Non integer id").build();
    	}
    	
    	if(contacts.containsKey(c.getID())) {
    		r = Response.status(Response.Status.NO_CONTENT)
    				.entity("Contact " + c.getID() + " modified").build();
    	}
    	else {
    		r = Response.created(uriinfo.getAbsolutePath()).build();
    	}
    	contacts.put(c.getID(), c);
        
    	
    	return r;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, 
    	MediaType.APPLICATION_JSON})
    public List<Contact> getContacts() {
		List<Contact> ret = new ArrayList<>();
		ret.addAll(contacts.values());
		System.out.println("getcontatcts");
		for(Contact c : ret) {
			System.out.println(c.getFullname());
		}
    	return ret;
    }
}