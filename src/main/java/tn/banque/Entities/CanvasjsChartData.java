package tn.banque.Entities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class CanvasjsChartData {
 
	static Map<Object,Object> map = null;
	static List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
	static List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
	
	static {
		map = new HashMap<Object,Object>(); map.put("x", 1483209000000L); map.put("y", new Double[] {87.90, 97.80, 87.30, 91.69});dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1485887400000L); map.put("y", new Double[] {91.69, 95.90, 90.69, 92.50});dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1488306600000L); map.put("y", new Double[] {92.50, 96.50, 87.00, 92.00});dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1490985000000L); map.put("y", new Double[] {92.00, 94.00, 85.19, 85.19});dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1493577000000L); map.put("y", new Double[] {85.50, 95.90, 83.00, 91.80});dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1496255400000L); map.put("y", new Double[] {92.00, 96.00, 90.30, 90.80});dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1498847400000L); map.put("y", new Double[] {91.00, 102.00, 90.90, 95.8});dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1501525800000L); map.put("y", new Double[] {96.80, 97.69, 85.90, 87.50});dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1504204200000L); map.put("y", new Double[] {88.59, 96.59, 87.69, 96.09});dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1506796200000L); map.put("y", new Double[] {95.50, 96.00, 83.40, 83.40});dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1509474600000L); map.put("y", new Double[] {83.80, 87.00, 81.09, 85.19});dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("x", 1512066600000L); map.put("y", new Double[] {85.19, 88.69, 82.69, 83.40});dataPoints1.add(map);
 
		list.add(dataPoints1);
	}
 
	public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
		return list;
	}
}   