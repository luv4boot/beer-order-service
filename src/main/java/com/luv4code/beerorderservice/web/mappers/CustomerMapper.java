package com.luv4code.beerorderservice.web.mappers;

import com.lfc.brewery.model.CustomerDto;
import com.luv4code.beerorderservice.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CustomerMapper {
    CustomerDto customerToDto(Customer customer);

    Customer dtoToCustomer(Customer dto);
}