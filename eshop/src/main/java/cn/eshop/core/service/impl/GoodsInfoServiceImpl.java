package cn.eshop.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.eshop.core.bean.GoodsInfo;
import cn.eshop.core.dao.GoodsInfoDAO;
import cn.eshop.core.service.IGoodsInfoService;
import cn.eshop.utils.Common;

@Service
@Transactional      //注解开发
public class GoodsInfoServiceImpl implements IGoodsInfoService{

	@Autowired
	private GoodsInfoDAO goodsdao;

	
	public void add(GoodsInfo info) {
		info.setGoodsState(Common.GOODS_STATE_YES);
		goodsdao.add(info);
	}

	/**
	 * 查询商品信息
	 */
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly=true)
	public List<Map> getlist(GoodsInfo info) {
		return goodsdao.getlist(info);
	}

    /**
     * 查询总记录数
     */
	@Transactional(readOnly=true)
	public long getcount(GoodsInfo info) {
		return goodsdao.getcount(info);
	}

	/**
	 * 根据条件查询信息
	 */
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly=true)
	public Map getGoodsInfo(GoodsInfo info) {
		return goodsdao.getGoodsInfo(info);
	}

	/**
	 * 修改商品信息
	 */
	public void update(GoodsInfo info) {
		goodsdao.update(info);
	}

}
