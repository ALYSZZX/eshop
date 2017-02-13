package cn.eshop.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.eshop.core.bean.UserInfo;
import cn.eshop.core.dao.UserInfoDAO;
import cn.eshop.core.service.IUserInfoService;

@Service
@Transactional      //注解开发
public class UserInfoServiceImpl implements IUserInfoService{

	@Autowired
	private UserInfoDAO userdao;
	public void addUser(UserInfo user) {
		int i=userdao.add(user);
	} 
	
	public List<UserInfo> getList(UserInfo user) {
		if(user!=null){
			if(user.getUserName()!=null&&!user.getUserName().equals("")){
				user.setUserName("%"+user.getUserName()+"%");
			}
		} 
		return userdao.getUserList(user);
	}

	public long getCount(UserInfo user) {
		if(user!=null){
			if(user.getUserName()!=null&&!user.getUserName().equals("")){
				user.setUserName("%"+user.getUserName()+"%");
			}
		} 
		return userdao.getCount(user);
	}

}
