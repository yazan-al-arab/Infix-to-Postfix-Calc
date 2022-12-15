package uk.ac.rhul.cs2800;

/**
 * Defines what methods must be inside all observers. Connects events to
 * different classes and methods.
 * 
 * @author yazan
 */
@FunctionalInterface
public interface Observer {

  /**
   * Functionally defined in the controller and the view.
   */
  public void notifyObservers();

}
