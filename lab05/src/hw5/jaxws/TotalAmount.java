
package hw5.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.4.3
 * Sun Apr 11 14:34:05 CEST 2021
 * Generated source version: 3.4.3
 */

@XmlRootElement(name = "totalAmount", namespace = "http://apolicky.cz/nswi145/yoghurtEshop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "totalAmount", namespace = "http://apolicky.cz/nswi145/yoghurtEshop")

public class TotalAmount {

    @XmlElement(name = "total_amount")
    private int total_amount;

    public int getTotal_amount() {
        return this.total_amount;
    }

    public void setTotal_amount(int newTotal_amount)  {
        this.total_amount = newTotal_amount;
    }

}

