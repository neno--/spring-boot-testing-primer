package com.github.nenomm.springboottestingprimer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JustASimpleTest {

  public JustASimpleTest() {
    System.out.println("Instanciram ovo");
  }

  @BeforeEach
  public void beforeEach() {
    System.out.println("beforeEach");
  }

  @BeforeAll
  public static void beforeAll() {
    System.out.println("beforeAll");
  }

  @Test
  public void firstTest() {
    System.out.println("firstTest");
  }

  @Test
  public void secondTest() {
    System.out.println("secondTest");
  }

}
