package com.luv4code.beerorderservice.services.beer;

import com.luv4code.beerorderservice.web.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Optional<BeerDto> getBeerById(UUID uuid);

    Optional<BeerDto> getBeerByUpc(String upc);
}
