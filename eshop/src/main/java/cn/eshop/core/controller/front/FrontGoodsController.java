package cn.eshop.core.controller.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.eshop.core.bean.GoodsInfo;
import cn.eshop.core.bean.UserInfo;
import cn.eshop.core.service.IGoodsInfoService;
import cn.eshop.core.service.IUserInfoService;
import cn.eshop.utils.Common;


/**
 * 
 * 前台商品查询
 * @author ZHUZX
 *
 */
@Controller
@RequestMapping("front")
public class FrontGoodsController {

	@Autowired
	private IGoodsInfoService goodsService;
	
	@Autowired
	private IUserInfoService userService;
	
	/**
	 * 初始化首页信息
	 * @param model
	 * @return
	 */
	@RequestMapping("list.shtml")
	public String list(Model model){
		
		GoodsInfo info = new GoodsInfo();
		
		info.setGoodsState(Common.GOODS_STATE_YES);
		
		List<Map> list=goodsService.getlist(info);
		
		//System.out.println(list.size());
				
		model.addAttribute("goodslist", list);
		
		return "/index";
	}
	
	/**
	 * 显示商品详细信息
	 */
	@RequestMapping(value="{goodsId}.shtml",method=RequestMethod.GET)
	public String getinfo(@PathVariable Integer goodsId,Model model){
		//System.out.println("商品编号-"+goodsId);
		
		GoodsInfo info = new GoodsInfo();
		info.setGoodsId(goodsId);
		Map pinfo = goodsService.getGoodsInfo(info);
		
		if(pinfo!=null){
		model.addAttribute("goods", pinfo);
		
		return "/goodsinfo";
		}else{
			return "/error";
		}
	}
	
	/**
	 * 加载注册页面
	 * @return
	 */
	@RequestMapping("loadreg.shtml")
	public String loadReg(){
		return "/reg";
	}
	
	/**
	 * 注册
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("reg.shtml")
	public String reg(UserInfo user,Model model){
		
		try {
			
			if(user!=null){
				//普通用户
				user.setUserType(Common.USER_TYPE_ONE);
			}
			
			userService.addUser(user);
			model.addAttribute("info", "恭喜您，注册成功!");
			return "/login";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/reg";
	}
	
	/**
	 * 加载注册页面
	 * @return
	 */
	@RequestMapping("loadlogin.shtml")
	public String loadLogin(){
		return "/login";
	}
	
	/**
	 * 登录
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping("login.shtml")
	public String login(UserInfo user,Model model,HttpSession session){
		
		UserInfo userinfo=userService.userLogin(user);
		if(userinfo!=null){
			session.setAttribute("userInfo", userinfo);
			return list(model);
		}else{
			model.addAttribute("logininfo", "账号密码错误,请重新输入");
			return "/login";
		}		
	}
	
	/**
	 * 添加购物车
	 * @param goodsId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="car/{goodsId}.shtml",method=RequestMethod.GET)
	public String shopcar(@PathVariable Integer goodsId,Model model,HttpSession session){
	
		Map<Integer,Map> cars = (Map<Integer,Map>) session.getAttribute("cars");
		if(cars==null){
			cars = new HashMap<Integer,Map>();
		}
		GoodsInfo info = new GoodsInfo();
		info.setGoodsId(goodsId);
		Map pinfo = goodsService.getGoodsInfo(info);
		
		cars.put(goodsId, pinfo);
		session.setAttribute("cars", cars);
		
		return "/shopcar";
	}
	/**
	 * 删除购物车商品
	 * @param goodsId
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteGoods.shtml")
	public String deleteGoods( Integer[] goodsIds,HttpSession session){
		
		Map<Integer,Map> cars = (Map<Integer,Map>) session.getAttribute("cars");
		if(cars!=null){
			for(Integer goodsid:goodsIds){
				cars.remove(goodsid);
			}
		}
		session.setAttribute("cars", cars);
		
		return "/shopcar";
	}
	/**
	 * 查看购物车
	 * @return
	 */
	@RequestMapping("showcar.shtml")
	public String showcar(HttpSession session){
		Map<Integer,Map> cars = (Map<Integer,Map>) session.getAttribute("cars");
		if(cars==null){
			cars = new HashMap<Integer,Map>();
		}
		
		return "/shopcar";
	}
	
}
