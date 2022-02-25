package com.luv4code.beerorderservice.services;

import com.luv4code.beerorderservice.web.model.BeerOrderDto;
import com.luv4code.beerorderservice.web.model.BeerOrderPagedList;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerOrderService {
    BeerOrderPagedList listOrders(UUID customerId, PageRequest pageable);

    BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto);

    BeerOrderDto getOrderById(UUID customerId, UUID orderId);

    void pickupOrder(UUID customerId, UUID orderId);
}
