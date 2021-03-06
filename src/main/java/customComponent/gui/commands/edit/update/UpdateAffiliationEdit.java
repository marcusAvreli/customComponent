package customComponent.gui.commands.edit.update;

import java.util.ArrayList;
import javax.swing.undo.CannotUndoException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.gui.MainFrame;
import customComponent.gui.UndoStack;
import customComponent.gui.commands.edit.KnowledgeBaseEdit;
import customComponent.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class UpdateAffiliationEdit extends KnowledgeBaseEdit {

	private static final Logger logger = LoggerFactory.getLogger(UpdateAffiliationEdit.class);
  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /**
   * The ID of the Affiliation
   */
  private Integer affiliationID;

  /**
   * This attribute contains the complete affiliation.
   */
  private String fullAffilliation;

  /**
   * The elements added
   */
  private ArrayList<Affiliation> affiliationsUpdated;

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   * @param fullAffilliation
   */
  public UpdateAffiliationEdit(Integer affiliationID, String fullAffilliation) {
    super();

    this.affiliationID = affiliationID;
    this.fullAffilliation = fullAffilliation;
    this.affiliationsUpdated = new ArrayList<Affiliation>();
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   * @throws KnowledgeBaseException
   */
  @Override
  public boolean execute() throws KnowledgeBaseException {

    boolean successful = false;
logger.info("execute");
    try {

      if (this.fullAffilliation == null) {

        successful = false;
        this.errorMessage = "The full affiliation can not be null.";
      
      } else if (CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().checkAffiliation(this.fullAffilliation)) { // Check the integrity

        successful = false;
        this.errorMessage = "An Affiliation yet exists with this full affiliation.";

      } else {

        this.affiliationsUpdated.add(CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().getAffiliation(this.affiliationID));

        successful = CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().setFullAffiliation(this.affiliationID, this.fullAffilliation, true);

        if (successful) {

          CurrentProject.getInstance().getKnowledgeBase().commit();

          KnowledgeBaseEventsReceiver.getInstance().fireEvents();

          successful = true;

          UndoStack.addEdit(this);

        } else {

          CurrentProject.getInstance().getKnowledgeBase().rollback();

          successful = false;
          this.errorMessage = "An error happened.";
        }
      }

    } catch (KnowledgeBaseException e) {

      CurrentProject.getInstance().getKnowledgeBase().rollback();

      successful = false;
      this.errorMessage = "An exception happened.";

      throw e;
    }

    return successful;
  
  }

  /**
   *
   * @throws CannotUndoException
   */
  @Override
  public void undo() throws CannotUndoException {
    super.undo();

    boolean flag;
    Affiliation affiliation;

    try {

      affiliation = this.affiliationsUpdated.get(0);

      flag = CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().setFullAffiliation(affiliation.getAffiliationID(),
              affiliation.getFullAffiliation(), true);

      if (flag) {

        CurrentProject.getInstance().getKnowledgeBase().commit();

        KnowledgeBaseEventsReceiver.getInstance().fireEvents();

      } else {

        CurrentProject.getInstance().getKnowledgeBase().rollback();
      }

    } catch (KnowledgeBaseException e) {

      e.printStackTrace(System.err);

      try{
        
        CurrentProject.getInstance().getKnowledgeBase().rollback();

      } catch (KnowledgeBaseException e2) {

        e2.printStackTrace(System.err);

      }
    }
  }

  /**
   * 
   * @throws CannotUndoException
   */
  @Override
  public void redo() throws CannotUndoException {
    super.redo();

    boolean flag;

    try {

      flag = CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().addAffiliation(this.affiliationID, this.fullAffilliation, true);

      if (flag) {

        CurrentProject.getInstance().getKnowledgeBase().commit();

        KnowledgeBaseEventsReceiver.getInstance().fireEvents();

      } else {

        CurrentProject.getInstance().getKnowledgeBase().rollback();
      }

    } catch (KnowledgeBaseException e) {

      e.printStackTrace(System.err);

      try{

        CurrentProject.getInstance().getKnowledgeBase().rollback();

      } catch (KnowledgeBaseException e2) {

        e2.printStackTrace(System.err);

      }
    }
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}