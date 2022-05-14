package customComponent.model.knowledgebase.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.XmlParser;
import customComponent.knowledgebaseevents.KnowledgeBaseEventsReceiver;
import customComponent.knowledgebaseevents.event.add.AddAffiliationEvent;
import customComponent.knowledgebaseevents.event.add.AddReportEvent;
import customComponent.knowledgebaseevents.event.remove.RemoveAffiliationEvent;
import customComponent.knowledgebaseevents.event.remove.RemoveReportEvent;
import customComponent.knowledgebaseevents.event.update.UpdateAffiliationEvent;
import customComponent.knowledgebaseevents.event.update.UpdateReportEvent;
import customComponent.model.knowledgebase.KnowledgeBaseException;
import customComponent.model.knowledgebase.KnowledgeBaseManager;
import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.entity.Report;

public class ReportDAO {
	/***************************************************************************/
	/* Private attributes */
	/***************************************************************************/
	private static final Logger logger = LoggerFactory.getLogger(ReportDAO.class);
	/**
	 * The knowlege base manager
	 */
	private KnowledgeBaseManager kbm;
	private Statement statDeleteReport;
	private String deleteReport;
	private Statement statUpdateReport;
	private String updateReport;
	private Statement stateSelectReportById;
	private String selectReportById;
	private Statement stateCheckReportByName;
	private String checkReportByName;
	private Statement statSelectReports;
	private String selectReports;
	private Statement statAddReport;
	private String addReport;

	public ReportDAO(KnowledgeBaseManager kbm) throws KnowledgeBaseException {

		this.kbm = kbm;

		XmlParser xmlParser = new XmlParser();
		xmlParser.setInputFilePathName("./resources/input.xml");
		xmlParser.createDocument();

		this.updateReport = xmlParser
				.getQuery("/databaseQueryTemplate/entityName[@name=\"Report\"]/action[@name=\"Update\"]/queryTemplate");
		this.selectReportById = xmlParser
				.getQuery("/databaseQueryTemplate/entityName[@name=\"Report\"]/action[@name=\"SelectById\"]/queryTemplate");
		this.addReport = xmlParser
				.getQuery("/databaseQueryTemplate/entityName[@name=\"Report\"]/action[@name=\"Insert\"]/queryTemplate");
		this.selectReports = xmlParser
				.getQuery("/databaseQueryTemplate/entityName[@name=\"Report\"]/action[@name=\"Select\"]/queryTemplate");
		this.checkReportByName = xmlParser
				.getQuery("/databaseQueryTemplate/entityName[@name=\"Report\"]/action[@name=\"SelectByName\"]/queryTemplate");
		this.deleteReport = xmlParser
				.getQuery("/databaseQueryTemplate/entityName[@name=\"Report\"]/action[@name=\"Delete\"]/queryTemplate");
	}
	public boolean checkReport(String fullAffiliation)
	          throws KnowledgeBaseException {

	    boolean result = false;
	    ResultSet rs;

	    try {
	    	logger.info("checkAffiliationByFullAffiliation:"+checkReportByName);
	     MessageFormat mf         = new MessageFormat(checkReportByName);
	     Object[] objs = { fullAffiliation };

	      //this.statCheckAffiliationByFullAffiliation.setString(1, fullAffiliation);
	     String queryString = mf.format(objs);
	     logger.info("queryString:"+queryString);
	     this.stateCheckReportByName = this.kbm.getConnection().createStatement();
	      rs = this.stateCheckReportByName.executeQuery(queryString);
	      
	      result = rs.next();
	      
	      rs.close();
	      
	      return result;

	    } catch (SQLException e) {

	      throw new KnowledgeBaseException(e.getMessage(), e.getCause());
	    }
	  }
	 public boolean setReport(Integer affiliationID, String fullAffilliation, boolean notifyObservers)
	          throws KnowledgeBaseException {
	    
	    boolean result = false;
	    
	    try {

	      this.statUpdateReport= this.kbm.getConnection().createStatement();
	      MessageFormat mf         = new MessageFormat(updateReport);
	      Object[] objs = { fullAffilliation,affiliationID };

	       
	      String queryString = mf.format(objs);
	      logger.info("queryString:"+queryString);


	      
	      
	      result = this.statUpdateReport.executeUpdate(queryString) > 0;

	    } catch (SQLException e) {

	      throw new KnowledgeBaseException(e.getMessage(), e.getCause());

	    }

	    // Notify to the observer
	    if (notifyObservers) {

	      KnowledgeBaseEventsReceiver.getInstance().addEvent(new UpdateReportEvent(getReport(affiliationID)));
	    }

	    return result;
	  }
	 public boolean addReport(Report affiliation, boolean notifyObservers)
	          throws KnowledgeBaseException{

	    return addReport(affiliation.getId(),
	                          affiliation.getName(),
	                          notifyObservers);
	  }
	 public boolean addReport(Integer affiliationID, String fullAffiliation, boolean notifyObservers)
	          throws KnowledgeBaseException{
	    logger.info("addAffiliation start");
	    boolean result = false;

	    try {

	      this.statAddReport=this.kbm.getConnection().createStatement();
	      MessageFormat mf         = new MessageFormat(addReport);
	        Object[] objs = { fullAffiliation,affiliationID };
	       String queryString =  mf.format(objs);
	       logger.info("QueryString:"+queryString);
	      

	      result = this.statAddReport.executeUpdate(queryString) > 0;

	    } catch (SQLException e) {

	      throw new KnowledgeBaseException(e.getMessage(), e.getCause());
	    }

	    // Notify to the observer
	    if (notifyObservers) {

	      KnowledgeBaseEventsReceiver.getInstance().addEvent(new AddReportEvent(getReport(affiliationID)));
	    }

	    return result;
	  }

