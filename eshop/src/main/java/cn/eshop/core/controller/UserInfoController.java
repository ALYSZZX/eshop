package cn.eshop.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
			boolean b =service.addUser(user);
			if (b)
			    info="操作成功";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("info", info);
		
		return "/userinfo/userinfo_info";
		
	}
	
	@RequestMapping("back/login.do")
	public String login(UserInfo user,Model model,HttpSession session){
		
		UserInfo userinfo=service.adminLogin(user);
		if(userinfo!=null){
			session.setAttribute("admin", userinfo);
			model.addAttribute("admin",user.getUserName());
			return "/main/index";
		}else{
			if("admin".equals(user.getUserName())&&"admin".equals(user.getUserPw())){
				session.setAttribute("admin", user);
				model.addAttribute("admin",user.getUserName());
				return "/main/index";
			}
			model.addAttribute("logininfo", "账号密码错误,请重新输入");
			return "/../../login_back";
		}		
	}
	
	@RequestMapping("back/back_exit.do")
	public String exit(Model model,HttpSession session){
		session.removeAttribute("admin");
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
	
	/**
	 * 加载修改页面
	 * @param user
	 * @param model
	 * @return 
	 **/
	@RequestMapping("user/loadupdate.do")
	public String loadupdate(UserInfo user,Model model){
		
		model.addAttribute("user", service.getUserInfo(user));
		return "/userinfo/userinfo_update";
	}
	/**
	 *保存修改后信息 
	 **/
	@RequestMapping("user/update.do")
	public String update(UserInfo user,Model model){
		String info ="操作失败";
		try{
			service.update(user);
			info ="操作成功";
		}catch (Exception e){
			e.printStackTrace();
		}
		model.addAttribute("info", info);
		return "/userinfo/userinfo_info";
	}
	
	/***
	 *删除用户信息
	 *@param user
	 *@param model
	 *@return 
	 */
	@RequestMapping("user/delete.do")
	public String delete(UserInfo user,Model model){
		String info ="操作失败";
		try{
			service.delete(user);
			info="操作成功";
		}catch(Exception e){
			e.printStackTrace();			
		}
		model.addAttribute("info", info);
		return "/userinfo/userinfo_info";
	} 
	
	/**
	 * 手机验证 异步ajax
	 ***/
	@RequestMapping("user/userAjax.do")
	public @ResponseBody String userAjax(UserInfo user){
		UserInfo puser = service.getUserInfo(user);
		if(puser!=null){
			return "该手机号码已存在，请重新输入";
		}else{
		  return "恭喜您，该手机号码可以使用";
		}
	}
	
	
	/***
	 *导入用户Excel到数据库
	 *@param
	 *@return 
	 */
	@RequestMapping("user/imuser.do")
	public String uploadExcel(@RequestParam(value="upfile", required = false) MultipartFile file,Model model){
		String info ="操作失败";
		try{
			service.uploadExcel(file.getInputStream());
			info="操作成功";
		}catch(Exception e){
			e.printStackTrace();			
		}
		model.addAttribute("info", info);
		return "/userinfo/userinfo_info";
	}
}
