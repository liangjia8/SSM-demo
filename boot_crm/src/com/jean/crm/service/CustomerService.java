package com.jean.crm.service;

import com.jean.crm.pojo.Customer;
import com.jean.crm.pojo.QueryVo;
import com.jean.crm.util.Page;

public interface CustomerService {

	Page<Customer> getCustomerList(QueryVo queryVo);
	Customer getCustomerById(Long id);
	void updateCustomer(Customer customer);
	void deleteCustomer(Long id);
}
