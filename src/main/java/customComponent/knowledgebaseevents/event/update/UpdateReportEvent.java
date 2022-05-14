package customComponent.knowledgebaseevents.event.update;

import java.util.ArrayList;

import customComponent.knowledgebaseevents.event.KnowledgeBaseEvent;
import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.entity.Report;
import customComponent.project.CurrentProject;

public class UpdateReportEvent implements KnowledgeBaseEvent {

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
	  public UpdateReportEvent(ArrayList<Report> affiliations) {
	    this.affiliations = affiliations;
	  }
	  
	  /**
	   * 
	   * @param affiliation 
	   */
	  public UpdateReportEvent(Report affiliation) {
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
	    
	    CurrentProject.getInstance().getKbObserver().fireReportUpdated(affiliations);
	  }
	  
	  /***************************************************************************/
	  /*                           Private Methods                               */
	  /***************************************************************************/
	}
