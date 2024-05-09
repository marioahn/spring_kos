package com.springbook.ioc11.injection;

import java.util.Map;
import java.util.Set;

public class CollectionBean {
	private Map<String, String> addressList;
	
	// alt+shift+s -> generates getters, setters 클릭
	// 아. configurations에 설정해둔 bean은 set이구나? get은 아니네. 생각해보면 get일리가 없지 ㅇㅇ;;
	public void setAddressList(Map<String, String> addressList) {
		this.addressList = addressList;
	}
	public Map<String, String> getAddressList() {
		return addressList;
	}
}
