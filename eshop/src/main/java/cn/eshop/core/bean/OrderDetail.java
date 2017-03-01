package cn.eshop.core.bean;

/**
 * 订单明细类
 * @author ZHUZX
 *
 */
public class OrderDetail {

	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", orderId="
				+ orderId + ", goodsId=" + goodsId + ", orderNumber="
				+ orderNumber + ", orderPrice=" + orderPrice + ", goodsName="
				+ goodsName + ", goodsUrl=" + goodsUrl + "]";
	}
	//订单明细ID
	private Integer orderDetailId;
	//订单ID
	private Integer orderId;
	//商品ID
	private Integer goodsId;
	//订单数量
	private Integer orderNumber;
	//商品价格
	private Double orderPrice;
	
	public String goodsName;

	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsUrl() {
		return goodsUrl;
	}
	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}
	public String goodsUrl;
	
	public Integer getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
}
