
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

@XmlRootElement(name = "f2c", namespace = "http://task3/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "f2c", namespace = "http://task3/")

public class F2c {

    @XmlElement(name = "arg0")
    private double arg0;

    public double getArg0() {
        return this.arg0;
    }

    public void setArg0(double newArg0)  {
        this.arg0 = newArg0;
    }

}

