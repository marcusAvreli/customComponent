package customComponent.knowledgebaseevents.event.add;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.knowledgebaseevents.event.KnowledgeBaseEvent;
import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.model.knowledgebase.entity.Report;
import customComponent.project.CurrentProject;

public class AddReportEvent implements KnowledgeBaseEvent {

	  /***************************************************************************/
	  /*                        Private attributes                               */
	  /***************************************************************************/
	private static final Logger logger = LoggerFactory.getLogger(AddReportEvent.class);
	  /**
	   * 
	   */
	  private ArrayList<Report> reports;
	  
	  /***************************************************************************/
	  /*                            Constructors                                 */
	  /***************************************************************************/
	  
	  /**
	   * 
	   * @param affiliations 
	   */
	  public AddReportEvent(ArrayList<Report> reports) {
	    this.reports = reports;
	  }
	  
	  /**
	   * 
	   * @param affiliation 
	   */
	  public AddReportEvent(Report affiliation) {
	    this.reports = new ArrayList<Report>();
	    this.reports.add(affiliation);
	  }
	  
	  /***************************************************************************/
	  /*                           Public Methods                                */
	  /***************************************************************************/
	  
	  /**
	   * 
	   * @throws KnowledgeBaseException 
	   */
	  public void fireEvent() throws KnowledgeBaseException {
	    logger.info("FireReport event");
	    CurrentProject.getInstance().getKbObserver().fireReportAdded(reports);
	  }
	  
	  /***************************************************************************/
	  /*                           Private Methods                               */
	  /***************************************************************************/
	}
