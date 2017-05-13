package cn.eshop.userinfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.eshop.core.bean.UserInfo;
import cn.eshop.core.service.IUserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application-context.xml")
public class UserTest {

	@Autowired
	private IUserInfoService service;
	
	/*@Test
	public void testAdd(){
		UserInfo user = new UserInfo();
		user.setUserName("华安");
		user.setUserSex("男");
		service.addUser(user);
	}
	@Test
	public void testList(){
		UserInfo user = new UserInfo();
		
		user.setUserName("安");
		
		List<UserInfo> list = service.getList(user);
		for(UserInfo info :list){
			System.out.println(info);
		}
	}
	*/
	@Test
	public void testCount(){
		UserInfo user = new UserInfo();
		user.setUserName("华");
		System.out.println(service.getCount(user));
	}
}
