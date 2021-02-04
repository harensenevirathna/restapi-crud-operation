package com.futureinnovation.crud.dto.request;

import lombok.Data;

@Data
public class CustomerRequest {

    private Long id;
    private String name;
    private String address;
    private String contact;
}
