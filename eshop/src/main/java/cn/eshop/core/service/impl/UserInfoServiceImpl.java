package cn.eshop.core.service.impl;

import java.io.InputStream;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

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
	
	
	public boolean addUser(UserInfo user) {
		if(user!=null){
		  int i = userdao.add(user);
		  return i > 0;
		}
		return false;
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

	public UserInfo getUserInfo(UserInfo user) {
		return userdao.getUserInfo(user);
	}


	public void update(UserInfo user) {
		userdao.update(user);
	}

	
	public void delete(UserInfo user) {
		userdao.delete(user);
		
	}

	public void uploadExcel(InputStream in) throws Exception {
		// TODO Auto-generated method stub
		Workbook book = Workbook.getWorkbook(in);
		Sheet sheet =book.getSheet(0);
		
		for(int i=1;i<sheet.getRows();i++){
			UserInfo user = new UserInfo();
			
			//姓名
			Cell namecell = sheet.getCell(0, i);
			String userName = namecell.getContents();	
			user.setUserName(userName);
			//性别
			Cell sexcell = sheet.getCell(0, i);
			String userSex = sexcell.getContents();	
			user.setUserSex(userSex);
			//电话
			Cell phonecell = sheet.getCell(0, i);
			String userPhone = phonecell.getContents();	
			user.setUserPhone(userPhone);
			//密码
			Cell pwcell = sheet.getCell(0, i);
			String userPw = pwcell.getContents();	
			user.setUserPw(userPw);
			//类型
			Cell typecell = sheet.getCell(0, i);
			String userType = typecell.getContents();	
			user.setUserType(userType);
			
			userdao.add(user);
		}
		book.close();
	}

	/**
	 * 用户登录
	 */
	@Transactional(readOnly=true)
	public UserInfo userLogin(UserInfo user) {
		return userdao.userLogin(user);
	}

}
