package customComponent.gui.components.itemslist;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.gui.components.tablemodel.AffiliationsTableModel;
import customComponent.gui.components.tablemodel.GenericDynamicTableModel;
import customComponent.gui.components.tablemodel.ReportTableModel;
import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.entity.Report;
import customComponent.project.CurrentProject;
import customComponent.project.observer.EntityObserver;

public class ReportListPanel
extends GenericDynamicItemsListPanel<Report> 
implements EntityObserver<Report> {
	private static final Logger logger = LoggerFactory.getLogger(ReportListPanel.class);
	public ReportListPanel() {
		 super(new ReportTableModel());
		
		// TODO Auto-generated constructor stub
	    CurrentProject.getInstance().getKbObserver().addReportObserver(this);

	}

	@Override
	public void entityUpdated(ArrayList<Report> items) throws KnowledgeBaseException {
		updateItems(items);
		
	}

	@Override
	public void entityAdded(ArrayList<Report> items) throws KnowledgeBaseException {
		addItems(items);
		
	}

	@Override
	public void entityRemoved(ArrayList<Report> items) throws KnowledgeBaseException {
		// TODO Auto-generated method stub		
		removeItems(items);
		
	}

	@Override
	public void entityRefresh() throws KnowledgeBaseException {
		// TODO Auto-generated method stub
		logger.info("Entity Report Refresh");
		refreshItems(CurrentProject.getInstance().getFactoryDAO().getReportDAO().getReports());
	}

}
