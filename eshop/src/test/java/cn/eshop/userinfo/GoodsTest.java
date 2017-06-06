package cn.eshop.userinfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.eshop.core.service.IGoodsInfoService;
import cn.eshop.core.service.IOrderManagementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application-context.xml")
public class GoodsTest {

	@Autowired
	private IGoodsInfoService service;
	@Autowired
	private IOrderManagementService OMservice;
	/*@Test
	public void list(){
		List<Map> list = service.getlist(null);
		
		for(Map map:list){
			System.out.println(map.get("goods_id"));
			System.out.println(map.get("goods_name"));
		}
		
	}
	@SuppressWarnings("rawtypes")
	@Test
	public void getOrderDetial(){
		OrderDetail od = new OrderDetail();
		od.setOrderId(2);
		List<Map> list =OMservice.getOrderDetial(od);
		for(Map ood :list){
			System.out.println(ood.get("goods_id"));
			System.out.println(ood.get("order_number"));
		}
	}
	*/
	@Test
	public void count(){
		service.getcount(null);
	}
}