	 public Integer addReport(String fullAffiliation, boolean notifyObservers)
	          throws KnowledgeBaseException{

	    Integer id=-1;

	    try {

	    	this.kbm.getConnection().setAutoCommit(true);
	    	this.statAddReport = this.kbm.getConnection().createStatement();
	    	
	    	MessageFormat mf         = new MessageFormat(addReport);
	        Object[] objs = { fullAffiliation,"description1" };
	       String queryString =  mf.format(objs);
	       logger.info("QueryString:"+queryString);
	     

	      if (this.statAddReport.executeUpdate(queryString,Statement.RETURN_GENERATED_KEYS) == 1 ) {

	    	  
	    	  ResultSet rs = statAddReport.getGeneratedKeys();
	    	  if (rs != null && rs.next()) {
	    	      id = rs.getInt(1);
	    	  }
	    	  rs.close();
	        

	      } else {

	        id = null;
	      }

	    } catch (SQLException e) {

	      throw new KnowledgeBaseException(e.getMessage(), e.getCause());
	    }
	    
	    // Notify to the observer
	    if (notifyObservers) {
	    
	      KnowledgeBaseEventsReceiver.getInstance().addEvent(new AddReportEvent(getReport(id)));
	    }

	    return id;
	  }
	 public boolean removeReport(Integer affiliationID, boolean notifyObservers)
	          throws KnowledgeBaseException {

	    boolean result = false;
	    Report affiliation = null;
	 /*   ArrayList<Document> documents = null;
	    ArrayList<Author> authors = null;
	    ArrayList<Author> authorsWithoutGroup = null;*/
	    
	    // Save the information before remove
	    if (notifyObservers) {
	      
	      affiliation = getReport(affiliationID);
	      //documents = getDocuments(affiliationID);
	      //authors = getAuthors(affiliationID);
	      //authorsWithoutGroup = getAuthorWithoutGroups(affiliationID);
	    }
	    logger.info("affiliationId:"+affiliationID);
	    
		
		MessageFormat mf         = new MessageFormat(deleteReport);
	    Object[] objs = { affiliationID };
	   String queryString =  mf.format(objs);
	   logger.info("QueryString:"+queryString);
	    try {

	      
	    	this.statDeleteReport = this.kbm.getConnection().createStatement();
	      

	      result = this.statDeleteReport.executeUpdate(queryString) > 0;

	    } catch (SQLException e) {

	      throw new KnowledgeBaseException(e.getMessage(), e.getCause());
	    }

	    // Notify to the observer
	    if (notifyObservers) {

	      KnowledgeBaseEventsReceiver.getInstance().addEvent(new RemoveReportEvent(affiliation));

	      //KnowledgeBaseEventsReceiver.getInstance().addEvent(new UpdateDocumentEvent(CurrentProject.getInstance().getFactoryDAO().getDocumentDAO().refreshDocuments(documents)));
	      //KnowledgeBaseEventsReceiver.getInstance().addEvent(new DocumentRelationAffiliationEvent());

	    //  KnowledgeBaseEventsReceiver.getInstance().addEvent(new UpdateAuthorEvent(CurrentProject.getInstance().getFactoryDAO().getAuthorDAO().refreshAuthors(authors)));
	     // KnowledgeBaseEventsReceiver.getInstance().addEvent(new UpdateAuthorEvent(CurrentProject.getInstance().getFactoryDAO().getAuthorDAO().refreshAuthors(authorsWithoutGroup)));
	     // KnowledgeBaseEventsReceiver.getInstance().addEvent(new AuthorRelationAffiliationEvent());
	    }
	    return result;
	 }

	 public Report getReport(Integer idAffiliation)
	          throws KnowledgeBaseException {
	logger.info("getAffiliation:"+idAffiliation);
	    ResultSet rs;
	    Report report = null;
	    
	  
	    
	    MessageFormat mf         = new MessageFormat(selectReportById);
	    Object[] objs = { idAffiliation };

	     
	    String queryString = mf.format(objs);
	    logger.info("queryString:"+queryString);

	    
	    try {

	    	this.stateSelectReportById = this.kbm.getConnection().createStatement();

	      rs = this.stateSelectReportById.executeQuery(queryString);

	      if (rs.next()) {

	        report = UtilsDAO.getInstance().getReport(rs);
	      }

	      rs.close();

	    } catch (SQLException e) {

	      throw new KnowledgeBaseException(e.getMessage(), e.getCause());
	    }

	    return report;
	  }


	public ArrayList<Report> getReports() throws KnowledgeBaseException {

		ResultSet rs;
		logger.info("get_reports");
		ArrayList<Report> affiliationsList = new ArrayList<Report>();

		try {

			this.statSelectReports = this.kbm.getConnection().createStatement();

			logger.info("selectAffiliations:" + selectReports);
			rs = this.statSelectReports.executeQuery(selectReports);

			while (rs.next()) {

				affiliationsList.add(UtilsDAO.getInstance().getReport(rs));
			}

			rs.close();

		} catch (SQLException e) {

			throw new KnowledgeBaseException(e.getMessage(), e.getCause());
		}

		return affiliationsList;
	}

}
