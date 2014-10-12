/**
 * TimeServerImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package chapterOne.autoClient;

public interface TimeServerImplService extends javax.xml.rpc.Service {
    public java.lang.String getTimeServerImplPortAddress();

    public chapterOne.autoClient.TimeServer getTimeServerImplPort() throws javax.xml.rpc.ServiceException;

    public chapterOne.autoClient.TimeServer getTimeServerImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
