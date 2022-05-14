package customComponent.knowledgebaseevents.event.add;

import java.util.ArrayList;
import customComponent.knowledgebaseevents.event.KnowledgeBaseEvent;
import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class AddAffiliationEvent implements KnowledgeBaseEvent {

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
  public AddAffiliationEvent(ArrayList<Affiliation> affiliations) {
    this.affiliations = affiliations;
  }
  
  /**
   * 
   * @param affiliation 
   */
  public AddAffiliationEvent(Affiliation affiliation) {
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
    
    CurrentProject.getInstance().getKbObserver().fireAffiliationAdded(affiliations);
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
