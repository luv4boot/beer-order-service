package com.luv4code.beerorderservice.services;

import com.luv4code.beerorderservice.web.model.BeerOrderDto;
import com.luv4code.beerorderservice.web.model.BeerOrderPagedList;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerOrderServiceImpl implements BeerOrderService {
    @Override
    public BeerOrderPagedList listOrders(UUID customerId, PageRequest pageable) {
        return null;
    }

    @Override
    public BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto) {
        return null;
    }

    @Override
    public BeerOrderDto getOrderById(UUID customerId, UUID orderId) {
        return null;
    }

    @Override
    public void pickupOrder(UUID customerId, UUID orderId) {

    }
}
