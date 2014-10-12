package chapterOne.autoClient;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;

public class TimeTestAutoService {
	
	public static void main(String[] args) {
		
		try {
			
			
			TimeServerImplServiceLocator locator =  new TimeServerImplServiceLocator();
			TimeServerImplPortBindingStub bindingStub = new TimeServerImplPortBindingStub();
			TimeServerProxy proxy = new TimeServerProxy();
			
			proxy.setEndpoint(locator.getTimeServerImplPortAddress());
			bindingStub = (TimeServerImplPortBindingStub) locator.getTimeServerImplPort();
			
			
			try {
				System.out.println(bindingStub.getTimeAsString());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
