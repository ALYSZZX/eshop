package cn.eshop.core.bean;

import cn.eshop.utils.BaseBean;

/**
 *商品信息
 * @author ZHUZX
 *
 */
public class GoodsInfo extends BaseBean{

	public Integer goodsId;
	
	public String goodsName;
	
	public Double goodsPrice;
	
	private String goodsUrl;
	
	private String goodsDesc;
	
	private String goodsState;
	
	private Integer goodsCount;
	

	private String goodsType;
	

	@Override
	public String toString() {
		return "GoodsInfo [goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", goodsUrl=" + goodsUrl
				+ ", goodsDesc=" + goodsDesc + ", goodsState=" + goodsState
				+ ", goodsCount=" + goodsCount + ", goodsType=" + goodsType
				+ "]";
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}
	
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	
	public String getGoodsType() {
		return goodsType;
	}
	
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsUrl() {
		return goodsUrl;
	}

	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public String getGoodsState() {
		return goodsState;
	}

	public void setGoodsState(String goodsState) {
		this.goodsState = goodsState;
	}

}
