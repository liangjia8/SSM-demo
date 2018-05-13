package com.jean.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.crm.dao.CustomerDao;
import com.jean.crm.pojo.Customer;
import com.jean.crm.pojo.QueryVo;
import com.jean.crm.service.CustomerService;
import com.jean.crm.util.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Page<Customer> getCustomerList(QueryVo queryVo) {
		// 计算分页起始记录
		if(queryVo.getPage()!=null) {
			queryVo.setStart((queryVo.getPage()-1) * queryVo.getSize());
		}
		List<Customer> customerList = customerDao.getCustomerList(queryVo);
		//创建一个page对象
		Page<Customer> page = new Page<>();
		page.setRows(customerList);
		Integer count = customerDao.getCustomerListCount(queryVo);
		page.setTotal(count);
		page.setSize(queryVo.getSize());
		page.setPage(queryVo.getPage());
		return page;
	}

	@Override
	public Customer getCustomerById(Long id) {
		
		return customerDao.getCustomerById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(Long id) {
		customerDao.deleteCustomer(id);
	}

}
