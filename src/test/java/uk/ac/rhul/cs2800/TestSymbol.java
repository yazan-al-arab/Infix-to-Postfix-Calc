package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestSymbol {

  Symbol symbol;


  /*
   * Test 27
   * 
   * Added the corresponding "*", "+" (and so on) next to the Enum values.
   * 
   * Created a constructor and a String field
   * 
   * Created a toString method which returns the String field
   * 
   */
  @Test
  void testToString() {
    symbol = Symbol.DIVIDE;
    assertEquals(symbol.toString(), "/", "The divide symbol should return \"/\""); // returns
                                                                                   // "/"

    symbol = Symbol.INVALID;
    assertEquals(symbol.toString(), "invalid", "The invalid symbol should return \"invalid\""); // returns
                                                                                                // "invalid"

    symbol = Symbol.LEFT_BRACKET;
    assertEquals(symbol.toString(), "(", "The left bracket symbol should return \"(\""); // returns
                                                                                         // "("

    symbol = Symbol.MINUS;
    assertEquals(symbol.toString(), "-", "The minus symbol should return \"-\""); // returns
                                                                                  // "-"

    symbol = Symbol.PLUS;
    assertEquals(symbol.toString(), "+", "The plus symbol should return \"+\""); // returns
                                                                                 // "+"

    symbol = Symbol.RIGHT_BRACKET;
    assertEquals(symbol.toString(), ")", "The right bracket symbol should return \")\""); // returns
    // ")"

    symbol = Symbol.TIMES;
    assertEquals(symbol.toString(), "*", "The times symbol should return \"*\""); // returns
                                                                                  // "*"
  }
  
  /*
   * The next tests are back in TestMyStack class.
   * 
   */


}
