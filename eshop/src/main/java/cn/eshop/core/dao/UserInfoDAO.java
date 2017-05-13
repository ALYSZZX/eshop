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
	
	/**
	 *根据条件获取个人信息 
	 *@param 查询条件
	 *@return 返回个人信息
	 **/
	public UserInfo getUserInfo(UserInfo user);
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public int update(UserInfo user);
	/***
	 *删除用户信息 
	 */
	public int 	delete(UserInfo user);	
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public UserInfo userLogin(UserInfo user);
	
	/**
	 * 管理员登录
	 * @param user
	 * @return
	 */
	UserInfo adminLogin(UserInfo user);
	
}
