package cn.eshop.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.eshop.core.bean.HistoryInfo;
import cn.eshop.core.dao.HistoryInfoDAO;
import cn.eshop.core.service.IHistoryInfoService;

@Service
@Transactional      //注解开发
public class HistoryInfoServiceImpl implements IHistoryInfoService{

	@Autowired
	private HistoryInfoDAO hdao;
	
	@Override
	public void addHistory(HistoryInfo history) {
		hdao.addHistory(history);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> getHistory(HistoryInfo history){
		return hdao.getHistory(history);
	}

	@Override
	public void updateHistory(HistoryInfo history) {
		hdao.updateHistory(history);
	}
}
