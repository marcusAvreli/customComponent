package customComponent.knowledgebaseevents.event.remove;

import java.util.ArrayList;

import customComponent.knowledgebaseevents.event.KnowledgeBaseEvent;
import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.entity.Report;
import customComponent.project.CurrentProject;

public class RemoveReportEvent implements KnowledgeBaseEvent {

	  /***************************************************************************/
	  /*                        Private attributes                               */
	  /***************************************************************************/
	  
	  /**
	   * 
	   */
	  private ArrayList<Report> affiliations;
	  
	  /***************************************************************************/
	  /*                            Constructors                                 */
	  /***************************************************************************/
	  
	  /**
	   * 
	   * @param affiliations 
	   */
	  public RemoveReportEvent(ArrayList<Report> affiliations) {
	    this.affiliations = affiliations;
	  }
	  
	  /**
	   * 
	   * @param affiliation 
	   */
	  public RemoveReportEvent(Report affiliation) {
	    this.affiliations = new ArrayList<Report>();
	    this.affiliations.add(affiliation);
	  }
	  
	  /***************************************************************************/
	  /*                           Public Methods                                */
	  /***************************************************************************/
	  
	  /**
	   * 
	   * @throws KnowledgeBaseException 
	   */
	  public void fireEvent() throws KnowledgeBaseException {
	    
	    CurrentProject.getInstance().getKbObserver().fireReportRemoved(affiliations);
	  }
	  
	  /***************************************************************************/
	  /*                           Private Methods                               */
	  /***************************************************************************/
	}
