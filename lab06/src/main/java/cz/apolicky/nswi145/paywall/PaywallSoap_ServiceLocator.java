/**
 * PaywallSoap_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.apolicky.nswi145.paywall;

public class PaywallSoap_ServiceLocator extends org.apache.axis.client.Service implements cz.apolicky.nswi145.paywall.PaywallSoap_Service {

    public PaywallSoap_ServiceLocator() {
    }


    public PaywallSoap_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PaywallSoap_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PaywallSoap
    private java.lang.String PaywallSoap_address = "http://localhost:8001/paywallIfce";

    public java.lang.String getPaywallSoapAddress() {
        return PaywallSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PaywallSoapWSDDServiceName = "PaywallSoap";

    public java.lang.String getPaywallSoapWSDDServiceName() {
        return PaywallSoapWSDDServiceName;
    }

    public void setPaywallSoapWSDDServiceName(java.lang.String name) {
        PaywallSoapWSDDServiceName = name;
    }

    public cz.apolicky.nswi145.paywall.PaywallSoap_PortType getPaywallSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PaywallSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPaywallSoap(endpoint);
    }

    public cz.apolicky.nswi145.paywall.PaywallSoap_PortType getPaywallSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cz.apolicky.nswi145.paywall.PaywallSoap_BindingStub _stub = new cz.apolicky.nswi145.paywall.PaywallSoap_BindingStub(portAddress, this);
            _stub.setPortName(getPaywallSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPaywallSoapEndpointAddress(java.lang.String address) {
        PaywallSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cz.apolicky.nswi145.paywall.PaywallSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cz.apolicky.nswi145.paywall.PaywallSoap_BindingStub _stub = new cz.apolicky.nswi145.paywall.PaywallSoap_BindingStub(new java.net.URL(PaywallSoap_address), this);
                _stub.setPortName(getPaywallSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PaywallSoap".equals(inputPortName)) {
            return getPaywallSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://apolicky.cz/nswi145/paywall", "PaywallSoap");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://apolicky.cz/nswi145/paywall", "PaywallSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PaywallSoap".equals(portName)) {
            setPaywallSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
