
package cz.apolicky.nswi145.yoghurteshop;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cz.apolicky.nswi145.yoghurteshop package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddYoghurt_QNAME = new QName("http://apolicky.cz/nswi145/yoghurtEshop", "addYoghurt");
    private final static QName _AddYoghurtResponse_QNAME = new QName("http://apolicky.cz/nswi145/yoghurtEshop", "addYoghurtResponse");
    private final static QName _CancelOrder_QNAME = new QName("http://apolicky.cz/nswi145/yoghurtEshop", "cancelOrder");
    private final static QName _CancelOrderResponse_QNAME = new QName("http://apolicky.cz/nswi145/yoghurtEshop", "cancelOrderResponse");
    private final static QName _TotalAmount_QNAME = new QName("http://apolicky.cz/nswi145/yoghurtEshop", "totalAmount");
    private final static QName _TotalAmountResponse_QNAME = new QName("http://apolicky.cz/nswi145/yoghurtEshop", "totalAmountResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cz.apolicky.nswi145.yoghurteshop
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddYoghurt }
     * 
     */
    public AddYoghurt createAddYoghurt() {
        return new AddYoghurt();
    }

    /**
     * Create an instance of {@link AddYoghurtResponse }
     * 
     */
    public AddYoghurtResponse createAddYoghurtResponse() {
        return new AddYoghurtResponse();
    }

    /**
     * Create an instance of {@link CancelOrder }
     * 
     */
    public CancelOrder createCancelOrder() {
        return new CancelOrder();
    }

    /**
     * Create an instance of {@link CancelOrderResponse }
     * 
     */
    public CancelOrderResponse createCancelOrderResponse() {
        return new CancelOrderResponse();
    }

    /**
     * Create an instance of {@link TotalAmount }
     * 
     */
    public TotalAmount createTotalAmount() {
        return new TotalAmount();
    }

    /**
     * Create an instance of {@link TotalAmountResponse }
     * 
     */
    public TotalAmountResponse createTotalAmountResponse() {
        return new TotalAmountResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddYoghurt }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddYoghurt }{@code >}
     */
    @XmlElementDecl(namespace = "http://apolicky.cz/nswi145/yoghurtEshop", name = "addYoghurt")
    public JAXBElement<AddYoghurt> createAddYoghurt(AddYoghurt value) {
        return new JAXBElement<AddYoghurt>(_AddYoghurt_QNAME, AddYoghurt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddYoghurtResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddYoghurtResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://apolicky.cz/nswi145/yoghurtEshop", name = "addYoghurtResponse")
    public JAXBElement<AddYoghurtResponse> createAddYoghurtResponse(AddYoghurtResponse value) {
        return new JAXBElement<AddYoghurtResponse>(_AddYoghurtResponse_QNAME, AddYoghurtResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelOrder }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelOrder }{@code >}
     */
    @XmlElementDecl(namespace = "http://apolicky.cz/nswi145/yoghurtEshop", name = "cancelOrder")
    public JAXBElement<CancelOrder> createCancelOrder(CancelOrder value) {
        return new JAXBElement<CancelOrder>(_CancelOrder_QNAME, CancelOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelOrderResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelOrderResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://apolicky.cz/nswi145/yoghurtEshop", name = "cancelOrderResponse")
    public JAXBElement<CancelOrderResponse> createCancelOrderResponse(CancelOrderResponse value) {
        return new JAXBElement<CancelOrderResponse>(_CancelOrderResponse_QNAME, CancelOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TotalAmount }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TotalAmount }{@code >}
     */
    @XmlElementDecl(namespace = "http://apolicky.cz/nswi145/yoghurtEshop", name = "totalAmount")
    public JAXBElement<TotalAmount> createTotalAmount(TotalAmount value) {
        return new JAXBElement<TotalAmount>(_TotalAmount_QNAME, TotalAmount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TotalAmountResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TotalAmountResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://apolicky.cz/nswi145/yoghurtEshop", name = "totalAmountResponse")
    public JAXBElement<TotalAmountResponse> createTotalAmountResponse(TotalAmountResponse value) {
        return new JAXBElement<TotalAmountResponse>(_TotalAmountResponse_QNAME, TotalAmountResponse.class, null, value);
    }

}
