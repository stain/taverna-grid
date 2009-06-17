/*******************************************************************************
 * Copyright (C) 2007-2009 The University of Manchester   
 * Copyright (C) 2009 The University of Chicago 
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
package net.sf.taverna.t2.activities.cagrid.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import net.sf.taverna.t2.partition.QueryFactory;
import net.sf.taverna.t2.partition.QueryFactoryRegistry;

import org.junit.Test;

public class CaGridQueryFactoryTest {

	@Test
	public void testSPI() {
		List<QueryFactory> instances = QueryFactoryRegistry.getInstance().getInstances();
		assertTrue("There should be more than one instance found",instances.size()>0);
		boolean found = false;
		for (QueryFactory spi : instances) {
			if (spi instanceof CaGridQueryFactory) {
				found=true;
				break;
			}
		}
		assertTrue("A CaGridQueryFactory should have been found",found);
	}
	
	@Test
	public void testKey() {
		CaGridQueryFactory f = new CaGridQueryFactory();
		assertEquals("taverna.defaultwsdl",f.getPropertyKey());
	}
}