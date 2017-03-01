package cn.eshop.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.eshop.core.bean.ConsigneeManagement;
import cn.eshop.core.dao.ConsigneeManagementDAO;
import cn.eshop.core.service.IConsigneeManagementService;

@Service
@Transactional
public class ConsigneeManagementServiceImpl implements IConsigneeManagementService{

	@Autowired
	private ConsigneeManagementDAO dao;
	
	public List<Map> getlist(ConsigneeManagement cm) {
		// TODO Auto-generated method stub
		return dao.getlist(cm);
	}

	
	public void add(ConsigneeManagement cm) {
		dao.add(cm);
	}


	public void delete(ConsigneeManagement cm) {
		dao.delete(cm);
	}


	public void update(ConsigneeManagement cm) {
		dao.update(cm);
	}


	public Map getInfo(ConsigneeManagement cm) {
		
		return dao.getInfo(cm);
	}

}
