package customComponent.gui.commands.edit.add;

import java.util.ArrayList;

import javax.swing.undo.CannotUndoException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.gui.UndoStack;
import customComponent.gui.commands.edit.KnowledgeBaseEdit;
import customComponent.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.model.knowledgebase.entity.Report;
import customComponent.project.CurrentProject;

public class AddReportEdit extends KnowledgeBaseEdit {

	  /***************************************************************************/
	  /*                        Private attributes                               */
	  /***************************************************************************/
		private static final Logger logger = LoggerFactory.getLogger(AddReportEdit.class);
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
	  private ArrayList<Report> affiliationsAdded;

	  /***************************************************************************/
	  /*                            Constructors                                 */
	  /***************************************************************************/

	  /**
	   * 
	   * @param fullAffilliation
	   */
	  public AddReportEdit(String fullAffilliation) {
	    super();

	    this.fullAffilliation = fullAffilliation;
	    this.affiliationsAdded = new ArrayList<Report>();
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

	    try {

	      if (this.fullAffilliation == null) {
	    	  logger.info("CheckPost_1");
	        successful = false;
	        this.errorMessage = "The full affiliation can not be null.";
	      
	      } else if (CurrentProject.getInstance().getFactoryDAO().getReportDAO().checkReport(this.fullAffilliation)) { // Check the integrity
	    	  logger.info("CheckPost_2");
	        successful = false;
	        this.errorMessage = "An Affiliation yet exists with this full affiliation.";

	      } else {
	    	  logger.info("CheckPost_3");
	    	
	    	  
	        this.affiliationID = CurrentProject.getInstance().getFactoryDAO().getReportDAO().addReport(this.fullAffilliation, true);
	        logger.info("CheckPost_3.1");
	        if (this.affiliationID != null) {
	        	logger.info("CheckPost_3.2");
	          CurrentProject.getInstance().getKnowledgeBase().commit();

	          this.affiliationsAdded.add(CurrentProject.getInstance().getFactoryDAO().getReportDAO().getReport(this.affiliationID));

	          KnowledgeBaseEventsReceiver.getInstance().fireEvents();

	          successful = true;
	          logger.info("CheckPost_3.3");
	          UndoStack.addEdit(this);

	        } else {

	          CurrentProject.getInstance().getKnowledgeBase().rollback();

	          successful = false;
	          this.errorMessage = "An error happened.";
	        }
	      }

	    } catch (KnowledgeBaseException e) {
	    	  if(null == CurrentProject.getInstance()) {
	    		  logger.info("instance is null");
	    	  }
	    	  logger.error("instance is null",e);
	    	  logger.error("instance is null"+e.getMessage());
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

	    try {

	      flag = CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO().removeAffiliation(this.affiliationID, true);

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
