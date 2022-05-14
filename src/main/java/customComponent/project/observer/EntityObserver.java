package customComponent.project.observer;


import java.util.ArrayList;
import customComponent.model.knowledgebase.KnowledgeBaseException;

/**
 *
 * @author mjcobo
 */
public interface EntityObserver<T extends Comparable<T>> {

  public void entityUpdated(ArrayList<T> items) throws KnowledgeBaseException;
  public void entityAdded(ArrayList<T> items) throws KnowledgeBaseException;
  public void entityRemoved(ArrayList<T> items) throws KnowledgeBaseException;
  public abstract void entityRefresh() throws KnowledgeBaseException;
}