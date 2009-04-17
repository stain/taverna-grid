package net.sf.taverna.t2.activities.cagrid.views;

import net.sf.taverna.t2.activities.wsdl.WSDLActivity;
import net.sf.taverna.t2.workbench.ui.actions.activity.ActivityContextualView;
//import net.sf.taverna.t2.workbench.ui.views.contextualviews.activity.ActivityViewFactory;
import net.sf.taverna.t2.workbench.ui.views.contextualviews.activity.ContextualViewFactory;
//import net.sf.taverna.t2.workflowmodel.processor.activity.Activity;

public class CaGridActivityViewFactory implements ContextualViewFactory<WSDLActivity>{

	public boolean canHandle(Object object) {
		return object instanceof WSDLActivity;
	}

	public ActivityContextualView<?> getView(WSDLActivity activity) {
		return new CaGridActivityContextualView(activity);
	}
	
	

}
