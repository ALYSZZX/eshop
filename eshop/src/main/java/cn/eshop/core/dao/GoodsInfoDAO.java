package cn.eshop.core.dao;

import java.util.List;
import java.util.Map;

import cn.eshop.core.bean.GoodsInfo;

/**
 * 商品管理的数据访问接口
 * @author ZHUZX
 *
 */
public interface GoodsInfoDAO {

	/**
	 * 添加商品
	 */
	 public int add(GoodsInfo goods);
	 
	 
	 /**
	  * 查找商品
	  */
	 @SuppressWarnings("rawtypes")
	public List<Map> getlist(GoodsInfo info);
	 
	 /**
	  * 查询总记录
	  */
	 public long getcount(GoodsInfo info);
	 
	 /**
	  * 商品详情
	  * @param info
	  * @return
	  */
	 @SuppressWarnings("rawtypes")
	public Map getGoodsInfo(GoodsInfo info);
	 
	 /**
	  * 修改信息
	  * @param info
	  * @return
	  */
	 public int update(GoodsInfo info);

	 /**
	  * 修改库存
	  * @param info
	  */
	 void updateCount(GoodsInfo info);
	 /**
	  * 获取库存
	  * @param info
	  * @return
	  */
	 int getGoodsCount(GoodsInfo info);
}
