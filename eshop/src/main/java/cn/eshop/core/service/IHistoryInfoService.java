package cn.eshop.core.service;

import java.util.List;
import java.util.Map;

import cn.eshop.core.bean.HistoryInfo;

public interface IHistoryInfoService {

	void addHistory(HistoryInfo history);
	
	@SuppressWarnings("rawtypes")
	List<Map> getHistory(HistoryInfo history);
	
	void updateHistory(HistoryInfo history);
}
