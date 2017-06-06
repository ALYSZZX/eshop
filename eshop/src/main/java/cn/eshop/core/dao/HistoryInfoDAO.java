package cn.eshop.core.dao;

import java.util.List;
import java.util.Map;

import cn.eshop.core.bean.HistoryInfo;


public interface HistoryInfoDAO {

	public void addHistory(HistoryInfo history);
	
	@SuppressWarnings("rawtypes")
	public List<Map> getHistory(HistoryInfo history);
	
	public void updateHistory(HistoryInfo history);
	
	public long getCount(HistoryInfo history);
}