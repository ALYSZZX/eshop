package cn.eshop.core.dao;

import java.util.List;
import java.util.Map;

import cn.eshop.core.bean.OrderManagement;

/**
 * 订单管理
 * @author ZHUZX
 *
 */
public interface OrderManagementDAO {

	/**
	 * 返回订单编号
	 * @param om
	 * @return
	 */
	int addorder(OrderManagement om);
	
	/**
	 * 查询订单信息
	 * @param om
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<Map> list(OrderManagement om);
	/**
	 * 修改订单
	 * @param om
	 */
	void update(OrderManagement om);

	long getCount(OrderManagement om);
}
