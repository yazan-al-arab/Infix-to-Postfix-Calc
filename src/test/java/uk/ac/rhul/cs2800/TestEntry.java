package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.Test;

class TestEntry {

  private MyEntry ent;

  /*
   * I created the Symbols Enum with the required values declared inside. I created the Type Enum
   * with the required values declared inside.
   * 
   */

  /*
   * Test 14
   * 
   * Created new Entry constructor to allow a Symbol argument.
   * 
   */
  @Test
  void testConstructSymbol() {
    ent = new MyEntry(Symbol.LEFT_BRACKET); // Can be any symbol
  }


  /*
   * Test 15
   * 
   * Created new method getSymbol()
   * 
   * Update 1: Modified the constructor to initialise the type variable to the corresponding
   * argument type and added a "throws BadTypeException" to this test.
   * 
   */
  @Test
  void createSymbol_Then_getSymbol() throws BadTypeException {
    ent = new MyEntry(Symbol.DIVIDE);
    assertEquals(ent.getSymbol(), Symbol.DIVIDE,
        "Should return a Symbol.DIVIDE value as this was the type used when calling the constructor.");
  }

  /*
   * Test 16
   * 
   * No modifications were needed to make this work as all the code to perform this was already
   * created in a test inside the TestMyStack class.
   * 
   */
  @Test
  void createFloat_Then_getFloat() throws BadTypeException {
    ent = new MyEntry(0.1f);
    assertEquals(ent.getValue(), 0.1f, 0.001f,
        "Should return a Symbol.DIVIDE value as this was the type used when calling the constructor.");
  }

  /*
   * Test 17
   * 
   * Created an Entry constructor which accepts a string argument. Created a getString() method
   * which returns the str variable.
   * 
   * Update 1: Modify Entry constructor (for string entries) to set the type variable to Type.STRING
   * and added a "throws BadTypeException" to this test.
   * 
   */
  @Test
  void createString_Then_getString() throws BadTypeException {
    ent = new MyEntry("Test");
    assertEquals(ent.getString(), "Test",
        "Should return a Symbol.DIVIDE value as this was the type used when calling the constructor.");
  }

  /*
   * Test 18
   * 
   * Created BadTypeException
   * 
   * Created the Enum called Type
   * 
   * Modified the constructor to initialise the Type to whichever it belongs to; e.g. new
   * Entry(0.1f) will set the variable 'type' to Type.NUMBER
   * 
   * What changes were made to previous tests?: Test 'getValueOfSymbol()' -> Update 1
   */
  @Test
  void createFloat_Then_getSymbol() { // Purpose is to test getSymbol to throw an exception
    ent = new MyEntry(0.1f);

    assertThrows(BadTypeException.class, () -> ent.getSymbol(),
        "A BadTypeException should be thrown because the constructor type doesn't match the method being called.");
  }

  /*
   * Test 19
   * 
   * Modified the getValue() method to check if the Type of the entry is Type.NUMBER and decide to
   * throw an exception or not.
   * 
   */
  @Test
  void createSymbol_Then_getValue() { // Purpose is to test getValue to throw an exception
    ent = new MyEntry(Symbol.PLUS); // Can be any symbol

    assertThrows(BadTypeException.class, () -> ent.getValue(),
        "A BadTypeException should be thrown.");
  }

  /*
   * Test 20
   * 
   * Added "throws BadTypeException" to getString()
   * 
   * Added if statement to check if the entry is of the string type.
   * 
   */
  @Test
  void createSymbol_Then_getString() { // Purpose is to test getString to throw an exception
    ent = new MyEntry(Symbol.PLUS); // Can be any symbol

    assertThrows(BadTypeException.class, () -> ent.getString(),
        "A BadTypeException should be thrown.");
  }
  
  
  /* Test 29 (Yes, 29. I came back to add this later on, just before Test 30 in TestMyStack.class)
   * 
   * Created a getType() method in Entry class.
   * All it does is return the type field.
   * 
   */
  @Test
  void createAllTypes_Then_getType() {
    ent = new MyEntry(Symbol.PLUS);
    assertEquals(Type.SYMBOL, ent.getType());
    
    ent = new MyEntry(5.0f);
    assertEquals(Type.NUMBER, ent.getType());
    
    ent = new MyEntry("Test String");
    assertEquals(Type.STRING, ent.getType());
  }

  /*
   * Test 21
   * 
   * All that was required was to generate an equals() method using Eclipse
   * 
   */
  @Test
  void testEquals() {
    // float
    ent = new MyEntry(0.1f);
    assertTrue(ent.equals(ent));

    // string
    ent = new MyEntry("Test Equals");
    assertTrue(ent.equals(ent));

    // symbol
    ent = new MyEntry(Symbol.RIGHT_BRACKET);
    assertTrue(ent.equals(ent));


    MyEntry ent2;

    // float
    ent = new MyEntry(0.1f);
    ent2 = new MyEntry(5.5f);
    assertFalse(ent.equals(ent2));

    // string
    ent = new MyEntry("Lorem ipsum dolor sit amet");
    ent2 = new MyEntry("consectetur adipiscing elit");
    assertFalse(ent.equals(ent2));

    // symbol
    ent = new MyEntry(Symbol.DIVIDE);
    ent2 = new MyEntry(Symbol.INVALID);
    assertFalse(ent.equals(ent2));

  }

  /*
   * Test 22
   * 
   * No additional code was needed to make this test pass
   * 
   */
  @Test
  void furtherTestFloatEquals() {
    ent = new MyEntry(1.1f); // float
    MyEntry ent2 = new MyEntry(7); // integer
    assertFalse(ent.equals(ent2));

    ent2 = new MyEntry(1.09f);
    assertFalse(ent.equals(ent2));
  }


  /*
   * Test 23
   * 
   * No additional code was needed to make this test pass
   * 
   */
  @Test
  void testCrossEquals() {
    ent = new MyEntry(1.0f);
    MyEntry ent2 = new MyEntry(Symbol.DIVIDE);
    assertFalse(ent.equals(ent2));

    ent = new MyEntry("Does a symbol object equal this string?");
    assertFalse(ent.equals(ent2));
  }

  /*
   * Test 24
   * 
   * All that was required was to generate a hashCode() method using Eclipse
   * 
   */
  @Test
  void testHashCode() {
    ent = new MyEntry("I am an entry object");
    assertTrue(ent.hashCode() == Objects.hashCode(ent));

  }

  /*
   * Test 25
   * 
   * Generated a toString method using Eclipse
   * 
   */
  @Test
  void testToString() {
    ent = new MyEntry("String entry");
    assertEquals(ent.toString(), ("Entry [number=0.0" + ", str=" + "String entry" + ", type="
        + "string" + ", other=" + null + "]"));
  }
  
  /*
   * The next tests are in TestType.java class
   * 
   */
  
  /* Test 33
   * 
   * No additional code was needed to make this test pass.
   * 
   */
  @Test
  void inputtingInvalidTypes_And_MixedTypes() {
    ent = new MyEntry(false);
    assertTrue(ent.getType() == Type.INVALID, "A boolean input should create an INVALID type.");
    
    ent = new MyEntry('c');
    assertTrue(ent.getType() == Type.INVALID, "A should create an INVALID type.");
    
    ent = new MyEntry(23234 + "Test String" + Symbol.MINUS);
    assertTrue(ent.getType() == Type.STRING, "A boolean input should create an INVALID type.");
  } 
}
