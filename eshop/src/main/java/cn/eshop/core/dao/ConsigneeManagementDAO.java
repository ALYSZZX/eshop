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
	public List<Map> getlist(ConsigneeManagement cm);
	
	/**
	 * 增加收货人
	 * @param cm
	 * @return
	 */
	public int add(ConsigneeManagement cm);
	/**
	 * 修改收货人
	 * @param cm
	 * @return
	 */
	public int update(ConsigneeManagement cm);
	/**
	 * 删除收货人
	 * @param cm
	 * @return
	 */
	public int delete(ConsigneeManagement cm);
	
	/**
	 * 获取收货人信息
	 * @param cm
	 * @return
	 */
	public Map getInfo(ConsigneeManagement cm);
}
