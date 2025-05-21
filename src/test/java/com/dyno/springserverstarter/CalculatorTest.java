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
}
