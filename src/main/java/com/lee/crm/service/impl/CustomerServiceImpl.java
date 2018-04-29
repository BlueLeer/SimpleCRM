package com.lee.crm.service.impl;

import com.lee.crm.dao.DaoInterface;
import com.lee.crm.model.Customer;
import com.lee.crm.service.CustomerException;
import com.lee.crm.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description:
 */
@Component("customerService")
public class CustomerServiceImpl implements CustomerServiceInterface {
    @Resource(name = "baseDao")
    private DaoInterface<Customer> mDaoInterface;

    @Override
    public void addCustomer(Customer customer) throws CustomerException {
        try {
            mDaoInterface.add(customer);
        } catch (Exception e) {
            throw new CustomerException("插入用户失败!");
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        mDaoInterface.delete(customer);
    }

    @Override
    public void deleteCustomerById(Long custId) {
        String hql = "delete from Customer where custId = " + custId;
        mDaoInterface.executeHql(hql);
    }

    @Override
    public void updateCustomer(Customer customer) {
        mDaoInterface.update(customer);
    }

    @Override
    public Customer findCustomerById(Long custId) {
        String hql = "from Customer where cust_id = ?";
        return mDaoInterface.get(hql, custId);
    }

    @Override
    public List<Customer> findAllCustomers() throws CustomerException {
        String hql = "from Customer";
        try {

            List<Customer> list = mDaoInterface.find(hql);
            return list;
        } catch (Exception e) {
            throw new CustomerException("显示所有客户失败!");
        }

    }

    /**
     * 暂未实现
     *
     * @param customerWithCondition
     * @return
     */
    @Override
    public List<Customer> findByConditions(Customer customerWithCondition) {
        return null;
    }
}
