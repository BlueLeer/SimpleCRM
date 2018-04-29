package com.lee.crm.action;

import com.lee.crm.model.Customer;
import com.lee.crm.service.CustomerException;
import com.lee.crm.service.CustomerServiceInterface;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description:
 */
public class CustomerAction extends BaseAction implements ModelDriven<Customer> {
    private Customer customer = new Customer();

    @Resource(name = "customerService")
    private CustomerServiceInterface mCustomerService;

    /**
     * 添加一个Customer
     *
     * @return
     */
    public String add() {
        try {
            mCustomerService.addCustomer(customer);
            getRequest().put("msg", "插入用户成功!");

        } catch (CustomerException e) {
            e.printStackTrace();
            getRequest().put("msg", e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }


    /**
     * 显示联客户列表
     *
     * @return
     */
    public String list() {
        try {
            List<Customer> customers = mCustomerService.findAllCustomers();
            getRequest().put("customers", customers);
            getRequest().put("msg", "展示用户成功!");
        } catch (CustomerException e) {
            e.printStackTrace();
            getRequest().put("msg", "展示用户失败!");
            return "list_error";
        }

        return "list_success";

    }

    /**
     * 修改客户
     *
     * @return
     */
    public String preUpdate() {
        // 从request属性值的map中获取custId属性值
        Long custId = (Long) getRequest().get("custId");
        Customer customer = mCustomerService.findCustomerById(custId);
        // 将查询出来的Customer存入request中,显示到update.jsp页面中
        getRequest().put("customer", customer);
        return "success";
    }

    /**
     * 更新客户
     *
     * @return
     */
    public String update() {
        mCustomerService.updateCustomer(customer);
        return "success";
    }

    public String delete() {
        Long custId = (Long) getRequest().get("custId");
        mCustomerService.deleteCustomerById(custId);
        return "success";
    }

    @Override
    public Customer getModel() {
        return customer;
    }

}
