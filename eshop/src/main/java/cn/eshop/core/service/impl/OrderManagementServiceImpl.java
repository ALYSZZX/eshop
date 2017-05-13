package cn.eshop.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.eshop.core.bean.OrderDetail;
import cn.eshop.core.bean.OrderManagement;
import cn.eshop.core.dao.OrderDetailDAO;
import cn.eshop.core.dao.OrderManagementDAO;
import cn.eshop.core.service.IOrderManagementService;

@Service
@Transactional
public class OrderManagementServiceImpl implements IOrderManagementService{
	/**
	 * 订单管理数据访问接口
	 */
	@Autowired
	private OrderManagementDAO omdao;
	/**
	 * 订单明细数据访问接口
	 */
	@Autowired
	private OrderDetailDAO oddao;
	
	
	public void add(OrderManagement om, List<OrderDetail> list) {
		//System.out.println(om.toString());
		//添加订单
		int count = omdao.addorder(om);//影响行数
		//订单明细
		if(count>0){
			for(OrderDetail od:list){
				od.setOrderId(om.getOrderId());
				//System.out.println(od.toString());
				oddao.add(od);
			}
			
		}else{
			throw new RuntimeException();
		}
	}


	/**
	 * 查询订单
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> list(OrderManagement om) {
		
		return omdao.list(om);
	}


	/**
	 * 查询订单详情
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> detailslist(OrderDetail od) {
		// TODO Auto-generated method stub
		return oddao.list(od);
	}

}
