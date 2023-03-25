package com.github.nenomm.springboottestingprimer.junitandmockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PricingServiceTest {

  @Mock
  private InventoryService inventoryService;

  @InjectMocks
  private PricingService pricingService;

  @Captor
  private ArgumentCaptor<Integer> integerArgumentCaptor;


  @Test
  public void shouldReturnHigherPriceIfItemIsSparse() {
    when(inventoryService.isItemSparse(anyInt())).thenReturn(true);

    final BigDecimal result = pricingService.calculatePrice(10000);

    verify(inventoryService).isItemSparse(integerArgumentCaptor.capture());

    assertEquals(new BigDecimal("100"), result);
    assertEquals(10000, integerArgumentCaptor.getAllValues().get(0));
  }

}
