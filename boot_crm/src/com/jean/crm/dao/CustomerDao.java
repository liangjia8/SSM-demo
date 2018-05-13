package com.jean.crm.dao;

import java.util.List;

import com.jean.crm.pojo.Customer;
import com.jean.crm.pojo.QueryVo;

public interface CustomerDao {
	List<Customer> getCustomerList(QueryVo queryVo); 
	Integer getCustomerListCount(QueryVo queryVo);
	Customer getCustomerById(Long id);
	void updateCustomer(Customer customer);
	void deleteCustomer(Long id);
}
