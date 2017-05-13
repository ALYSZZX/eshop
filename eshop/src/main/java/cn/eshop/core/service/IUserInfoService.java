package cn.eshop.core.service;

import java.io.InputStream;
import java.util.List;

import cn.eshop.core.bean.UserInfo;

public interface IUserInfoService {

	/***
	 *添加用户
	 *@param user 
	 */
	boolean addUser(UserInfo user);
	/***
	 *根据条件查询用户信息
	 *@param user 查询条件
	 */
	List<UserInfo> getList(UserInfo user);
	/**
	 * 获取总记录数
	 **/
	long getCount(UserInfo user);
	
	/***
	 * 
	 *根据条件查询用户信息
	 *@param 查询条件
	 *@return 个人信息 
	 */
	
	UserInfo getUserInfo(UserInfo user);
	
	/**
	 *修改用户信息 
	 **/
	void update(UserInfo user);
	/***
	 *删除用户信息 
	 */
	void delete(UserInfo user);
	
	/***
	 *导入Excel中的数据到数据库 
	 * @throws Exception 
	 */
	void uploadExcel(InputStream in) throws Exception;
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	UserInfo userLogin(UserInfo user);
	
	/**
	 * 管理员登录
	 * @param user
	 * @return
	 */
	UserInfo adminLogin(UserInfo user);
	
}
