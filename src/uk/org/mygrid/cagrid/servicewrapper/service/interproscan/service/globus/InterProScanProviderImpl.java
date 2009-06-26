package uk.org.mygrid.cagrid.servicewrapper.service.interproscan.service.globus;

import uk.org.mygrid.cagrid.servicewrapper.service.interproscan.service.InterProScanImpl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the InterProScanImpl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public class InterProScanProviderImpl{
	
	InterProScanImpl impl;
	
	public InterProScanProviderImpl() throws RemoteException {
		impl = new InterProScanImpl();
	}
	

    public uk.org.mygrid.cagrid.servicewrapper.service.interproscan.stubs.InterProScanResponse interProScan(uk.org.mygrid.cagrid.servicewrapper.service.interproscan.stubs.InterProScanRequest params) throws RemoteException {
    uk.org.mygrid.cagrid.servicewrapper.service.interproscan.stubs.InterProScanResponse boxedResult = new uk.org.mygrid.cagrid.servicewrapper.service.interproscan.stubs.InterProScanResponse();
    boxedResult.setInterProScanJobReference(impl.interProScan(params.getInterProScanInput().getInterProScanInput()));
    return boxedResult;
  }

}
