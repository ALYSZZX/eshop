package cn.eshop.core.service;

import java.util.List;
import java.util.Map;

import cn.eshop.core.bean.ConsigneeManagement;

/**
 * 收货人管理的业务逻辑
 * @author ZHUZX
 *
 */
public interface IConsigneeManagementService {

	/**
	 * 获取单个用户所有收货人
	 * @param cm
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getlist(ConsigneeManagement cm);
	/**
	 * 添加收货人
	 * @param cm
	 */
	public void add(ConsigneeManagement cm);
	/**
	 * 删除收货人
	 * @param cm
	 */
	public void delete(ConsigneeManagement cm);
	/**
	 * 更新收货人信息
	 * @param cm
	 */
	public void update(ConsigneeManagement cm);
	/**
	 * 获取收货人信息
	 * @param cm
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map getInfo(ConsigneeManagement cm);
	
	/**
	 * 获取所有收货人
	 * @param cm
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> getALl();
}
