package customComponent.gui.components.globalreplace;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.gui.commands.edit.KnowledgeBaseEdit;
import customComponent.gui.commands.edit.update.UpdateAffiliationEdit;
import customComponent.model.knowledgebase.dao.AffiliationDAO;
import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.project.CurrentProject;

/**
 *
 * @author mjcobo
 */
public class GlobalReplaceAffiliationsEdit extends KnowledgeBaseEdit {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/
	private static final Logger logger = LoggerFactory.getLogger(GlobalReplaceAffiliationsEdit.class);
  private String findText;
  private String replaceText;
  private boolean findInFullAffiliation;
  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   * @param findText
   * @param replaceText
   * @param findInFullAffiliation 
   */
  public GlobalReplaceAffiliationsEdit(String findText, String replaceText, boolean findInFullAffiliation) {
    this.findText = findText;
    this.replaceText = replaceText;
    this.findInFullAffiliation = findInFullAffiliation;
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * Exxecute the task
   */
  @Override
  public boolean  execute() throws KnowledgeBaseException {
    logger.info("Execute");
    int i;
    boolean successful, joined, updated;
    ArrayList<Affiliation> affiliations;
    Affiliation affiliation;
    String fullAffiliation;
    AffiliationDAO affiliationDAO;
    
    successful = false;
    
    affiliationDAO = CurrentProject.getInstance().getFactoryDAO().getAffiliationDAO();
    
    // For each entity:
    // 1. Update the unique fields.
    // 2. Check if there is an entity with the same unique fields.
    // 2.1 Yes: Join and finish
    // 2.2 No: Update the remainings fields and call to the corresponding update Edit.
    logger.info("here");
    try {

      affiliations = affiliationDAO.getAffiliations();
      
      for (i = 0; i < affiliations.size(); i++) {
        
        joined = false;
        updated = false;
      
        affiliation = affiliations.get(i);
        
        if (this.findInFullAffiliation) {
        
          fullAffiliation = affiliation.getFullAffiliation().replaceAll(findText, replaceText);
          
          // If the field has been not modified we set false the flag. Otherwise, true.
          updated = updated || (! fullAffiliation.equals(affiliation.getFullAffiliation()));
          
        } else {
        
          fullAffiliation = affiliation.getFullAffiliation();
          
          updated = updated || false;
        }
        
        // If the unique fields have been modified, the entity could be 
        // joined with an entity with the same unique fields.
        if (updated) {
        
          if (affiliationDAO.checkAffiliation(fullAffiliation)) {
          
            ArrayList<Affiliation> tmpArray = new ArrayList<Affiliation>();
            tmpArray.add(affiliation);
            
           // successful = new JoinAffiliationEdit(tmpArray, affiliationDAO.getAffiliation(fullAffiliation)).execute();
            joined = true;
            
          }
        } 
        
        // If the entity has been not joined and the fields have been modified, we perform the update.
        if (! joined && updated) {
        
          successful = new UpdateAffiliationEdit(affiliation.getAffiliationID(), fullAffiliation).execute();
        }
        
      }

    } catch (KnowledgeBaseException e) {
      
      successful = false;
      this.errorMessage = "An exception happened.";

      throw e;
    }
    
    return successful;
  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
