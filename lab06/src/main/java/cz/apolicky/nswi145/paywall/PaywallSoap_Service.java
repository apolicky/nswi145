/**
 * PaywallSoap_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.apolicky.nswi145.paywall;

public interface PaywallSoap_Service extends javax.xml.rpc.Service {
    public java.lang.String getPaywallSoapAddress();

    public cz.apolicky.nswi145.paywall.PaywallSoap_PortType getPaywallSoap() throws javax.xml.rpc.ServiceException;

    public cz.apolicky.nswi145.paywall.PaywallSoap_PortType getPaywallSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
