package com.github.nenomm.springboottestingprimer.junitandmockito;

import java.math.BigDecimal;

public class PricingService {

  private final InventoryService inventoryService;

  public PricingService(InventoryService inventoryService) {
    this.inventoryService = inventoryService;
  }

  BigDecimal calculatePrice(int productId) {
    if (inventoryService.isItemSparse(productId)) {
      return new BigDecimal("100");
    } else {
      return new BigDecimal("70");
    }
  }
}
