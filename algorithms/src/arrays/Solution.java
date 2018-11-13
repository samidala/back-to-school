package arrays;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Solution {

	private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	public static  int solution(String s) {
	
		Map<String, Integer> durationMap = new HashMap<>();
		Map<String, Long> highestDurationMap = new HashMap<>();
		String records[] = s.split("\n");
		
		for(String rec : records) {
			String[] durationAndPhoneNo = rec.split(",");
			if(durationAndPhoneNo != null && durationAndPhoneNo.length == 2) {
				LocalTime duration = LocalTime.parse(durationAndPhoneNo[0], formatter);
				String phoneNo = durationAndPhoneNo[1];
				int totalBillVal = calculate(duration);
				if(durationMap.containsKey(phoneNo)) {
					int val = durationMap.get(phoneNo);
					durationMap.put(phoneNo,val + totalBillVal);
				}else {
					durationMap.put(phoneNo, totalBillVal);
				}
				long totalDuration = getTotalDuration(duration);
				if(highestDurationMap.containsKey(phoneNo)) {
					long val = highestDurationMap.get(phoneNo);
					highestDurationMap.put(phoneNo,val + totalDuration);
				}else {
					highestDurationMap.put(phoneNo, totalDuration);
				}
				
			}
		}
		
		Set<Entry<String,Long>> set = highestDurationMap.entrySet();
		String maxDurationPhoneNo = "";
		long maxDuration = 0;
		for(Entry<String,Long> e : set) {
			String phoneNo = e.getKey();
			long duration = e.getValue();
			if(duration > maxDuration) {
				maxDuration  = duration;
				maxDurationPhoneNo = phoneNo;
			}
		}
		
		durationMap.remove(maxDurationPhoneNo);
		int totalBill = 0;
		Set<Entry<String,Integer>> set1 = durationMap.entrySet();
		for(Entry<String,Integer> e : set1) {
			int billVal = e.getValue();
			totalBill = totalBill + billVal;
		}
		return totalBill;
	}
	

	
	private static int calculate(LocalTime duration) {
		int mins = duration.getMinute();
		int secs = duration.getSecond();
		int hours = duration.getHour();
		
		if(hours != 0) {
			int totalMins = (hours * 60) + mins +  (secs > 0 ? 1 : 0);
			return totalMins * 150;
		}
		if(mins != 0) {
			int totalMins = mins + (secs > 0 ? 1 : 0);
			if(mins >= 5) {
				return totalMins * 150;
			}else {
				return ((mins * 60) + secs) * 3;
			}
			
			
		}
		if(secs != 0) {
			return secs  * 3;
			
		}
		return 0;
	}
	
	private static long getTotalDuration(LocalTime duration) {
		int mins = duration.getMinute();
		int secs = duration.getHour();
		int hours = duration.getHour();
		if(hours != 0) {
			long totalInSecs = (hours * 60 * 60) + (mins * 60) +  secs;
			return totalInSecs ;
		}
		if(mins != 0) {
			long totalInSecs = (mins * 60) + secs  ;
			return totalInSecs ;
			
		}
		if(secs != 0) {
			return secs;
		}
		return 0;
		
	}
	
	public static void main(String[] args) {	
		String s = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090";
		int val = solution(s);
		System.out.println(val);
	}
	

}
