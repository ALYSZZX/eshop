package cn.eshop.core.dao;

import java.util.List;
import java.util.Map;

import cn.eshop.core.bean.ConsigneeManagement;

public interface ConsigneeManagementDAO {

	/**
	 * 获取收货人
	 * @param cm
	 * @return
	 */
	 @SuppressWarnings("rawtypes")
	List<Map> getlist(ConsigneeManagement cm);
	
	/**
	 * 增加收货人
	 * @param cm
	 * @return
	 */
	 int add(ConsigneeManagement cm);
	/**
	 * 修改收货人
	 * @param cm
	 * @return
	 */
	 int update(ConsigneeManagement cm);
	/**
	 * 删除收货人
	 * @param cm
	 * @return
	 */
	int delete(ConsigneeManagement cm);
	
	/**
	 * 获取收货人信息
	 * @param cm
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map getInfo(ConsigneeManagement cm);
	
	/**
	 * 获取所有收货人信息
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<Map> getAll();
}
