package cn.eshop.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.eshop.core.bean.ConsigneeManagement;
import cn.eshop.core.bean.UserInfo;
import cn.eshop.core.service.IConsigneeManagementService;


@Controller
@RequestMapping("/consignee/")
public class AdminConsigneeManagementController {

	@Autowired
	private IConsigneeManagementService cmservice;
	/**
	 * 查询收货人
	 * @param session
	 * @param cm
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(HttpSession session,Model model){

		model.addAttribute("list", cmservice.getALl());

		return "/order/consignee_list";
	}
	
	/**
	 * 查询单个收货人
	 * @param session
	 * @param cm
	 * @param model
	 * @return
	 */
	@RequestMapping("getInfo.do")
	public String show(HttpSession session,ConsigneeManagement cm,Model model){
		UserInfo user = (UserInfo) session.getAttribute("userInfo");

		if(cm==null){
			cm = new ConsigneeManagement();
		}
		cm.setUserId(user.getUserId());

		model.addAttribute("cm", cmservice.getInfo(cm));

		return "/consignee_index";
	}

	/**
	 * 删除
	 * @param session
	 * @param cm
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(HttpSession session,ConsigneeManagement cm,Model model){
		try {
			cmservice.delete(cm);
			model.addAttribute("info", "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("info", "删除失败");
		}
		return "/order/consignee_info";
	}


}
