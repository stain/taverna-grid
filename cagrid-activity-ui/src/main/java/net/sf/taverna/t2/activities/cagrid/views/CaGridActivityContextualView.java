package net.sf.taverna.t2.activities.cagrid.views;

import java.awt.Frame;

import javax.swing.Action;

import net.sf.taverna.t2.activities.cagrid.CaGridActivity;
import net.sf.taverna.t2.activities.cagrid.CaGridActivityConfigurationBean;
import net.sf.taverna.t2.workbench.ui.actions.activity.HTMLBasedActivityContextualView;
import net.sf.taverna.t2.workflowmodel.processor.activity.Activity;

public class CaGridActivityContextualView extends HTMLBasedActivityContextualView<CaGridActivityConfigurationBean> {

	private static final long serialVersionUID = -4329643934083676113L;

	public CaGridActivityContextualView(Activity<?> activity) {
		super(activity);
	}

	@Override
	public CaGridActivity getActivity() {
		return (CaGridActivity) super.getActivity();
	}
	
	@Override
	public String getViewTitle() {
		return "caGrid service";
	}

	@Override
	protected String getRawTableRowsHtml() {
		String summary="<tr><td>WSDL</td><td>"+getConfigBean().getWsdl();
		summary+="</td></tr><tr><td>Operation</td><td>"+getConfigBean().getOperation()+"</td></tr>";
		//TODO uncomment these two lines when we switch back to a newer version of wsdl-activity
		//boolean securityConfigured=getConfigBean().getSecurityProfileString()!=null;
		//summary+="<tr><td>Secured?</td><td>"+Boolean.toString(securityConfigured)+"</td></tr>";
		summary+="</tr>";
		return summary;
	}

	@Override
	public Action getConfigureAction(Frame owner) {
		return null;
	}
	
}
