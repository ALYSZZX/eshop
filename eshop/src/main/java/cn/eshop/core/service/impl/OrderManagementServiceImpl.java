package cn.eshop.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.eshop.core.bean.GoodsInfo;
import cn.eshop.core.bean.OrderDetail;
import cn.eshop.core.bean.OrderManagement;
import cn.eshop.core.dao.GoodsInfoDAO;
import cn.eshop.core.dao.OrderDetailDAO;
import cn.eshop.core.dao.OrderManagementDAO;
import cn.eshop.core.service.IOrderManagementService;

@Service
@Transactional
public class OrderManagementServiceImpl implements IOrderManagementService{
	/**
	 * 订单管理数据访问接口
	 */
	@Autowired
	private OrderManagementDAO omdao;
	/**
	 * 订单明细数据访问接口
	 */
	@Autowired
	private OrderDetailDAO oddao;

	@Autowired
	private GoodsInfoDAO goodsdao;

	public void add(OrderManagement om, List<OrderDetail> list) {
		//System.out.println(om.toString());
		//添加订单
		int count = omdao.addorder(om);//影响行数
		//订单明细
		if(count>0){
			for(OrderDetail od:list){
				od.setOrderId(om.getOrderId());
				//System.out.println(od.toString());
				oddao.add(od);
				//修改库存
				GoodsInfo goods = new GoodsInfo();
				goods.setGoodsId(od.getGoodsId());
				goods.setGoodsCount(0-od.getOrderNumber());
				goodsdao.updateCount(goods);
			}
		}else{
			throw new RuntimeException();
		}
	}


	/**
	 * 查询订单
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> list(OrderManagement om) {

		return omdao.list(om);
	}


	/**
	 * 查询订单详情
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> detailslist(OrderDetail od) {
		// TODO Auto-generated method stub
		return oddao.list(od);
	}


	/**
	 * 取消订单
	 */
	@SuppressWarnings("rawtypes")
	public void update(OrderManagement om) {
		if(om!=null){
			omdao.update(om);
			OrderDetail odetail = new OrderDetail();
			odetail.setOrderId(om.getOrderId());
			List<Map> odlist = getOrderDetial(odetail);
			for(Map ood :odlist){
				GoodsInfo goods = new GoodsInfo();
				goods.setGoodsId((Integer)ood.get("goods_id"));
				goods.setGoodsCount((Integer)ood.get("order_number"));
				updateGoodsCount(goods);
			}
		}
	}

	/**
	 * 修改商品库存
	 */

	public void updateGoodsCount(GoodsInfo goods) {
		//修改库存
		if(goods !=null){
			goodsdao.updateCount(goods);
		}
	}

	/**
	 * 获取单个商品详情
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getOrderDetial(OrderDetail od) {
		return oddao.getOrderDetial(od);
	}


	@Override
	public long getCount(OrderManagement om) {
		// TODO Auto-generated method stub
		return omdao.getCount(om);
	}

}
