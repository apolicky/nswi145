
package task3.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.4.3
 * Sun Apr 11 12:25:43 CEST 2021
 * Generated source version: 3.4.3
 */

@XmlRootElement(name = "f2cResponse", namespace = "http://task3/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "f2cResponse", namespace = "http://task3/")

public class F2cResponse {

    @XmlElement(name = "return")
    private double _return;

    public double getReturn() {
        return this._return;
    }

    public void setReturn(double new_return)  {
        this._return = new_return;
    }

}

