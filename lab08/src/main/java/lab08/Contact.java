package lab08;

import jakarta.xml.bind.annotation.*;

@XmlRootElement
public class Contact {
	
	private int ID;
	private String fullname;
	private String email;
	
	public Contact() {
		
	}
	
	public Contact(int id, String fullname, String email) {
		this.ID = id;
		this.fullname = fullname;
		this.email = email;
	}
	
	@XmlElement(name="id")
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}

	@XmlElement(name="fullname")
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@XmlElement(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
