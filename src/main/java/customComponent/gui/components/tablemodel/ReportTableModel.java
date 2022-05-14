package customComponent.gui.components.tablemodel;

import customComponent.model.knowledgebase.entity.Affiliation;
import customComponent.model.knowledgebase.entity.Report;

public class ReportTableModel extends GenericDynamicTableModel<Report> {

	  /***************************************************************************/
	  /*                        Private attributes                               */
	  /***************************************************************************/

	  /***************************************************************************/
	  /*                            Constructors                                 */
	  /***************************************************************************/

	  /**
	   *
	   */
	  public ReportTableModel() {
	    super(new String[] {"ID", "Name", "Description"});
	   
	  }

	  /***************************************************************************/
	  /*                           Public Methods                                */
	  /***************************************************************************/

	  /**
	   *
	   * @param rowIndex
	   * @param columnIndex
	   * @return
	   */
	  @Override
	  public Object getValueAt(int rowIndex, int columnIndex) {

	    if ((rowIndex >= 0) && (rowIndex < getRowCount())) {

	      Report report = getItem(rowIndex);

	      switch (columnIndex) {

	        case 0:
	          return report.getId();

	        case 1:
	          return report.getName();

	        case 2:
	          return report.getDescription();

	      

	        default:
	          return "";
	      }

	    } else {

	      return "";

	    }
	  }

	  /***************************************************************************/
	  /*                           Private Methods                               */
	  /***************************************************************************/
	}
