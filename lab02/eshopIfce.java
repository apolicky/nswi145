package lab02;

@javax.jws.WebService
public interface eshopIfce {

	@javax.jws.WebMethod
	public boolean orderYoghurt(int count);

}
