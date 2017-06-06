package cn.eshop.core.service;

import java.util.List;
import java.util.Map;

import cn.eshop.core.bean.OrderDetail;
import cn.eshop.core.bean.OrderManagement;

public interface IOrderManagementService {

	//添加订单
	void add(OrderManagement om,List<OrderDetail> list);
	
	/**
	 * 修改订单
	 * @param om
	 * @param flag
	 */
	void update(OrderManagement om);
	
	//订单列表
	@SuppressWarnings("rawtypes")
	List<Map> list(OrderManagement om);
	
	//订单详情
	@SuppressWarnings("rawtypes")
	List<Map> detailslist(OrderDetail od);

	@SuppressWarnings("rawtypes")
	List<Map> getOrderDetial(OrderDetail od);

	long getCount(OrderManagement om);
	
}
