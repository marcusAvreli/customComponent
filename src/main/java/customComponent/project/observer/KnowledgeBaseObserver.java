package customComponent.project.observer;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.entity.Report;
import customComponent.gui.MainFrame;
import customComponent.model.knowledgebase.KnowledgeBaseException;

/**
 *
 * @author mjcobo
 */
public class KnowledgeBaseObserver {
	private static final Logger logger = LoggerFactory.getLogger(KnowledgeBaseObserver.class);
  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  // ------------------------------------------------------------------------

  /**
   *
   */
  private ArrayList<EntityObserver<Affiliation>> affiliationObservers = new ArrayList<EntityObserver<Affiliation>>();
  private ArrayList<EntityObserver<Report>> reportObservers = new ArrayList<EntityObserver<Report>>();

  /**
   *
   */
   /**
   *
   */
 
  // ------------------------------------------------------------------------

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   */
  public void fireKnowledgeBaseRefresh() throws KnowledgeBaseException {
logger.info("fireKnowledgeBaseRefresh");
    fireAffiliationRefresh();
    fireReportRefresh();
 
  }
  public void addReportObserver(EntityObserver<Report> observer) {

	    this.reportObservers.add(observer);
	  }
  /**
   * Add a new observer to the affiliations.
   *
   * @param observer the new observer
   */
  public void addAffiliationObserver(EntityObserver<Affiliation> observer) {

    this.affiliationObservers.add(observer);
  }

  /**
   * Delete a observer from the affiliations
   *
   * @param observer the observer to remove
   */
  public void removeAffiliationObserver(EntityObserver<Affiliation> observer){

    this.affiliationObservers.remove(observer);
  }

  /**
   * Notify to the affiliation's observer that a change has happened in it.
   */
  public void fireAffiliationAdded(ArrayList<Affiliation> items)
          throws KnowledgeBaseException {

    int i;

    for (i = 0; i < this.affiliationObservers.size(); i++) {

      this.affiliationObservers.get(i).entityAdded(items);
    }
  }
  public void fireReportAdded(ArrayList<Report> items)   throws KnowledgeBaseException {
	  int i;

	    for (i = 0; i < this.reportObservers.size(); i++) {

	      this.reportObservers.get(i).entityAdded(items);
	    }
  }
  public void fireReportRemoved(ArrayList<Report> items)
          throws KnowledgeBaseException {

    int i;

    for (i = 0; i < this.reportObservers.size(); i++) {

      this.reportObservers.get(i).entityRemoved(items);
    }
  }
  /**
   * Notify to the affiliation's observer that a change has happened in it.
   */
  public void fireAffiliationRemoved(ArrayList<Affiliation> items)
          throws KnowledgeBaseException {

    int i;

    for (i = 0; i < this.affiliationObservers.size(); i++) {

      this.affiliationObservers.get(i).entityRemoved(items);
    }
  }
  public void fireReportUpdated(ArrayList<Report> items)
          throws KnowledgeBaseException {

    int i;

    for (i = 0; i < this.reportObservers.size(); i++) {

      this.reportObservers.get(i).entityUpdated(items);
    }
  }
  /**
   * Notify to the affiliation's observer that a change has happened in it.
   */
  public void fireAffiliationUpdated(ArrayList<Affiliation> items)
          throws KnowledgeBaseException {

    int i;

    for (i = 0; i < this.affiliationObservers.size(); i++) {

      this.affiliationObservers.get(i).entityUpdated(items);
    }
  }

  /**
   * Notify to the affiliation's observer that a change has happened in it.
   */
  public void fireAffiliationRefresh() throws KnowledgeBaseException {

    int i;
logger.info("fire affiliation refresh");
    for (i = 0; i < this.affiliationObservers.size(); i++) {

      this.affiliationObservers.get(i).entityRefresh();
    }
  }

  public void fireReportRefresh() throws KnowledgeBaseException {

	    int i;
	logger.info("fire report refresh");
	    for (i = 0; i < this.reportObservers.size(); i++) {

	      this.reportObservers.get(i).entityRefresh();
	    }
	  }

 
  // ------------------------------------------------------------------------

  /**
   * Add a new observer to the author references.
   *
   * @param observer the new observer
   */
 
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}