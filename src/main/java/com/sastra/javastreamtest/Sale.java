package com.sastra.javastreamtest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Sale {
	final public Store store;
	final public Date date;
	final public String customer;
	final public List<Item> items;
	public Sale(Store store, Date date, String customer, List<Item> items) {
		super();
		this.store = store;
		this.date = date;
		this.customer = customer;
		this.items = items;
	}
	
	
	
	public Store getStore() {
		return store;
	}



	public Date getDate() {
		return date;
	}



	public String getCustomer() {
		return customer;
	}



	public List<Item> getItems() {
		return items;
	}



	public Double total(){
	//	System.out.println("total: "+items.stream().mapToDouble(item -> item.price).sum());
		return items.stream().mapToDouble(item -> item.price).sum();
	}
}

enum Store{
	BHATBHATENI, BIGMART, LOCALSHOP
}
