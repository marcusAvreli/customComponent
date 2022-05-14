package customComponent.model.knowledgebase.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.entity.Report;
/*import scimat.model.knowledgebase.entity.Author;
import scimat.model.knowledgebase.entity.AuthorGroup;
import scimat.model.knowledgebase.entity.AuthorReference;
import scimat.model.knowledgebase.entity.AuthorReferenceGroup;
import scimat.model.knowledgebase.entity.AuthorReferenceReference;
import scimat.model.knowledgebase.entity.Document;
import scimat.model.knowledgebase.entity.DocumentAuthor;
import scimat.model.knowledgebase.entity.DocumentWord;
import scimat.model.knowledgebase.entity.Journal;
import scimat.model.knowledgebase.entity.JournalSubjectCategoryPublishDate;
import scimat.model.knowledgebase.entity.Period;
import scimat.model.knowledgebase.entity.PublishDate;
import scimat.model.knowledgebase.entity.Reference;
import scimat.model.knowledgebase.entity.ReferenceGroup;
import scimat.model.knowledgebase.entity.ReferenceSource;
import scimat.model.knowledgebase.entity.ReferenceSourceGroup;
import scimat.model.knowledgebase.entity.SubjectCategory;
import scimat.model.knowledgebase.entity.Word;
import scimat.model.knowledgebase.entity.WordGroup;*/

/**
 *
 * @author mjcobo
 */
public class UtilsDAO {

  
  /***************************************************************************/
  /*                            Constructors                                 */
  /***************************************************************************/
  
  /**
   * 
   */
  private UtilsDAO() {
  }
  
  /***************************************************************************/
  /*                           Public Methods                                */
  /***************************************************************************/
  
  /**
   * 
   * @return 
   */
  public static UtilsDAO getInstance() {
    return UtilsDAOHolder.INSTANCE;
  }
  
  /**
   * 
   */
  private static class UtilsDAOHolder {

    private static final UtilsDAO INSTANCE = new UtilsDAO();
  }
  
  /**
   * 
   * @param rs
   * @return
   * @throws SQLException 
   */
  public Affiliation getAffiliation(ResultSet rs) throws SQLException {

    return new Affiliation(rs.getInt("id"),
            rs.getString("name"),
            1,
            1);
  }
  public Report getReport(ResultSet rs) throws SQLException {

	    return new Report(rs.getString("name"),
	            rs.getString("description"),
	            rs.getInt("id")
	            );
	  }

  /**
   * 
   * @param rs
   * @return
   * @throws SQLException 
   */
  public Integer getAffiliationID(ResultSet rs) throws SQLException {

    return rs.getInt("idAffiliation");
  }
  
  /**
   * 
   * @param rs
   * @return
   * @throws SQLException 
   */

}
