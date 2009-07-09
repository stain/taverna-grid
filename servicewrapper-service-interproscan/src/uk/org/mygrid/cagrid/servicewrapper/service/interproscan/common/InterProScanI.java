package uk.org.mygrid.cagrid.servicewrapper.service.interproscan.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public interface InterProScanI {

  /**
   * Invoke InterProScan asynchronously - returns an endpoint reference to the job that will contain the results
   *
   * @param interProScanInput
   */
  public uk.org.mygrid.cagrid.servicewrapper.service.interproscan.job.stubs.types.InterProScanJobReference interProScan(uk.org.mygrid.cagrid.domain.interproscan.InterProScanInput interProScanInput) throws RemoteException ;

}
