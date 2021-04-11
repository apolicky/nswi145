
package cz.apolicky.nswi145.yoghurteshop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for cancelOrderResponse complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="cancelOrderResponse"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="cancel_success" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelOrderResponse", propOrder = {
    "cancelSuccess"
})
public class CancelOrderResponse {

    @XmlElement(name = "cancel_success")
    protected boolean cancelSuccess;

    /**
     * Gets the value of the cancelSuccess property.
     * 
     */
    public boolean isCancelSuccess() {
        return cancelSuccess;
    }

    /**
     * Sets the value of the cancelSuccess property.
     * 
     */
    public void setCancelSuccess(boolean value) {
        this.cancelSuccess = value;
    }

}
