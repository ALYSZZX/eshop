package cn.eshop.core.service;

import java.util.List;

import cn.eshop.core.bean.UserInfo;

public interface IUserInfoService {

	/***
	 *添加用户
	 *@param user 
	 */
	public void addUser(UserInfo user);
	/***
	 *根据条件查询用户信息
	 *@param user 查询条件
	 */
	public List<UserInfo> getList(UserInfo user);
	/**
	 * 获取总记录数
	 **/
	public long getCount(UserInfo user);
}
