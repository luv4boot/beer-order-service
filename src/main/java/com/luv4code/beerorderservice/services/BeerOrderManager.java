package com.luv4code.beerorderservice.services;

import com.luv4code.beerorderservice.domain.BeerOrder;

public interface BeerOrderManager {
    BeerOrder newBeerOrder(BeerOrder beerOrder);
}
