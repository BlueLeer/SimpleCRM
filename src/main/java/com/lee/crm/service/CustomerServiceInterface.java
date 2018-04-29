package com.lee.crm.service;

import com.lee.crm.model.Customer;

import java.util.List;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description:
 */
public interface CustomerServiceInterface {
    void addCustomer(Customer customer) throws CustomerException;

    void deleteCustomer(Customer customer);

    void deleteCustomerById(Long custId);

    void updateCustomer(Customer customer);

    Customer findCustomerById(Long custId);

    List<Customer> findAllCustomers() throws CustomerException;

    List<Customer> findByConditions(Customer customerWithCondition);

}
