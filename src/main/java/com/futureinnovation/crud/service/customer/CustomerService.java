package com.futureinnovation.crud.service.customer;


import com.futureinnovation.crud.dto.request.CustomerRequest;
import com.futureinnovation.crud.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    /**
     * Gett All Customers
     * @return
     */

    List<CustomerResponse> getAllCustomer();

    /**
     * Create New Customer
     * @param customerRequest
     * @throws Exception
     */
    void create(CustomerRequest customerRequest) throws Exception;

    /**
     *  Update Customer
     * @param customerRequest
     * @return
     * @throws Exception
     */
    CustomerResponse update(CustomerRequest customerRequest)throws Exception;

    /**
     * Delete Customer
     * @param customerRequest
     * @throws Exception
     */
    void delete(CustomerRequest customerRequest) throws Exception;

    /**
     * Update Customer Address [HTTP PATCH requests are to make partial update on a resource]
     * @param customerRequest
     * @return
     * @throws Exception
     */
    CustomerResponse updateCustomerAddress(CustomerRequest customerRequest)throws Exception;

}
