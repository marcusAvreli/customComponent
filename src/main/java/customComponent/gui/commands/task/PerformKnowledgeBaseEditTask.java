package customComponent.gui.commands.task;


import java.awt.Window;
import javax.swing.JComponent;

import customComponent.gui.commands.edit.KnowledgeBaseEdit;
import customComponent.gui.components.ErrorDialogManager;
import customComponent.gui.components.cursor.CursorManager;
import customComponent.model.knowledgebase.KnowledgeBaseException;

/**
 *
 * @author mjcobo
 */
public class PerformKnowledgeBaseEditTask {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /**
   * 
   */
  private KnowledgeBaseEdit edit;
  private JComponent component;

  private boolean successful;


  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
   * 
   * @param edit
   * @param compenent
   */
  public PerformKnowledgeBaseEditTask(KnowledgeBaseEdit edit, JComponent compenent) {

    this.edit = edit;
    this.component = compenent;
    this.successful = false;
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   */
  public void execute() {

    try {
      
      CursorManager.getInstance().setWaitCursor();
      this.successful = this.edit.execute();
      CursorManager.getInstance().setNormalCursor();

      if (! this.successful) {

        ErrorDialogManager.getInstance().showError(edit.getErrorMessage());
      }

    } catch (KnowledgeBaseException e) {

      this.successful = false;

      ErrorDialogManager.getInstance().showException(e);

      e.printStackTrace(System.err);

    }
  }

  /**
   * 
   * @return
   */
  public boolean isSuccessful() {
    return successful;
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
