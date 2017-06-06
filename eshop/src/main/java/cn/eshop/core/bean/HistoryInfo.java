package cn.eshop.core.bean;

import java.util.Date;

public class HistoryInfo {

	private Integer historyId;
	private Integer userId;
	private Integer goodsId;
	private Integer historyCount;
	private String historyDate;
	
	@Override
	public String toString() {
		return "HistoryInfo [historyId=" + historyId + ", userId=" + userId
				+ ", goodsId=" + goodsId + ", historyCount=" + historyCount
				+ ", historyDate=" + historyDate + "]";
	}
	public Integer getHistoryId() {
		return historyId;
	}
	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getHistoryCount() {
		return historyCount;
	}
	public void setHistoryCount(Integer historyCount) {
		this.historyCount = historyCount;
	}
	public String getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}
	
}
