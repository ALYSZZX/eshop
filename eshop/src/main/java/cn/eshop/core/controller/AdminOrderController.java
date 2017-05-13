package cn.eshop.core.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.eshop.core.bean.OrderDetail;
import cn.eshop.core.service.IOrderManagementService;

@Controller
@RequestMapping("/order/")
public class AdminOrderController {

	@Autowired
	private IOrderManagementService omService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("list.do")
	public String list(Model model){
		List<Map> list = omService.list(null);
		
		model.addAttribute("list",list );
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
}
