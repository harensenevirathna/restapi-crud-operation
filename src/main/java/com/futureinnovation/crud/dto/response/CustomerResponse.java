package com.futureinnovation.crud.dto.response;

import com.futureinnovation.crud.domain.Customer;
import lombok.Data;

@Data
public class CustomerResponse {

    private Long id;
    private String name;
    private String address;
    private String contact;

    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.contact = customer.getContact();
    }
}
