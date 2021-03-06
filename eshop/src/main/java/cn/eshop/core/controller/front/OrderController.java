package cn.eshop.core.controller.front;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.eshop.core.bean.ConsigneeManagement;
import cn.eshop.core.bean.GoodsInfo;
import cn.eshop.core.bean.OrderDetail;
import cn.eshop.core.bean.OrderManagement;
import cn.eshop.core.bean.UserInfo;
import cn.eshop.core.service.IConsigneeManagementService;
import cn.eshop.core.service.IGoodsInfoService;
import cn.eshop.core.service.IOrderManagementService;
import cn.eshop.utils.BaseController;

/**
 * 前端订单管理
 * @author ZHUZX
 *
 */
@Controller
@RequestMapping("/adminorder/")
public class OrderController extends BaseController{

	/**
	 * 收货人管理业务逻辑接口
	 */
	@Autowired
	private IConsigneeManagementService consigneeService;

	/**
	 * 订单管理的业务逻辑接口
	 */
	@Autowired
	private IOrderManagementService omservice;

	@Autowired
	private IGoodsInfoService goodsService;

	@RequestMapping("orderCheck.shtml")
	public String orderCheck(String[] goodsDescs,Integer[] orderNumber,Model model,HttpSession session){

		double sum = 0;

		List<OrderDetail> list = new ArrayList<OrderDetail>();
		if(goodsDescs!=null&&goodsDescs.length>0){
			for(int i=0;i<goodsDescs.length;i++){
				System.out.println(goodsDescs[i]);
				String[] goodss = goodsDescs[i].split(",");
				OrderDetail od = new OrderDetail();
				od.setGoodsId(Integer.parseInt(goodss[0]));
				od.setGoodsName(goodss[1]);
				od.setOrderPrice(Double.valueOf(goodss[2]));
				od.setGoodsUrl(goodss[3]);
				od.setOrderNumber(orderNumber[i]);
				list.add(od);
				sum +=(orderNumber[i]*Double.valueOf(goodss[2]));
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("sum", sum);
		model.addAttribute("num", list.size());

		ConsigneeManagement cm = new ConsigneeManagement();
		UserInfo user = (UserInfo) session.getAttribute("userInfo");
		cm.setUserId(user.getUserId());

		model.addAttribute("consigneelist", consigneeService.getlist(cm));

		return "/order_check";
	}

	@RequestMapping("addorder.shtml")
	public String addOrder(OrderManagement om,String[] goodsinfos,HttpSession session,Model model){

		try {
			//订单
			if(om!=null){
				UserInfo user = (UserInfo) session.getAttribute("userInfo");
				om.setUserId(user.getUserId());

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(new Date());
				om.setOrderTime(time);
				om.setOrderState("0");

			}
			List<OrderDetail> list = new ArrayList<OrderDetail>();
			//构建订单详情
			if(goodsinfos!=null&&goodsinfos.length>0){
				for(String str :goodsinfos){
					String [] goodsinfo = str.split(",");
					OrderDetail od = new OrderDetail();
					GoodsInfo goods = new GoodsInfo();
					od.setGoodsId(Integer.parseInt(goodsinfo[0]));
					od.setOrderNumber(Integer.parseInt(goodsinfo[1]));
					od.setOrderPrice(Double.valueOf(goodsinfo[2]));
					list.add(od);
					goods.setGoodsId(od.getGoodsId());//判断库存是否足够
					int count = goodsService.getGoodsCount(goods);
					if(count<od.getOrderNumber()){
						throw new Exception("Inventory shortage");
					}
				}
			}
			omservice.add(om, list);
			model.addAttribute("info", "yes");//下单成功
			session.removeAttribute("cars");//清空购物车
		}catch (Exception e) {
			model.addAttribute("info", "no");//下单失败
			e.printStackTrace();
		}
		return  "/orderok";
	}

	@RequestMapping("showorder.shtml")
	public String showorder(){

		return "/ordermanager_index";
	}

	/**
	 * 查询订单
	 * @param om
	 * @param session
	 * @param model
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("queryOrder.shtml")
	public String queryOrder(OrderManagement om,HttpSession session,Model model,HttpServletRequest requesst){

		UserInfo user = (UserInfo) session.getAttribute("userInfo");
		if(user!=null){
			if(om==null){
				om = new OrderManagement();
				om.setUserId(user.getUserId());
			}
			this.initPage(requesst);
			om.setStart(this.getPageNo());//起始记录数
			om.setLength(PAGE_NUM_BIG);//每页长度
			List<Map> list = omservice.list(om);
			//System.out.println(list.get(1).toString());
			model.addAttribute("list", list);
			//总记录数
			model.addAttribute("total", omservice.getCount(om));
		} 
		return "/ordermanager_info";
	}

	/**
	 * 查询订单详情
	 * @param od
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("detailslist.shtml")
	public String orderDetailslist(OrderDetail od,HttpSession session,Model model){

		model.addAttribute("list", omservice.detailslist(od));

		return "/orderdetails_info";
	}

	@RequestMapping("exit.shtml")
	public String exit(HttpSession session){
		session.removeAttribute("userInfo");
		return "/login";
	}

	/**
	 * 取消订单&&修改库存
	 * @param od
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("cancelorder.shtml")
	public String cancelOrder(OrderDetail od,HttpSession session,Model model){
		OrderManagement om = new OrderManagement();
		om.setOrderId(od.getOrderId());
		om.setOrderState("3");
		omservice.update(om);
		return showorder();
	}
	/**
	 * 确认收货
	 * @param od
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("confirmreceipt.shtml")
	public String reciveOrder(OrderDetail od,HttpSession session,Model model,HttpServletRequest requesst){
		OrderManagement om = new OrderManagement();
		om.setOrderId(od.getOrderId());
		om.setOrderState("2");
		omservice.update(om);		
		return queryOrder(new OrderManagement(),session,model,requesst);
	}

}
