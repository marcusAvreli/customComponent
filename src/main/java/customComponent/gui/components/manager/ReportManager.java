package customComponent.gui.components.manager;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.gui.commands.edit.delete.DeleteAffiliationEdit;
import customComponent.gui.commands.edit.delete.DeleteReportEdit;
import customComponent.gui.commands.task.PerformKnowledgeBaseEditTask;
import customComponent.gui.components.adddialog.AddDialogManager;
import customComponent.gui.components.globalslavepanel.ReportGlobalSlavePanel;
import customComponent.gui.components.itemslist.ReportListPanel;
import customComponent.model.knowledgebase.entity.Report;

public class ReportManager extends GenericItemManagerPanel<Report> {
	private static final Logger logger = LoggerFactory.getLogger(ReportManager.class);
	public ReportManager() {
		
super(new ReportListPanel(), 
        new ReportGlobalSlavePanel());
	    setMasterPanelTitle("Report list");
	    setSlavePanelTitle("Report detail");
	  }

	@Override
	public void addAction() {
		// TODO Auto-generated method stub
		logger.info("Add action");
		 AddDialogManager.getInstance().showAddReportDialog();
		
	}

	@Override
	public void removeAction(ArrayList<Report> items) {
		// TODO Auto-generated method stub
		 (new PerformKnowledgeBaseEditTask(new DeleteReportEdit(items), this)).execute();
		
	}

	@Override
	public void moveToAction(ArrayList<Report> items) {
		// TODO Auto-generated method stub
		
	}
}
