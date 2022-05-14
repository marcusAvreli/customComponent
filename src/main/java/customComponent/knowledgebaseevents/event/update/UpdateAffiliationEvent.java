package customComponent.knowledgebaseevents.event.update;

import java.util.ArrayList;
import customComponent.knowledgebaseevents.event.KnowledgeBaseEvent;
import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class UpdateAffiliationEvent implements KnowledgeBaseEvent {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
  
  /**
   * 
   */
  private ArrayList<Affiliation> affiliations;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   * @param affiliations 
   */
  public UpdateAffiliationEvent(ArrayList<Affiliation> affiliations) {
    this.affiliations = affiliations;
  }
  
  /**
   * 
   * @param affiliation 
   */
  public UpdateAffiliationEvent(Affiliation affiliation) {
    this.affiliations = new ArrayList<Affiliation>();
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
    
    CurrentProject.getInstance().getKbObserver().fireAffiliationUpdated(affiliations);
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
