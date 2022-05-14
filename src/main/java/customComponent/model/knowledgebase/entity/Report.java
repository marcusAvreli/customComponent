package customComponent.model.knowledgebase.entity;

import java.io.Serializable;

public class Report implements Serializable, Comparable<Report>, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String description;
	Integer id;
	boolean disabled;
	
	public Report(String name,String description,Integer id) {
		this.name=name;
		this.description = description;
		this.id=id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	public int compareTo(Report o) {
		return this.id.compareTo(o.id);
	
	}
	@Override
	  public int hashCode() {
	    return this.id;
	  }

	 
}
