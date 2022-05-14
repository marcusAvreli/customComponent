package customComponent.model.knowledgebase.dao;

import customComponent.model.knowledgebase.KnowledgeBaseManager;
import customComponent.model.knowledgebase.KnowledgeBaseException;
//import scimat.model.statistic.dao.StatisticDAO;

/**
 *
 * @author mjcobo
 */
public class FactoryDAO {

  /***************************************************************************/
  /*                        Private attributes                               */
  /***************************************************************************/

  private KnowledgeBaseManager kbm;

  private AffiliationDAO affiliationDAO;
  private ReportDAO reportDAO;
 /* private AuthorAffiliationDAO authorAffiliationDAO;
  private AuthorDAO authorDAO;
  private AuthorGroupDAO authorGroupDAO;
  private AuthorReferenceDAO authorReferenceDAO;
  private AuthorReferenceGroupDAO authorReferenceGroupDAO;
  private AuthorReferenceReferenceDAO authorReferenceReferenceDAO;
  private DocumentAffiliationDAO documentAffiliationDAO;
  private DocumentAuthorDAO documentAuthorDAO;
  private DocumentDAO documentDAO;
  private DocumentReferenceDAO documentReferenceDAO;
  private DocumentWordDAO documentWordDAO;
  private JournalDAO journalDAO;
  private JournalSubjectCategoryPublishDateDAO journalSubjectCategoryPublishDateDAO;
  private PeriodDAO periodDAO;
  private PublishDateDAO publishDateDAO;
  private PublishDatePeriodDAO publishDatePeriodDAO;
  private ReferenceDAO referenceDAO;
  private ReferenceGroupDAO referenceGroupDAO;
  private ReferenceSourceDAO referenceSourceDAO;
  private ReferenceSourceGroupDAO referenceSourceGroupDAO;
  private SubjectCategoryDAO subjectCategoryDAO;
  private WordDAO wordDAO;
  private WordGroupDAO wordGroupDAO;
  private StatisticDAO statisticDAO;*/

  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/

  public FactoryDAO(KnowledgeBaseManager kbm) throws KnowledgeBaseException {

    this.kbm = kbm;

    affiliationDAO = new AffiliationDAO(kbm);
    reportDAO = new ReportDAO(kbm);
    /*authorAffiliationDAO = new AuthorAffiliationDAO(kbm);
    authorDAO = new AuthorDAO(kbm);
    authorGroupDAO = new AuthorGroupDAO(kbm);
    authorReferenceDAO = new AuthorReferenceDAO(kbm);
    authorReferenceGroupDAO = new AuthorReferenceGroupDAO(kbm);
    authorReferenceReferenceDAO = new AuthorReferenceReferenceDAO(kbm);
    documentAffiliationDAO = new DocumentAffiliationDAO(kbm);
    documentAuthorDAO = new DocumentAuthorDAO(kbm);
    documentDAO = new DocumentDAO(kbm);
    documentReferenceDAO = new DocumentReferenceDAO(kbm);
    documentWordDAO = new DocumentWordDAO(kbm);
    journalDAO = new JournalDAO(kbm);
    journalSubjectCategoryPublishDateDAO = new JournalSubjectCategoryPublishDateDAO(kbm);
    periodDAO = new PeriodDAO(kbm);
    publishDateDAO = new PublishDateDAO(kbm);
    publishDatePeriodDAO = new PublishDatePeriodDAO(kbm);
    referenceDAO = new ReferenceDAO(kbm);
    referenceGroupDAO = new ReferenceGroupDAO(kbm);
    referenceSourceDAO = new ReferenceSourceDAO(kbm);
    referenceSourceGroupDAO = new ReferenceSourceGroupDAO(kbm);
    subjectCategoryDAO = new SubjectCategoryDAO(kbm);
    wordDAO = new WordDAO(kbm);
    wordGroupDAO = new WordGroupDAO(kbm);
    statisticDAO = new StatisticDAO(kbm);*/
  }

  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/

  /**
   * @return the kbm
   */
  public KnowledgeBaseManager getKbm() {
    return kbm;
  }

  /**
   * @return the affiliationDAO
   */
  public AffiliationDAO getAffiliationDAO() {
    return affiliationDAO;
  }
  public ReportDAO getReportDAO() {
	    return reportDAO;
	  }
  
  /***************************************************************************/
  /*                           Private Methods                               */
  /***************************************************************************/
}
