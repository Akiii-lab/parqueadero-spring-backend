package com.parking.entities;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMapper {

    //Cliente to DTO
    CustomerDTO customerToCustomerDTO(Customer customer);

    //DTO to cliente
    @Mapping(target = "id", ignore = true)
    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    //tosaveDTO to cliente

    @Mapping(target = "id", ignore = true)
    Customer customerTosaveDtoToCustomer(CustomerTosaveDto customerTosaveDto);

    //cliente to tosaveDTO
    CustomerTosaveDto customerToCustomerTosaveDto(Customer customer);
}
