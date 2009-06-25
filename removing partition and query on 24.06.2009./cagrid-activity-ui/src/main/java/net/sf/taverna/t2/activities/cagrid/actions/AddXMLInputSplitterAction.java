/*******************************************************************************
 * Copyright (C) 2008 The University of Manchester   
 * 
 *  Modifications to the initial code base are copyright of their
 *  respective authors, or their employers as appropriate.
 * 
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 *    
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *    
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 ******************************************************************************/
package net.sf.taverna.t2.activities.cagrid.actions;

import java.io.IOException;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import net.sf.taverna.t2.activities.cagrid.InputPortTypeDescriptorActivity;
import net.sf.taverna.t2.activities.cagrid.xmlsplitter.AddXMLSplitterEdit;
import net.sf.taverna.cagrid.wsdl.parser.TypeDescriptor;
import net.sf.taverna.cagrid.wsdl.parser.UnknownOperationException;

/**
 * Pops up a {@link JOptionPane} with the names of all the wsdl ports. The one
 * that is selected is added as an input splitter to the currently open dataflow
 * using the {@link AddXMLSplitterEdit}
 * 
 * @author Ian Dunlop
 * @author Stian Soiland-Reyes
 * 
 */
@SuppressWarnings("serial")
public class AddXMLInputSplitterAction extends
		AbstractAddXMLSplitterAction<InputPortTypeDescriptorActivity> {

	public AddXMLInputSplitterAction(InputPortTypeDescriptorActivity activity,
			JComponent owner) {
		super(activity, owner);
		putValue(NAME, "Add input XML splitter");
	}

	@Override
	protected Map<String, TypeDescriptor> getTypeDescriptors()
			throws UnknownOperationException, IOException {
		return (activity).getTypeDescriptorsForInputPorts();
	}

	@Override
	protected boolean isInput() {
		return true;
	}

}
