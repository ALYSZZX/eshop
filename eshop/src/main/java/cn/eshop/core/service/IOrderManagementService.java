package cn.eshop.core.service;

import java.util.List;
import java.util.Map;

import cn.eshop.core.bean.OrderDetail;
import cn.eshop.core.bean.OrderManagement;

public interface IOrderManagementService {

	public void add(OrderManagement om,List<OrderDetail> list);
	
	//订单列表
	public List<Map> list(OrderManagement om);
	
	//订单详情
	public List<Map> detailslist(OrderDetail od);
}
