package com.luv4code.beerorderservice.services;

import com.lfc.brewery.model.BeerOrderDto;
import com.luv4code.beerorderservice.domain.BeerOrder;

import java.util.UUID;

public interface BeerOrderManager {
    BeerOrder newBeerOrder(BeerOrder beerOrder);

    void processValidationResult(UUID beerOrderId, Boolean isValid);

    void beerOrderAllocationPassed(BeerOrderDto beerOrder);

    void beerOrderAllocationPendingInventory(BeerOrderDto beerOrder);

    void beerOrderAllocationFailed(BeerOrderDto beerOrder);
}
