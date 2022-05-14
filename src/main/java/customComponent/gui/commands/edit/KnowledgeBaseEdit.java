package customComponent.gui.commands.edit;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotUndoException;
import customComponent.model.knowledgebase.KnowledgeBaseException;

/**
 *
 * @author mjcobo
 */
public abstract class KnowledgeBaseEdit extends AbstractUndoableEdit {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /**
   *
   */
  protected String errorMessage;

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public KnowledgeBaseEdit() {
    super();

    this.errorMessage = "";
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   *
   * @return
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   *
   */
  public abstract boolean execute() throws KnowledgeBaseException;

  /**
   *
   * @throws CannotUndoException
   */
  @Override
  public void undo() throws CannotUndoException {
    super.undo();
  }

  /**
   * 
   * @throws CannotUndoException
   */
  @Override
  public void redo() throws CannotUndoException {
    super.redo();
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}