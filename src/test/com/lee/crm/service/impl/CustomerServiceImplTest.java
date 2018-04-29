package com.lee.crm.service.impl;

import com.lee.crm.model.Customer;
import com.lee.crm.service.CustomerException;
import com.lee.crm.service.CustomerServiceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceInterface mCustomerServiceInterface;

    @Test
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setCustName("wangle");
        try {
            mCustomerServiceInterface.addCustomer(customer);
        } catch (CustomerException e) {
            e.printStackTrace();
        }
    }
}