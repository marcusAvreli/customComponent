package customComponent.gui.commands;


/**
 * Interfaz para las tareas del sistema que no se deshacen.
 * No es estrictamente necesaria pero si muy recomendable.
 *
 * @author mjcobo
 */
public interface NoUndoableTask {
  
  public void execute();
}