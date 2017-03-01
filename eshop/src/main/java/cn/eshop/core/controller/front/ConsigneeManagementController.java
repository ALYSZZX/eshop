package cn.eshop.core.controller.front;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.eshop.core.bean.ConsigneeManagement;
import cn.eshop.core.bean.UserInfo;
import cn.eshop.core.service.IConsigneeManagementService;


@Controller
@RequestMapping("/adminconsignee/")
public class ConsigneeManagementController {

	@Autowired
	private IConsigneeManagementService cmservice;
	/**
	 * 查询收货人
	 * @param session
	 * @param cm
	 * @param model
	 * @return
	 */
	@RequestMapping("list.shtml")
	public String list(HttpSession session,ConsigneeManagement cm,Model model){
		UserInfo user = (UserInfo) session.getAttribute("userInfo");

		if(cm==null){
			cm = new ConsigneeManagement();
		}
		cm.setUserId(user.getUserId());

		model.addAttribute("list", cmservice.getlist(cm));

		return "/consignee_list";
	}
	/**
	 * 添加
	 * @param session
	 * @param cm
	 * @param model
	 * @return
	 */
	@RequestMapping("add.shtml")
	public String add(HttpSession session,ConsigneeManagement cm,Model model){
		UserInfo user = (UserInfo) session.getAttribute("userInfo");

		if(cm==null){
			cm = new ConsigneeManagement();
		}
		cm.setUserId(user.getUserId());
		try {
			cmservice.add(cm);
			model.addAttribute("info", "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("info", "添加失败");
		}

		return "/consignee_index";
	}
	/**
	 * 查询单个收货人
	 * @param session
	 * @param cm
	 * @param model
	 * @return
	 */
	@RequestMapping("getInfo.shtml")
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
	 * 修改
	 * @param session
	 * @param cm
	 * @param model
	 * @return
	 */
	@RequestMapping("update.shtml")
	public String update(HttpSession session,ConsigneeManagement cm,Model model){
		UserInfo user = (UserInfo) session.getAttribute("userInfo");

		if(cm==null){
			cm = new ConsigneeManagement();
		}
		cm.setUserId(user.getUserId());
		try {
			cmservice.update(cm);
			model.addAttribute("info", "修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("info", "修改失败");
		}

		return "/consignee_index";
	}
	/**
	 * 删除
	 * @param session
	 * @param cm
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.shtml")
	public String delete(HttpSession session,ConsigneeManagement cm,Model model){
		UserInfo user = (UserInfo) session.getAttribute("userInfo");
		
		if(cm==null){
			cm = new ConsigneeManagement();
		}
		cm.setUserId(user.getUserId());
		try {
			cmservice.delete(cm);
			model.addAttribute("info", "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("info", "删除失败");
		}
		return "/consignee_index";
	}


}
