package cn.eshop.userinfo;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.eshop.core.bean.GoodsInfo;
import cn.eshop.core.service.IGoodsInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application-context.xml")
public class GoodsTest {

	@Autowired
	private IGoodsInfoService service;
	
	/*@Test
	public void list(){
		List<Map> list = service.getlist(null);
		
		for(Map map:list){
			System.out.println(map.get("goods_id"));
			System.out.println(map.get("goods_name"));
		}
		
	}
	*/
	
	@Test
	public void count(){
		service.getcount(null);
	}
}
