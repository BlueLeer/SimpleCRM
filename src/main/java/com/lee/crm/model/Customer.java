package com.lee.crm.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/14
 * @Description: 客户实体类
 */

@Entity
@Table(name = "crm_customer")
public class Customer implements Serializable {
    private Long custId; // 客户ID
    private String custName; // 客户名称
    private Integer custLevel; // 客户级别
    private String custSource; // 信息来源
    private String custLinkMan; // 联系人
    private String custPhone; // 固定电话
    private String custMobile; // 移动电话
    private String custAddress; // 联系地址
    private String custZip; // 邮政编码
    private String custFax; // 客户传真
    private String custWebsite;// 客户网址


    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Column(name = "cust_level")
    public Integer getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(Integer custLevel) {
        this.custLevel = custLevel;
    }

    @Column(name = "cust_source")
    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    @Column(name = "cust_linkman")
    public String getCustLinkMan() {
        return custLinkMan;
    }

    public void setCustLinkMan(String custLinkMan) {
        this.custLinkMan = custLinkMan;
    }

    @Column(name = "cust_phone")
    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Column(name = "cust_mobile")
    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    @Column(name = "cust_address")
    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Column(name = "cust_zip")
    public String getCustZip() {
        return custZip;
    }

    public void setCustZip(String custZip) {
        this.custZip = custZip;
    }

    @Column(name = "cust_fax")
    public String getCustFax() {
        return custFax;
    }

    public void setCustFax(String custFax) {
        this.custFax = custFax;
    }

    @Column(name = "cust_website")
    public String getCustWebsite() {
        return custWebsite;
    }

    public void setCustWebsite(String custWebsite) {
        this.custWebsite = custWebsite;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custLevel=" + custLevel +
                ", custSource='" + custSource + '\'' +
                ", custLinkMan='" + custLinkMan + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custMobile='" + custMobile + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custZip='" + custZip + '\'' +
                ", custFax='" + custFax + '\'' +
                ", custWebsite='" + custWebsite + '\'' +
                '}';
    }
}
