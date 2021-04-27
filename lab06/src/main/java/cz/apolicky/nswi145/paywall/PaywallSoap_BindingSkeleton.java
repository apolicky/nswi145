/**
 * PaywallSoap_BindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.apolicky.nswi145.paywall;

public class PaywallSoap_BindingSkeleton implements cz.apolicky.nswi145.paywall.PaywallSoap_PortType, org.apache.axis.wsdl.Skeleton {
    private cz.apolicky.nswi145.paywall.PaywallSoap_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "account_balance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "amount"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("pay", _params, new javax.xml.namespace.QName("", "new_balance_OR_failed_payment"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://apolicky.cz/nswi145/paywall", "pay"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("pay") == null) {
            _myOperations.put("pay", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("pay")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "success"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getReciept", _params, new javax.xml.namespace.QName("", "reciept_pdf"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://apolicky.cz/nswi145/paywall", "getReciept"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getReciept") == null) {
            _myOperations.put("getReciept", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getReciept")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "card_owner"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "card_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "expir_date"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("fillCredentials", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://apolicky.cz/nswi145/paywall", "fillCredentials"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("fillCredentials") == null) {
            _myOperations.put("fillCredentials", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("fillCredentials")).add(_oper);
    }

    public PaywallSoap_BindingSkeleton() {
        this.impl = new cz.apolicky.nswi145.paywall.PaywallSoap_BindingImpl();
    }

    public PaywallSoap_BindingSkeleton(cz.apolicky.nswi145.paywall.PaywallSoap_PortType impl) {
        this.impl = impl;
    }
    public int pay(int account_balance, int amount) throws java.rmi.RemoteException
    {
        int ret = impl.pay(account_balance, amount);
        return ret;
    }

    public java.lang.String getReciept(boolean success) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getReciept(success);
        return ret;
    }

    public void fillCredentials(java.lang.String card_owner, int card_id, int expir_date) throws java.rmi.RemoteException
    {
        impl.fillCredentials(card_owner, card_id, expir_date);
    }

}
