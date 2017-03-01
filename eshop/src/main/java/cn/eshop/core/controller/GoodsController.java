package cn.eshop.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Printer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.eshop.core.bean.GoodsInfo;
import cn.eshop.core.bean.ImgUrl;
import cn.eshop.core.service.IGoodsInfoService;
import cn.eshop.core.service.IStaticPageService;
import cn.eshop.utils.BaseController;
import cn.eshop.utils.Common;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;


@Controller
@RequestMapping("/goods/")
public class GoodsController extends BaseController{

	@Autowired
	private IGoodsInfoService service;
	
	@Autowired
	private IStaticPageService pageService;

	@RequestMapping("loadadd.do")
	public String loadadd(){
		return "/goodsinfo/goodsinfo_add";
	}

	/***
	 *上传商品图片
	 * @param shopimg
	 */
	@RequestMapping("upload.do")
	public @ResponseBody ImgUrl uploadImg(@RequestParam(required=false)MultipartFile shopimg){
		try {
			//文件上传到图片服务器

			//图片名称生成策略
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String format =df.format(new Date()); 

			Random r =new Random();
			for(int i=0;i<3;i++){
				format+=r.nextInt(100);
			}

			//保存数据库路径
			String path = "upload/"+format+".jpg";

			//另一台服务器地址
			String url =Common.IMG_SERVER_URL+path;

			//实例化Jersey
			Client client =Client.create();

			//设置请求的路径
			WebResource resource = client.resource(url);
			//发送
			resource.put(String.class, shopimg.getBytes());

			//图片信息
			ImgUrl iu =new ImgUrl();
			iu.setPath(path);
			iu.setUrl(url);
			return iu;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@RequestMapping("uploadfile.do")
	public void uploadfile(@RequestParam(required =false)MultipartFile upload,HttpServletResponse response,HttpServletRequest request){
		try{
			//图片名称生成策略
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String format =df.format(new Date()); 

			Random r =new Random();
			for(int i=0;i<3;i++){
				format+=r.nextInt(100);
			}

			//保存数据库路径
			String path = "upload/"+format+".jpg";

			//另一台服务器地址
			String url =Common.IMG_SERVER_URL+path;

			//实例化Jersey
			Client client =Client.create();

			//设置请求的路径
			WebResource resource = client.resource(url);
			//发送
			resource.put(String.class, upload.getBytes());

			//响应
			PrintWriter  out = response.getWriter();

			String callback = request.getParameter("CKEditorFuncNum");

			out.print("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+url+"')</script>");

			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}



	@RequestMapping("add.do")
	public String add(GoodsInfo goodsinfo,Model model){
		String info ="操作失败";
		try {
			if(goodsinfo!=null){
				goodsinfo.setGoodsState(Common.GOODS_STATE_INIT);
			}
			service.add(goodsinfo);
			info="操作成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		model.addAttribute("info", info);
		return "/goodsinfo/goodsinfo_add";
	}

	@RequestMapping("list.do")
	public String list(GoodsInfo info,Model model,HttpServletRequest request){

		if(info!=null){
			this.initPage(request);
			info.setStart(this.getPageNo());//起始总记录数
			info.setLength(PAGE_NUM_BIG);//每页显示记录数			
		}

		List<Map> list = service.getlist(info);

		model.addAttribute("list", list);

		model.addAttribute("total", service.getcount(info));


		return "/goodsinfo/goodsinfo_list";
	}

	/**
	 * 查看商品详情
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("goodsinfo.do")
	public String getInfo(GoodsInfo info,Model model){

		Map map = service.getGoodsInfo(info);

		model.addAttribute("goods", map);

		return "/goodsinfo/goodsinfo_show";
	}

	/**
	 * 修改商品详情
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String loadupdate(GoodsInfo info,Model model){

		Map map = service.getGoodsInfo(info);

		model.addAttribute("goods", map);

		return "/goodsinfo/goodsinfo_update";
	}
	/**
	 * 修改商品信息
	 * @param goodsinfo
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(GoodsInfo goodsinfo,Model model,HttpServletRequest request){
		String info ="操作失败";
		try {
			/*if(goodsinfo!=null){
				goodsinfo.setGoodsState(Common.GOODS_STATE_YES);
			}*/
			service.update(goodsinfo);
			info="操作成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		model.addAttribute("info", info);
		goodsinfo.setGoodsState(null);
		return list(goodsinfo,model,request);
	}

	/***
	 * 下架商品
	 * @param goodsinfo
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(GoodsInfo goodsinfo,Model model,HttpServletRequest request){
		String info ="下架失败";
		try {
			if(goodsinfo!=null){
				goodsinfo.setGoodsState(Common.GOODS_STATE_NO);
			}
			service.update(goodsinfo);
			info="下架成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		model.addAttribute("info", info);
		goodsinfo.setGoodsState(null);
		return list(goodsinfo,model,request);
	}
	/***
	 * 上架商品
	 * @param goodsinfo
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("upgoods.do")
	public String upGoods(GoodsInfo goodsinfo,Model model,HttpServletRequest request){
		String info ="上架失败";
		try {
			if(goodsinfo!=null){
				goodsinfo.setGoodsState(Common.GOODS_STATE_YES);
			}
			service.update(goodsinfo);
			info="上架成功";
			Map map =service.getGoodsInfo(goodsinfo);
			if (map!=null){
				map.put("imgUrl", Common.IMG_SERVER_URL);
			}
			
			pageService.outStaticPage(map, goodsinfo.getGoodsId());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		model.addAttribute("info", info);
		goodsinfo.setGoodsState(null);
		return list(goodsinfo,model,request);
	}
	
	
}