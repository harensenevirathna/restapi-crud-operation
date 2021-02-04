package com.futureinnovation.crud.controller;

import com.futureinnovation.crud.dto.request.CustomerRequest;
import com.futureinnovation.crud.dto.response.CustomerResponse;
import com.futureinnovation.crud.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/crud")
public class CrudController {

    private final CustomerService customerService;

    @Autowired
    CrudController(CustomerService customerService){
        this.customerService = customerService;
    }

    /**
     * Gett All Customers
     * @return
     */
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomer(){
        return  ResponseEntity.ok(customerService.getAllCustomer());
    }

    /**
     * Create New Customer
     * @param customerRequest
     * @return
     * @throws Exception
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> create(@RequestBody CustomerRequest customerRequest) throws Exception{
        customerService.create(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Update Customer
     * @param customerRequest
     * @return
     * @throws Exception
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerResponse> update(@RequestBody CustomerRequest customerRequest)throws Exception{
        return ResponseEntity.ok(customerService.update(customerRequest));
    }

    /**
     * Delete Customer
     * @param customerRequest
     * @return
     * @throws Exception
     */
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Void> delete(@RequestBody CustomerRequest customerRequest)throws Exception{
       customerService.delete(customerRequest);
       return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**
     * Update Customer Address [HTTP PATCH requests are to make partial update on a resource]
     * @param customerRequest
     * @return
     * @throws Exception
     */
    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerResponse> updateCustomerAddress(@RequestBody CustomerRequest customerRequest)throws Exception{
        return ResponseEntity.ok(customerService.updateCustomerAddress(customerRequest));
    }

}
