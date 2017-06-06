package cn.eshop.core.service;

import java.util.List;
import java.util.Map;

import cn.eshop.core.bean.GoodsInfo;

/**
 * 商品管理的逻辑业务接口
 * @author ZHUZX
 *
 */
public interface IGoodsInfoService {

	//添加商品
	public void add(GoodsInfo info);
	
	//查找商品
	public List<Map> getlist(GoodsInfo info);
	
	//查询总记录
	public long getcount(GoodsInfo info);
	
	//商品详情
	public Map getGoodsInfo(GoodsInfo info);
	
	//修改商品信息
	public void update(GoodsInfo info);
	/**
	 * 获取商品库存
	 * @param goods
	 * @return
	 */
	public int getGoodsCount(GoodsInfo goods);
}
