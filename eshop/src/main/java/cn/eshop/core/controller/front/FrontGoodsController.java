package cn.eshop.core.controller.front;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.eshop.core.bean.GoodsInfo;
import cn.eshop.core.bean.HistoryInfo;
import cn.eshop.core.bean.UserInfo;
import cn.eshop.core.service.IGoodsInfoService;
import cn.eshop.core.service.IHistoryInfoService;
import cn.eshop.core.service.IUserInfoService;
import cn.eshop.utils.Common;


/**
 * 
 * 前台商品查询
 * @author ZHUZX
 *
 */
@Controller
@RequestMapping("/front/")
public class FrontGoodsController {

	@Autowired
	private IGoodsInfoService goodsService;
	
	@Autowired
	private IUserInfoService userService;
	
	@Autowired
	private IHistoryInfoService hisService;
	/**
	 * 初始化首页信息
	 * @param model
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("list.shtml")
	public String list(Model model,HttpSession session){
		
		GoodsInfo info = new GoodsInfo();
		
		info.setGoodsState(Common.GOODS_STATE_YES);
		
		List<Map> list=goodsService.getlist(info);
		
		//System.out.println(list.size());
				
		model.addAttribute("goodslist", list);
		
		UserInfo user = (UserInfo) session.getAttribute("userInfo");
		
		if(user!=null){
			HistoryInfo history = new HistoryInfo();
			history.setUserId(user.getUserId());
			List<Map> hisList = hisService.getHistory(history);
			if(hisList==null||hisList.size()<1){
				List<Map> historylist = gethisList(list);
		        model.addAttribute("historylist", historylist);
			}else{
				List<Map> hlist = new ArrayList<Map>();
				for(Map m :hisList){
					GoodsInfo ginfo = new GoodsInfo();
					ginfo.setGoodsId((Integer) m.get("goods_id"));
					hlist.add(goodsService.getGoodsInfo(ginfo));
				}
				model.addAttribute("historylist", hlist);
			}
		}else{
			if(list.size()<=4){
				model.addAttribute("historylist", list);
			}else{
				List<Map> historylist = gethisList(list);
		        model.addAttribute("historylist", historylist);
			}
		}
		return "/indexAll";
	}
	
	@SuppressWarnings({ "rawtypes" })
	private static List<Map> gethisList(List<Map> list){
		List<Map> historylist = new ArrayList<Map>();
		Random ran = new Random();  
        Set<Integer> set = new TreeSet<>();
        while (true) {  
            int a = ran.nextInt(list.size());  
            set.add(a);  
            if (set.size() == 4||set.size() ==list.size()) {   
                break;  
            }  
        } 
        for(Integer i :set){
        	historylist.add(list.get(i));
        }
        return historylist;
	}
	/**
	 * 分类信息信息
	 * @param model
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("classiclist.shtml")
	public String classicList(@RequestParam String classic,Model model){
		
		GoodsInfo info = new GoodsInfo();

		info.setGoodsState(Common.GOODS_STATE_YES);
		info.setGoodsType(classic);
		
		List<Map> list=goodsService.getlist(info);
		
		//System.out.println(classic);
				
		model.addAttribute("goodslist", list);
		
		return "/index";
	}
	
	/**
	 * 显示商品详细信息
	 */
	@SuppressWarnings("rawtypes")
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
				user.setUserType(Common.USER_TYPE_ONE);//普通用户
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
			return list(model,session);
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("showcar.shtml")
	public String showcar(HttpSession session){
		Map<Integer,Map> cars = (Map<Integer,Map>) session.getAttribute("cars");
		if(cars==null){
			cars = new HashMap<Integer,Map>();
		}
		
		return "/shopcar";
	}
	
	/**
	 * 添加浏览历史
	 * @param goodsId
	 * @param model
	 * @return
	 */
	@SuppressWarnings({ "rawtypes"})
	@RequestMapping(value="history/{goodsId}.shtml",method=RequestMethod.GET)
	public @ResponseBody Integer addHistory(@PathVariable Integer goodsId,HttpSession session){
		UserInfo user =  (UserInfo) session.getAttribute("userInfo");
		HistoryInfo his = new HistoryInfo();
		if(user !=null){
			his.setGoodsId(goodsId);
			his.setUserId(user.getUserId());
			his.setHistoryCount(1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(new Date());
			his.setHistoryDate(time);
			List<Map> list=hisService.getHistory(his);
			if(list == null||list.size()<1){
				hisService.addHistory(his);
			}else{
				his.setHistoryId((Integer) list.get(0).get("history_id"));
				hisService.updateHistory(his);
			}
		}
		return goodsId;
	}
	
}
