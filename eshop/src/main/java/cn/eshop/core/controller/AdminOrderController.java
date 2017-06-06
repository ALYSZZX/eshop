package cn.eshop.core.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.eshop.core.bean.OrderDetail;
import cn.eshop.core.bean.OrderManagement;
import cn.eshop.core.service.IOrderManagementService;
import cn.eshop.utils.BaseController;

@Controller
@RequestMapping("/order/")
public class AdminOrderController extends BaseController{

	@Autowired
	private IOrderManagementService omService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("list.do")
	public String list(Model model,HttpServletRequest requesst){
		//分页
		OrderManagement om = new OrderManagement();
		this.initPage(requesst);
		om.setStart(this.getPageNo());//起始记录数
		om.setLength(PAGE_NUM_BIG);//每页长度

		List<Map> list = omService.list(om);
		model.addAttribute("list",list);
		//总记录数
		model.addAttribute("total", omService.getCount(om));
		return "/order/order_list";
	}
	
	/**
	 * 查询订单详情
	 * @param od
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("details.do")
	public String orderDetailslist(OrderDetail od,HttpSession session,Model model){
		
		model.addAttribute("list", omService.detailslist(od));
		
		return "/order/orderdetails_info";
	}
	
	
	/**
	 * 确定订单
	 * @param od
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("confirmorder.do")
	public String confirmOrder(OrderDetail od,HttpSession session,Model model,HttpServletRequest requesst){
		 OrderManagement om = new OrderManagement();
		 om.setOrderId(od.getOrderId());
		 om.setOrderState("1");
		 omService.update(om);
		return list(model,requesst);
	}
	/**
	 * 取消订单
	 * @param od
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("cancelorder.do")
	public String cancelOrder(OrderDetail od,HttpSession session,Model model,HttpServletRequest requesst){
		 OrderManagement om = new OrderManagement();
		 om.setOrderId(od.getOrderId());
		 om.setOrderState("3");
		 omService.update(om);
		return list(model,requesst);
	}
}
