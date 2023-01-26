package tn.banque.Dao;


import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import tn.banque.Entities.CanvasjsChartData;
@Service
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}
 
}                     
