package cn.eshop.core.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import cn.eshop.core.service.IStaticPageService;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class StaticPageServiceImpl implements IStaticPageService, ServletContextAware{

	
	private Configuration conf;
	
	private ServletContext servletContext;

	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.conf = freeMarkerConfigurer.getConfiguration();
	}



	public void outStaticPage(Map root, Integer id) {
		
		//输出流 从内存写到磁盘上
		Writer out = null;
		try {
			Template template = conf.getTemplate("goodsinfo.html");
			//获取html的路径
			String path = getPath("/html/"+id+".html");
			
			File f =new File(path);
			
			File parentFile = f.getParentFile();
			
			if(!parentFile.exists()){
				parentFile.mkdirs();
			}
			
			//输出流
			out = new OutputStreamWriter(new FileOutputStream(f),"UTF-8");
			
			//处理模板
			template.process(root, out);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	//获取当前工程路径
	public String getPath(String name){
		return servletContext.getRealPath(name);
	}
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
