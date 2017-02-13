package cn.eshop.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.eshop.core.bean.UserInfo;
import cn.eshop.core.service.IUserInfoService;
import cn.eshop.utils.BaseController;

@Controller
public class UserInfoController extends BaseController{

	@Autowired
	private IUserInfoService service;
	
	/***
	 * 添加用户
	 * @param user
	 * @param model
	 * @return  
	 */
	@RequestMapping("user/add.do")
	public String add(UserInfo user ,Model model){
		String info="操作失败";
		try{
			service.addUser(user);
			info="操作成功";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("info", info);
		
		return "/userinfo/userinfo_info";
		
	}
	
	@RequestMapping("back/login.do")
	public String login(){
		
		return "/main/index";
	}
	
	@RequestMapping("back/back_exit.do")
	public String exit(){
		
		return "login_back";
	}
	
	/***
	 *查询用户信息
	 *@param user model
	 *@return String 
	 */
	@RequestMapping("user/list.do")
	public String list(UserInfo user,Model model,HttpServletRequest requesst){
		
		//分页
		if(user!=null){
			this.initPage(requesst);
			user.setStart(this.getPageNo());//起始记录数
			user.setLength(PAGE_NUM_BIG);//每页长度
		}
		
		List<UserInfo> list = service.getList(user);
		model.addAttribute("list", list);
		//总记录数
		model.addAttribute("total", service.getCount(user));
		return "/userinfo/userinfo_list";
	}
	
	/***
	 *加载添加页面 
	 */
	@RequestMapping("user/loadadd.do")
	public String loadadd(){
		return "/userinfo/userinfo_add";
	}
}
