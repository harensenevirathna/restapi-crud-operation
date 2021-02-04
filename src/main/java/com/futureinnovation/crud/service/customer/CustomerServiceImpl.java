package com.futureinnovation.crud.service.customer;

import com.futureinnovation.crud.domain.Customer;
import com.futureinnovation.crud.dto.request.CustomerRequest;
import com.futureinnovation.crud.dto.response.CustomerResponse;
import com.futureinnovation.crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     *  Gett All Customers
     * @return
     */

    @Override
    public List<CustomerResponse> getAllCustomer() {
        return customerRepository.findAll().stream().map(CustomerResponse::new).collect(Collectors.toList());
    }

    /**
     * Create New Customer
     * @param customerRequest
     * @throws Exception
     */
    @Override
    public void create(CustomerRequest customerRequest) throws Exception {
        Optional<Customer> exsistingCustomer = customerRepository.findByName(customerRequest.getName());
        if (!exsistingCustomer.isPresent()) {
            Customer customer = new Customer();
            customer.setName(customerRequest.getName());
            customer.setAddress(customerRequest.getAddress());
            customer.setContact(customerRequest.getContact());
            customerRepository.save(customer);
        } else {

        }
    }

    /**
     * Update Customer
     * @param customerRequest
     * @return
     * @throws Exception
     */
    @Override
    public CustomerResponse update(CustomerRequest customerRequest) throws Exception {
        Optional<Customer> exsistingCustomer = customerRepository.findById(customerRequest.getId());
        if (exsistingCustomer.isPresent()) {
            exsistingCustomer.get().setContact(customerRequest.getContact());
            exsistingCustomer.get().setAddress(customerRequest.getAddress());
            customerRepository.save(exsistingCustomer.get());
            return new CustomerResponse(exsistingCustomer.get());
        } else {
            return null;
        }

    }

    /**
     * Delete Customer
     * @param customerRequest
     * @throws Exception
     */
    @Override
    public void delete(CustomerRequest customerRequest) throws Exception {
        Optional<Customer> exsistingCustomer = customerRepository.findById(customerRequest.getId());
        if (exsistingCustomer.isPresent()) {
            customerRepository.delete(exsistingCustomer.get());
        } else {

        }
    }

    /**
     * Update Customer Address [HTTP PATCH requests are to make partial update on a resource]
     * @param customerRequest
     * @return
     * @throws Exception
     */
    @Override
    public CustomerResponse updateCustomerAddress(CustomerRequest customerRequest) throws Exception {
        Optional<Customer> exsistingCustomer = customerRepository.findById(customerRequest.getId());
        if (exsistingCustomer.isPresent()) {
            exsistingCustomer.get().setAddress(customerRequest.getAddress());
            customerRepository.save(exsistingCustomer.get());
            return new CustomerResponse(exsistingCustomer.get());
        } else {
            return null;
        }
    }
}
