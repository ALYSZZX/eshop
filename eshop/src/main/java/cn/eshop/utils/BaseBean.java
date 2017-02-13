package cn.eshop.utils;

public class BaseBean {

	//起始记录数
	private  int start;
	
	//每次查询条数
	private  int length;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
