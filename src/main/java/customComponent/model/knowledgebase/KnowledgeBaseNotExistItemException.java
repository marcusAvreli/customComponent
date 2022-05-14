package customComponent.model.knowledgebase;


/**
 *
 * @author mjcobo
 */
public class KnowledgeBaseNotExistItemException extends Exception {

  /**
   * Creates a new instance of <code>KnowledgeBaseNotExistItemException</code>
   * without detail message.
   */
  public KnowledgeBaseNotExistItemException() {

  }

  /**
   * Constructs an instance of <code>KnowledgeBaseNotExistItemException</code>
   * with the specified detail message.
   *
   * @param message the detail message.
   */
  public KnowledgeBaseNotExistItemException(String message) {
    super(message);
  }

  /**
   * Constructs an instance of <code>KnowledgeBaseNotExistItemException</code> with the
   * specified detail cause.
   *
   * @param cause the cause (which is saved for later retrieval by the
   *              <code>KnowledgeBaseNotExistItemException.getCause()</code>
   *              method). (A null value is permitted, and indicates that the
   *              cause is nonexistent or unknown.)
   */
  public KnowledgeBaseNotExistItemException(Throwable cause) {
    super(cause);
  }

  /**
   * Constructs an instance of <code>KnowledgeBaseNotExistItemException</code> with the
   * specified detail cause.
   *
   * @param message the detail message.
   * @param cause the cause (which is saved for later retrieval by the
   *              <code>KnowledgeBaseNotExistItemException.getCause()</code>
   *              method). (A null value is permitted, and indicates that the
   *              cause is nonexistent or unknown.)
   */
  public KnowledgeBaseNotExistItemException(String message, Throwable cause) {
    super(message, cause);
  }
}
