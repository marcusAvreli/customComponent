package customComponent.gui.components;


import javax.swing.JMenuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import customComponent.project.CurrentProject;
import customComponent.project.observer.KnowledgeBaseStateObserver;

/**
 * Extiende la funcionalidad de JMenuItem.
 * Observa los cambios de estado en la base de conocimiento.
 *
 * @author Manuel Jesus Cobo Martin.
 */
public class KnowledgeBaseStateObserverMenuItem extends JMenuItem
        implements KnowledgeBaseStateObserver {
	private static final Logger logger = LoggerFactory.getLogger(KnowledgeBaseStateObserverMenuItem.class);
  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
   * 
   */
  public KnowledgeBaseStateObserverMenuItem() {
    super();

    init();
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * Cuando ocurra un cambio en el estado de la base de conocimiento, este
   * objeto sera notificado a traves de este metodo.
   *
   * @param loaded nuevo estado de la base de conocimiento.
   */
  public void knowledgeBaseStateChanged(boolean loaded) {
	logger.info("knowledgeBaseStateChanged:"+loaded);
    setEnabled(loaded);
	
  }

  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/

  /**
   * Initialize the object.
   */
  private void init() {
	  logger.info("Init called");
    // Insertamos al objeto como observador del estado de la base de conocimiento.
	 // setEnabled(true);
    CurrentProject.getInstance().addKnowledgeBaseStateObserver(this);
  }
}
