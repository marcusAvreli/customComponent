package customComponent.gui.components.adddialog;

import java.util.ArrayList;
import javax.swing.JFrame;
import customComponent.model.knowledgebase.entity.Affiliation;
/*import scimat.model.knowledgebase.entity.Author;
import scimat.model.knowledgebase.entity.AuthorReference;
import scimat.model.knowledgebase.entity.Document;
import scimat.model.knowledgebase.entity.Journal;
import scimat.model.knowledgebase.entity.Period;
import scimat.model.knowledgebase.entity.PublishDate;
import scimat.model.knowledgebase.entity.Reference;
import scimat.model.knowledgebase.entity.ReferenceSource;
import scimat.model.knowledgebase.entity.Word;
*/
/**
 *
 * @author mjcobo
 */
public class AddDialogManager {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  /**
   *
   */
  private AddAffiliationDialog addAffiliationDialog;
  private AddReportDialog addReportDialog;
  /*private AddAuthorDialog addAuthorDialog;
  private AddAuthorGroupDialog addAuthorGroupDialog;
  private AddAuthorReferenceDialog addAuthorReferenceDialog;
  private AddAuthorReferenceGroupDialog addAuthorReferenceGroupDialog;
  private AddDocumentDialog addDocumentDialog;
  private AddJournalDialog addJournalDialog;
  private AddPeriodDialog addPeriodDialog;
  private AddPublishDateDialog addPublishDateDialog;
  private AddReferenceDialog addReferenceDialog;
  private AddReferenceGroupDialog addReferenceGroupDialog;
  private AddReferenceSourceDialog addReferenceSourceDialog;
  private AddReferenceSourceGroupDialog addReferenceSourceGroupDialog;
  private AddSubjectCategoryDialog addSubjectCategoryDialog;
  private AddWordDialog addWordDialog;
  private AddWordGroupDialog addWordGroupDialog;
  private AddWordsToDocumentDialog addWordsToDocumentDialog;
  private AddAffiliationsToDocumentDialog addAffiliationsToDocumentDialog;
  private AddReferencesToDocumentDialog addReferencesToDocumentDialog;
  private AddJournalToDocumentDialog addJournalToDocumentDialog;
  private AddPublishDateToDocumentDialog addPublishDateToDocumentDialog;
  private AddPublishDatesToPeriodDialog addPublishDatesToPeriodDialog;
  private AddAuthorsToDocumentDialog addAuthorsToDocumentDialog;
  private AddAuthorReferencesToReferenceDialog addAuthorReferencesToReferenceDialog;
  private AddReferenceSourceToReferenceDialog addReferenceSourceToReferenceDialog;
*/
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  private AddDialogManager() {
    
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * 
   * @return
   */
  public static AddDialogManager getInstance() {

    return AddDialogManagerHolder.INSTANCE;
  }

  /**
   *
   */
  private static class AddDialogManagerHolder {

    private static final AddDialogManager INSTANCE = new AddDialogManager();
  }

  /**
   *
   * @param frame
   */
  public void init(JFrame frame) {

    this.addAffiliationDialog = new AddAffiliationDialog(frame);
    this.addReportDialog = new AddReportDialog(frame);
    /*this.addAuthorDialog = new AddAuthorDialog(frame);
    this.addAuthorGroupDialog = new AddAuthorGroupDialog(frame);
    this.addAuthorReferenceDialog = new AddAuthorReferenceDialog(frame);
    this.addAuthorReferenceGroupDialog = new AddAuthorReferenceGroupDialog(frame);
    this.addDocumentDialog = new AddDocumentDialog(frame);
    this.addJournalDialog = new AddJournalDialog(frame);
    this.addPeriodDialog = new AddPeriodDialog(frame);
    this.addPublishDateDialog = new AddPublishDateDialog(frame);
    this.addReferenceDialog = new AddReferenceDialog(frame);
    this.addReferenceGroupDialog = new AddReferenceGroupDialog(frame);
    this.addReferenceSourceDialog = new AddReferenceSourceDialog(frame);
    this.addReferenceSourceGroupDialog = new AddReferenceSourceGroupDialog(frame);
    this.addSubjectCategoryDialog = new AddSubjectCategoryDialog(frame);
    this.addWordDialog = new AddWordDialog(frame);
    this.addWordGroupDialog = new AddWordGroupDialog(frame);
    this.addWordsToDocumentDialog = new AddWordsToDocumentDialog(frame);
    this.addAffiliationsToDocumentDialog = new AddAffiliationsToDocumentDialog(frame);
    this.addReferencesToDocumentDialog = new AddReferencesToDocumentDialog(frame);
    this.addJournalToDocumentDialog = new AddJournalToDocumentDialog(frame);
    this.addPublishDateToDocumentDialog = new AddPublishDateToDocumentDialog(frame);
    this.addPublishDatesToPeriodDialog = new AddPublishDatesToPeriodDialog(frame);
    this.addAuthorsToDocumentDialog = new AddAuthorsToDocumentDialog(frame);
    this.addAuthorReferencesToReferenceDialog = new AddAuthorReferencesToReferenceDialog(frame);
    this.addReferenceSourceToReferenceDialog = new AddReferenceSourceToReferenceDialog(frame);*/
  }

  /**
   * 
   */
  public void showAddAffiliationDialog() {

    this.addAffiliationDialog.refresh();
    this.addAffiliationDialog.setVisible(true);
  }
  public void showAddReportDialog() {

	    this.addReportDialog.refresh();
	    this.addReportDialog.setVisible(true);
	  }

  /**
   *
   */
  public void showAddAuthorDialog() {

   // this.addAuthorDialog.refresh();
   // this.addAuthorDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddAuthorGroupDialog() {

   // this.addAuthorGroupDialog.refresh();
    //this.addAuthorGroupDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddAuthorReferenceDialog() {

   // this.addAuthorReferenceDialog.refresh();
   // this.addAuthorReferenceDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddAuthorReferenceGroupDialog() {

    //this.addAuthorReferenceGroupDialog.refresh();
    //this.addAuthorReferenceGroupDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddDocumentDialog() {

    //this.addDocumentDialog.refresh();
    //this.addDocumentDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddJournalDialog() {

    //this.addJournalDialog.refresh();
    //this.addJournalDialog.setVisible(true);
  }

  public void showAddPeriodDialog() {

    //this.addPeriodDialog.refresh();
    //this.addPeriodDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddPublishDateDialog() {

  //  this.addPublishDateDialog.refresh();
   // this.addPublishDateDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddReferenceDialog() {

  //  this.addReferenceDialog.refresh();
   // this.addReferenceDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddReferenceGroupDialog() {

 //   this.addReferenceGroupDialog.refresh();
  //  this.addReferenceGroupDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddReferenceSourceDialog() {

    //this.addReferenceSourceDialog.refresh();
    //this.addReferenceSourceDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddReferenceSourceGroupDialog() {

   // this.addReferenceSourceGroupDialog.refresh();
   // this.addReferenceSourceGroupDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddSubjectCategoryDialog() {

   // this.addSubjectCategoryDialog.refresh();
    //this.addSubjectCategoryDialog.setVisible(true);
  }

  /**
   *
   */
  public void showAddWordDialog() {

   // this.addWordDialog.refresh();
   // this.addWordDialog.setVisible(true);
  }

  /**
   * 
   */
  public void showAddWordGroupDialog() {

    //this.addWordGroupDialog.refresh();
    //this.addWordGroupDialog.setVisible(true);
  }
  
  
}
