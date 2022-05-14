package customComponent.knowledgebaseevents.event;

import customComponent.model.knowledgebase.KnowledgeBaseException;

/**
 *
 * @author mjcobo
 */
public interface KnowledgeBaseEvent {
  
  public void fireEvent() throws KnowledgeBaseException; 
}