package customComponent.gui.components.globalslavepanel;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.gui.commands.edit.update.UpdateReportEdit;
import customComponent.gui.commands.task.PerformKnowledgeBaseEditTask;
import customComponent.gui.components.HideAndShowPanel;
import customComponent.gui.components.detailspanel.ReportDetailPanel;
import customComponent.model.knowledgebase.entity.Report;

public class ReportGlobalSlavePanel extends GlobalSlavePanel<Report> {

	private static final Logger logger = LoggerFactory.getLogger(ReportGlobalSlavePanel.class);
  /** Creates new form AffiliationGlobalSlavePanel */
  public ReportGlobalSlavePanel() {
    initComponents();
  }
  @Override
  public void refresh(Report item) {

    setMasterItem(item);
logger.info("refresh");
    this.reportDetailPanel.refreshItem(item);
    //this.affiliationSlaveAuthorsPanel.setMasterItem(item);
    //this.affiliationSlaveDocumentsPanel.setMasterItem(item);

    if (item != null) {
      
      this.updateAffiliationButton.setEnabled(true);

    } else {
      
      this.updateAffiliationButton.setEnabled(false);

    }
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
logger.info("AffiliationGlobalSlavePanel start");
    hideAndShowAffiliationPanel = new HideAndShowPanel();
    affiliationInfoPanel = new javax.swing.JPanel();
    reportDetailPanel = new ReportDetailPanel();
    updateAffiliationButton = new javax.swing.JButton();
   // hideAndShowAuthorPanel = new scimat.gui.components.HideAndShowPanel();
    //authorInfoPanel = new javax.swing.JPanel();
   // affiliationSlaveAuthorsPanel = new scimat.gui.components.slavepanel.AffiliationSlaveAuthorsPanel();
   // hideAndShowDocumentPanel = new scimat.gui.components.HideAndShowPanel();
    //documentInfoPanel = new javax.swing.JPanel();
    //affiliationSlaveDocumentsPanel = new AffiliationSlaveDocumentsPanel();
    logger.info("checkPost_1");
    this.hideAndShowAffiliationPanel.setDescription("Report info");
    this.hideAndShowAffiliationPanel.setPanel(this.affiliationInfoPanel);
    logger.info("checkPost_2");
    updateAffiliationButton.setText("Update");
    updateAffiliationButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        updateAffiliationButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout affiliationInfoPanelLayout = new javax.swing.GroupLayout(affiliationInfoPanel);
    affiliationInfoPanel.setLayout(affiliationInfoPanelLayout);
    affiliationInfoPanelLayout.setHorizontalGroup(
      affiliationInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(reportDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, affiliationInfoPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(updateAffiliationButton))
    );
    affiliationInfoPanelLayout.setVerticalGroup(
      affiliationInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(affiliationInfoPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(reportDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(updateAffiliationButton))
    );
    logger.info("checkPost_3");

   /* this.hideAndShowAuthorPanel.setDescription("Authors info");
    this.hideAndShowAuthorPanel.setPanel(this.authorInfoPanel);

    javax.swing.GroupLayout authorInfoPanelLayout = new javax.swing.GroupLayout(authorInfoPanel);
    authorInfoPanel.setLayout(authorInfoPanelLayout);
    authorInfoPanelLayout.setHorizontalGroup(
      authorInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(affiliationSlaveAuthorsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
    );
    authorInfoPanelLayout.setVerticalGroup(
      authorInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(affiliationSlaveAuthorsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
    );

    this.hideAndShowDocumentPanel.setDescription("Documents info");
    this.hideAndShowDocumentPanel.setPanel(this.documentInfoPanel);
*/
    //javax.swing.GroupLayout documentInfoPanelLayout = new javax.swing.GroupLayout(documentInfoPanel);
    //documentInfoPanel.setLayout(documentInfoPanelLayout);
   /* documentInfoPanelLayout.setHorizontalGroup(
      documentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(affiliationSlaveDocumentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
    );
    documentInfoPanelLayout.setVerticalGroup(
      documentInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(affiliationSlaveDocumentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
*/
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
        //  .addComponent(documentInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          //.addComponent(authorInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(affiliationInfoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(hideAndShowAffiliationPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
         // .addComponent(hideAndShowAuthorPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
          //.addComponent(hideAndShowDocumentPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(hideAndShowAffiliationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(affiliationInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        //.addComponent(hideAndShowAuthorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      //  .addComponent(authorInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        //.addComponent(hideAndShowDocumentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        //.addComponent(documentInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  /**
   * 
   * @param evt
   */
  private void updateAffiliationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAffiliationButtonActionPerformed
logger.info("hello updateAffiliationButtonActionPerformed");
    PerformKnowledgeBaseEditTask task;

    // If the name is empty
    if (this.reportDetailPanel.getReport().isEmpty()) {

      JOptionPane.showMessageDialog(this, "You have to give a full affiliation.\nPlease, " +
        "give a full affiliation.", "Invalid full affiliation", JOptionPane.ERROR_MESSAGE);

    } else {

      task = new PerformKnowledgeBaseEditTask(new UpdateReportEdit(getMasterItem().getId(),
              this.reportDetailPanel.getReport()), this);

      task.execute();
    }
  }//GEN-LAST:event_updateAffiliationButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  //private AffiliationDetailPanel reportDetailPanel;
  private ReportDetailPanel reportDetailPanel;
  private javax.swing.JPanel affiliationInfoPanel;
  //private scimat.gui.components.slavepanel.AffiliationSlaveAuthorsPanel affiliationSlaveAuthorsPanel;
  //private scimat.gui.components.slavepanel.AffiliationSlaveDocumentsPanel affiliationSlaveDocumentsPanel;
  private javax.swing.JPanel authorInfoPanel;
  private javax.swing.JPanel documentInfoPanel;
  private HideAndShowPanel hideAndShowAffiliationPanel;
  /*private scimat.gui.components.HideAndShowPanel hideAndShowAuthorPanel;
  private scimat.gui.components.HideAndShowPanel hideAndShowDocumentPanel;*/
  private javax.swing.JButton updateAffiliationButton;
  // End of variables declaration//GEN-END:variables
}

