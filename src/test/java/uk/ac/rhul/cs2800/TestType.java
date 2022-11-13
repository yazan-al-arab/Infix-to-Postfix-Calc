package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestType {

  Type type;


  /*
   * Test 26
   * 
   * Added the corresponding "invalid", "number" (and so on) next to the Enum values.
   * 
   * Created a constructor and a String field
   * 
   * Created a toString method which returns the String field
   * 
   */
  @Test
  void testToString() {
    type = Type.INVALID;
    assertEquals(type.toString(), "invalid", "The invalid type should return \"invalid\"");

    type = Type.NUMBER;
    assertEquals(type.toString(), "number", "The number type should return \"number\"");

    type = Type.STRING;
    assertEquals(type.toString(), "string", "The string type should return \"string\"");

    type = Type.SYMBOL;
    assertEquals(type.toString(), "symbol", "The string type should return \"symbol\"");

  }

  /*
   * The next tests are in TestSymbol.java class
   */

}
