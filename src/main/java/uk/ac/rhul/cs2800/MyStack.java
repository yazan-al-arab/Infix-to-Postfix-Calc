package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import uk.ac.rhul.cs2800.MyEntry;

/**
 * Stores a stack of entries. It provides methods like push() and pop() to
 * simulate a stack experience.
 * 
 * @author yazan
 *
 */

@SuppressWarnings("unused")
public class MyStack {

  /**
   * Creates an array list of entries.
   */
  private List<MyEntry> ent = new ArrayList<MyEntry>();

  /**
   * Stores a stack of entries. It provides methods like push() and pop() to simulate a stack
   * experience.
   * 
   * @author yazan
   *
   */
  public MyStack() {
  }

  /**
   * Creates a size of integer value. This behaves as an index in the array list
   * declared above.
   */
  private int size = 0; // Defines how many entries are in the ArrayList - also behaves as an index.

  /**
   * A getter for the size value.
   * 
   * @return the size of the Entry array list.
   */
  public int size() {
    return size;
  }

  /**
   * Adds an item to the stack.
   * 
   * @param f is the argument used to construct an Entry instance.
   */
  public void push(Object f) {
    MyEntry newEntry = new MyEntry(f);
    ent.add(newEntry);
    size++;
  }

  /**
   * Adds a pre-existing Entry item to the stack.
   * 
   * @param entry is the Entry instance which will be added to the stack.
   */
  public void push(MyEntry entry) {
    ent.add(entry);
    size++;
  }

  /**
   * Returns the top value without removing it from the stack.
   * 
   * @return the last value pushed.
   */
  public MyEntry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return ent.get(size - 1);
  }

  /**
   * Returns the pop value while removing it from the stack.
   * 
   * @return the last value pushed.
   */
  public MyEntry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return ent.remove(--size);
  }

}
