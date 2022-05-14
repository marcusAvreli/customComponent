package customComponent.gui.components.itemslist;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.App;
import customComponent.gui.components.tablemodel.AffiliationsTableModel;
import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.project.CurrentProject;
import customComponent.project.observer.EntityObserver;

/**
 *
 * @author mjcobo
 */
public class AffiliationsListPanel 
extends GenericDynamicItemsListPanel<Affiliation> 
implements EntityObserver<Affiliation> {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
	private static final Logger logger = LoggerFactory.getLogger(AffiliationsListPanel.class);
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/  

  /**
   * 
   * @param tableModel 
   */
  public AffiliationsListPanel() {
    super(new AffiliationsTableModel());
    logger.info("checkPost");
    CurrentProject.getInstance().getKbObserver().addAffiliationObserver(this);
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException 
   */
  public void entityAdded(ArrayList<Affiliation> items) throws KnowledgeBaseException {
    
    addItems(items);
  }

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException 
   */
  public void entityRemoved(ArrayList<Affiliation> items) throws KnowledgeBaseException {
    removeItems(items);
  }

  /**
   * 
   * @param items
   * @throws KnowledgeBaseException 
   */
  public void entityUpdated(ArrayList<Affiliation> items) throws KnowledgeBaseException {
    updateItems(items);
  }

  /**
   * 
   * @throws KnowledgeBaseException 
   */
  public void entityRefresh() throws KnowledgeBaseException {
	  logger.info("Entity Refresh");
    refreshItems(CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().getAffiliations());
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
