package cn.eshop.core.service;

import java.util.Map;

/**
 * 生成静态页面的实现类
 *@author ZHUZX
 */
public interface IStaticPageService {

	/**
	 * 静态化的方法
	 * @param root
	 * @param id
	 */
	public void outStaticPage(Map root,Integer id);
}
