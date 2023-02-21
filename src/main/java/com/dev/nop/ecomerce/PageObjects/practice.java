package com.dev.nop.ecomerce.PageObjects;

import java.util.HashMap;
import java.util.Map;

public class practice {

	public static void main(String[] args) {
		
		
		BasePage bp = new BasePage();
		String url_key= bp.getPropertyValue("sit1");
		System.out.println(url_key);
		System.out.println("********");
		Map<String,Integer> empMap = new HashMap<String,Integer>();
		
		empMap.put("Tom", 10000); // key -> keyset() value -> values()
		empMap.put("Peter", 20000);
		empMap.put("Michael", 20000); // 20000 or <20000
		empMap.put("DIGVIJAY", 40000);

		for(String str : empMap.keySet()) {   //  Tom -> false, Tom peter -> false , Tom peter Michael Digvijay
			if(str.equalsIgnoreCase("digvijay")) {
				System.out.println("digvijay sal : " +empMap.get(str));
				break;
			}
			System.out.println(str);
		}
		
		System.out.println("******");
		for(Integer val : empMap.values()) {
			System.out.println(val);
		}

		
	}

}
