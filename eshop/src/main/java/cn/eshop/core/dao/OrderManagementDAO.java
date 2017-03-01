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
	public int addorder(OrderManagement om);
	
	/**
	 * 查询订单信息
	 * @param om
	 * @return
	 */
	public List<Map> list(OrderManagement om);
}
