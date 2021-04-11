
package cz.apolicky.nswi145.yoghurteshop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for addYoghurtResponse complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="addYoghurtResponse"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="add_success" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addYoghurtResponse", propOrder = {
    "addSuccess"
})
public class AddYoghurtResponse {

    @XmlElement(name = "add_success")
    protected boolean addSuccess;

    /**
     * Gets the value of the addSuccess property.
     * 
     */
    public boolean isAddSuccess() {
        return addSuccess;
    }

    /**
     * Sets the value of the addSuccess property.
     * 
     */
    public void setAddSuccess(boolean value) {
        this.addSuccess = value;
    }

}
