/**
 * PaywallSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cz.apolicky.nswi145.paywall;

public interface PaywallSoap_PortType extends java.rmi.Remote {
    public int pay(int account_balance, int amount) throws java.rmi.RemoteException;
    public java.lang.String getReciept(boolean success) throws java.rmi.RemoteException;
    public void fillCredentials(java.lang.String card_owner, int card_id, int expir_date) throws java.rmi.RemoteException;
}
