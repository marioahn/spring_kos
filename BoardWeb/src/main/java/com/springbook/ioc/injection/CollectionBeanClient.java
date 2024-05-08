package com.springbook.ioc.injection;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = // 컨테이너
				new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Map<String, String> addressList = bean.getAddressList();
//		for (String address: addressList) { // 그냥 이대로 하면 value값들 출력해줌
//			System.out.println(address.toString());
//		}
		// for (String key : addressList.keySet()) { // key만 가져오고 싶은 경우!
		// for (String value : addressList.values()) { // value
		for (Map.Entry<String, String> entry: addressList.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ": " + value);
		}
		
		factory.close();
	}
}