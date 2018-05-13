package com.jean.crm.web.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jean.crm.pojo.BaseDict;
import com.jean.crm.pojo.Customer;
import com.jean.crm.pojo.QueryVo;
import com.jean.crm.service.BaseDictService;
import com.jean.crm.service.CustomerService;
import com.jean.crm.util.Page;

/**
 * 客户管理
 * 
 * @author Jean
 *
 */
@Controller
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;

	@Value("${customer.source.code}")
	private String custSourceCode;

	@Value("${customer.industry.code}")
	private String custIndustryCode;

	@Value("${customer.level.code}")
	private String custLevelCode;

	@RequestMapping("/customer/list")
	public String showCustomer(QueryVo queryVo,Model model) throws Exception {
		if(StringUtils.isNotBlank(queryVo.getCustName())) {
			queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO8859-1"),"UTF-8"));
		}
		// 初始化客户来源
		List<BaseDict> sourceList = baseDictService.getDictListByTypeCode(custSourceCode);
		// 初始化客户行业
		List<BaseDict> industryList = baseDictService.getDictListByTypeCode(custIndustryCode);
		// 初始化客户级别
		List<BaseDict> levelList = baseDictService.getDictListByTypeCode(custLevelCode);
		//把字典信息传递给页面
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		//根据查询条件查询客户列表
		Page<Customer> page = customerService.getCustomerList(queryVo);
		//把客户列表传递给页面
		model.addAttribute("page", page);
		//参数回显
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		return "customer";
	}
	
	@RequestMapping("/customer/edit")
	@ResponseBody
	public Customer getCustomerById(Long id) {
		return customerService.getCustomerById(id);
	}
	
	@RequestMapping(value="/customer/update", method=RequestMethod.POST)
	@ResponseBody
	public String updateCustomer(Customer customer) {
		customerService.updateCustomer(customer);
		return "success";
	}
	
	@RequestMapping("/customer/delete")
	@ResponseBody
	public String deleteCustomer(Long id) {
		customerService.deleteCustomer(id);
		return "success";
	}
}
