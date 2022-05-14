package customComponent.gui.components.manager;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.gui.MainFrame;
import customComponent.gui.commands.edit.delete.DeleteAffiliationEdit;
import customComponent.gui.commands.task.PerformKnowledgeBaseEditTask;
import customComponent.gui.components.adddialog.AddDialogManager;
import customComponent.gui.components.globalslavepanel.AffiliationGlobalSlavePanel;
import customComponent.gui.components.itemslist.AffiliationsListPanel;
//import JoinEntitiesDialogManager;
import customComponent.model.knowledgebase.entity.Affiliation;

/**
 *
 * @author mjcobo
 */
public class AffiliationManager extends GenericItemManagerPanel<Affiliation> {
	private static final Logger logger = LoggerFactory.getLogger(AffiliationManager.class);
  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   */
  public AffiliationManager() {
    super(new AffiliationsListPanel(), 
          new AffiliationGlobalSlavePanel());

    setMasterPanelTitle("Affiliations list");
    setSlavePanelTitle("Affiliation detail");
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   */
  @Override
  public void addAction() {
	  logger.info("CheckPost1");
    AddDialogManager.getInstance().showAddAffiliationDialog();
  }

  /**
   *
   * @param items
   */
  @Override
  public void moveToAction(ArrayList<Affiliation> items) {
   // JoinEntitiesDialogManager.getInstance().showAffiliationsJoinDialog(items);
  }

  /**
   * 
   * @param items
   */
  @Override
  public void removeAction(ArrayList<Affiliation> items) {
	  logger.info("CheckPost2");
    (new PerformKnowledgeBaseEditTask(new DeleteAffiliationEdit(items), this)).execute();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}