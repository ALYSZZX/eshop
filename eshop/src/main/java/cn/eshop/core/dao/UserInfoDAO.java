package cn.eshop.core.dao;

import java.util.List;

import cn.eshop.core.bean.UserInfo;

/***
 *用户管理的数据访问接口
 *@author ZHUZX
 * 
 */
public interface UserInfoDAO {

	/***
	 *添加用户
	 *@param user
	 * 
	 */
	public int add(UserInfo user);
	/***
	 *查询用户
	 *@param user
	 *@return list 
	 */
	public List<UserInfo> getUserList(UserInfo user);
	/**
	 * 获取总记录数
	 * @param user
	 * @return long
	 */
	public long getCount(UserInfo user);
}
