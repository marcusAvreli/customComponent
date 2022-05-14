package customComponent.gui.components.detailspanel;

import java.util.ArrayList;

import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.entity.Report;
import customComponent.project.CurrentProject;

public class ReportDetailPanel extends GenericDetailPanel<Report> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReportDetailPanel() {
		initComponents();
		CurrentProject.getInstance().getKbObserver().addReportObserver(this);
	}

	@Override
	public void entityUpdated(ArrayList<Report> items) throws KnowledgeBaseException {
		// TODO Auto-generated method stub
		int position;

	    position = items.indexOf(this.report);

	    if (position != -1) {

	      refreshItem(items.get(position));

	    }
	}

	@Override
	public void entityAdded(ArrayList<Report> items) throws KnowledgeBaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void entityRemoved(ArrayList<Report> items) throws KnowledgeBaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void entityRefresh() throws KnowledgeBaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshItem(Report report) {
		// TODO Auto-generated method stub
		this.report = report;

	    if (this.report != null) {

	      idTextField.setText(String.valueOf(this.report.getId()));
	      reportTextField.setText(this.report.getName());
	      
	      setEnableTextField(true);

	    } else {

	      reset();

	    }

	}
	public void reset() {

	    idTextField.setText("");
	    reportTextField.setText("");

	    setEnableTextField(false);
	  }
	public void setEnableTextField(boolean enabled) {

	    idTextField.setEnabled(enabled);
	    reportTextField.setEnabled(enabled);
	  }

	public String getReport() {

		return reportTextField.getText();
	}

	private void initComponents() {

		idDescriptionLabel = new javax.swing.JLabel();
		idTextField = new javax.swing.JTextField();
		reportDescriptionLabel = new javax.swing.JLabel();
		reportTextField = new javax.swing.JTextField();

		idDescriptionLabel.setText("ID:");

		idTextField.setEnabled(false);

		reportDescriptionLabel.setText("Report:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(idDescriptionLabel).addComponent(reportDescriptionLabel))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addComponent(reportTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(idDescriptionLabel).addComponent(idTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(reportDescriptionLabel).addComponent(reportTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))));
	}// </editor-fold>//GEN-END:initComponents
		// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JLabel reportDescriptionLabel;
	private javax.swing.JTextField reportTextField;
	private javax.swing.JLabel idDescriptionLabel;
	private javax.swing.JTextField idTextField;
	// End of variables declaration//GEN-END:variables
	private Report report = null;
}
