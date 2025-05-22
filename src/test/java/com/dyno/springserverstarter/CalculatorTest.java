package com.dyno.springserverstarter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
  private final Calculator calculator = new Calculator();

  @Test
  void testAddition() {
    int result = calculator.add(2, 3);
    assertEquals(5, result, "2 + 3 should equal 5");
  }
  
  @Test
  void testMultiplication() {
    int result = calculator.multiply(2, 3);
    assertEquals(6, result, "2 * 3 should equal 6");
  }
  
  @Test
  void testDivision() {
    int result = calculator.divide(6, 3);
    assertEquals(2, result, "6 / 3 should equal 2");
  }
  
  @Test
  void testDivisionByZero() {
    assertThrows(ArithmeticException.class, () -> {
      calculator.divide(6, 0);
    }, "Division by zero should throw ArithmeticException");
  }
  
  @Test
  void testSubtraction() {
    int result = calculator.subtract(6, 3);
    assertEquals(3, result, "6 - 3 should equal 3");
  }
  
  @Test
  void testModulus() {
    int result = calculator.modulus(7, 3);
    assertEquals(1, result, "7 % 3 should equal 1");
  }
  
  @Test
  void testModulusByZero() {
    assertThrows(ArithmeticException.class, () -> {
      calculator.modulus(7, 0);
    }, "Modulus by zero should throw ArithmeticException");
  }
}
