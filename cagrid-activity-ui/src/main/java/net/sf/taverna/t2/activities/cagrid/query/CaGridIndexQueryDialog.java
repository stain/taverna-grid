package net.sf.taverna.t2.activities.cagrid.query;

/**
 *
 * @author Wei Tan
 * @author Alex Nenadic
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import net.sf.taverna.t2.lang.ui.ShadedLabel;


/**
 * A panel for helping create scavengers for caGrid registries that are not the default registry.
 *
 */
public class CaGridIndexQueryDialog extends JPanel {

	private static final long serialVersionUID = -57047613557546678L;
	final int q_size=3;//max query item size
	//TODO: add more well-know index service URLs
	private String[] URLs = { "http://cagrid-index.nci.nih.gov:8080/wsrf/services/DefaultIndexService",
			"http://cagrid01.bmi.ohio-state.edu:8080/wsrf/services/DefaultIndexService",
			"http://index.training.cagrid.org:8080/wsrf/services/DefaultIndexService",
			"Input Your Own Index Service URL Here..."};
	public JComboBox indexServiceURLs = new JComboBox(URLs);
	public JComboBox[] queryValue = new JComboBox[q_size];
	private String[] queryStrings = { "None", "Search String", "Point Of Contact", "Service Name", "Operation Name", "Operation Input",
			"Operation Output","Operation Class", "Research Center","Concept Code",
			"Domain Model for Data Services"};
	private String[] queryValues = {};

	//Create the combobox, select item at index 0.
	public JComboBox[]  queryList = new JComboBox[q_size];
	public JButton addQueryButton = new JButton("Add service query");
    public JButton removeQueryButton = new JButton("Remove service query");
    public int q_count =1;


    /**
     * Default constructor.
     *
     */
    public CaGridIndexQueryDialog() {
        super();
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10,10,10,10));
        
        JPanel indexServicePanel = new JPanel(new BorderLayout());
        indexServicePanel.setBorder(new EmptyBorder(5,5,5,5));
        for(int i=0;i<q_size;i++){
        	queryValue[i]=new JComboBox(queryValues);
        	queryValue[i].setEditable(true);
        	FontMetrics fm = getFontMetrics(queryValue[i].getFont());
        	int width = 50 + fm.stringWidth("RegionalNodeLymphadenectomyCutaneousMelanomaSurgicalPathologySpecimen"); //the longest string
        	queryValue[i].setPreferredSize(new Dimension(width,queryValue[i].getPreferredSize().height));
        	queryList[i] = new JComboBox(queryStrings);     	
        }
        indexServicePanel.add(new ShadedLabel("Location (URL) of the index service: ", ShadedLabel.BLUE, true), BorderLayout.WEST);
        indexServiceURLs.setEditable(true);
        indexServiceURLs.setToolTipText("caGrid Services will be retrieved from the index service whose URL you specify here!");
        indexServicePanel.add(indexServiceURLs, BorderLayout.CENTER);
        add(indexServicePanel, BorderLayout.NORTH);
        
        JPanel serviceQueryPanel = new JPanel(new BorderLayout());
        serviceQueryPanel.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), new EtchedBorder(EtchedBorder.LOWERED)));
        JPanel queryPanel = new JPanel(new GridBagLayout());
        JPanel queryButtonsPanel = new JPanel();
        queryButtonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        queryButtonsPanel.setBorder(new EmptyBorder(0,0,0,25));
        
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,0,5,5);
        queryPanel.add(new ShadedLabel("Service query criteria: ", ShadedLabel.BLUE, true), c);        
        //queryCriteria.setToolTipText("Service Query will use the query criteria you specify here!");   
		c.gridx = 1;
		c.gridy = 0;
        queryPanel.add(new ShadedLabel("Service query value: ", ShadedLabel.BLUE, true), c);
        
        c.gridy = 1;
        for (int i=0 ; i<q_size; i++){
        	c.gridx = 0;
        	queryValue[i].setToolTipText("Service Query will use the query value you specify here!");
        	queryPanel.add(queryList[i], c);
        	c.gridx = 1;
        	queryPanel.add(queryValue[i], c);  	
        	c.gridy++;
        }
        
        for (int i=1; i<q_size; i++){	
            queryList[i].setVisible(false);
            queryValue[i].setVisible(false);  	
        }
        serviceQueryPanel.add(queryPanel, BorderLayout.CENTER);
        
        queryButtonsPanel.add(addQueryButton);
        queryButtonsPanel.add(removeQueryButton);
        serviceQueryPanel.add(queryButtonsPanel, BorderLayout.SOUTH);
        
        add(serviceQueryPanel, BorderLayout.CENTER);

        // Size is set from the CaGridAddQueryActionHandler as we are still 
        // adding components to CaGridIndexQueryDialog from there
       // setPreferredSize(this.getPreferredSize());
       // setMinimumSize(this.getPreferredSize());
       // setMaximumSize(this.getPreferredSize());
    }
    
    /**
     * 
     * @return the string representation of the IndexServiceURL
     */
    public String getIndexServiceURL() {
        return (String) indexServiceURLs.getSelectedItem();
    }

    /**
     * 
     * @return the string representation of the QueryCriteria
     */
    public String getQueryCriteria(int i) {
        return (String) queryList[i].getSelectedItem();
    }
    
    /**
     * 
     * @return the string representation of the QueryValue
     */
    public String getQueryValue(int i) {
        return (String) queryValue[i].getSelectedItem();
    }
   
}


