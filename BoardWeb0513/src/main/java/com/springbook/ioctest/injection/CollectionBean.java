package com.springbook.ioctest.injection;

import java.util.Set;

public class CollectionBean {

	/* private List<String> addressList; */
	private Set<String> addressList;
	// alt+shift+s => Generates Getters and Settets

	public Set<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<String> addressList) {
		this.addressList = addressList;
	}

}
