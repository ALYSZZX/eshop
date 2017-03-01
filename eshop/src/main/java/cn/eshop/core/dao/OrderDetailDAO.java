package cn.eshop.core.dao;

import java.util.List;
import java.util.Map;

import cn.eshop.core.bean.OrderDetail;

/**
 * 订单明细
 * @author ZHUZX
 *
 */
public interface OrderDetailDAO {

	/**
	 * 添加订单明细
	 * @param od
	 * @return
	 */
	public int add(OrderDetail od);
	
	/**
	 * 查询订单详情
	 * @param od
	 * @return
	 */
	public List<Map> list(OrderDetail od);
}
