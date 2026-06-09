package com.internship;

import java.util.ArrayList;
import java.util.List;

import com.enums.OrderStatus;
import com.model.Order;
import com.model.Product;

public class OrderManager implements Managable<Order> {
	List<Order> orders = new ArrayList<>();

	@Override
	public void add(Order order) {
		if(!validateOrder(order)){
			throw new IllegalArgumentException("Invalid order.");
		}
		for (Order o : orders) {
			if(o.getOrderId() == order.getOrderId()) {
				throw new IllegalStateException("Order is already exists."); 
			}
		}
		orders.add(order);
	}

	@Override
	public void deleteById(int id) {
		for (int i = 0; i < orders.size() ; i++) {
			if(orders.get(i).getOrderId() == id) {
				orders.remove(i);
			}
		}
		System.out.println("Delete order successfully.");

	}

	@Override
	public Order findById(int id) {
		for(int i=0; i < orders.size() ; i++) {
			if(orders.get(i).getOrderId() == id) {
				return orders.get(i);
			}
		}
		
		throw new IllegalArgumentException("Order not found with id: " + id);
	}

	@Override
	public List<Order> findAll() {
		return orders;
	}

	
	protected void displayAllOrder() {
		for(Order order : orders) {
			System.out.println(order);
		}
	}
	
	List<Order> filterByStatus (OrderStatus status){
		List<Order> filteredOrders = new ArrayList<>();
		for (Order order : orders) {
			if(order.getOrderStatus() == status) {
				filteredOrders.add(order);
			}
		}
		return filteredOrders;
	}
	
	private boolean validateOrder(Order order) {
		if(order ==  null || order.getCustomerName().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void update(Order item) {
		validateOrder(item);
		for(int i = 0 ; i < orders.size() ; i++) {
			if(orders.get(i).getOrderId() == item.getOrderId()) {
				orders.set(i, item);
			}
		}
		System.out.println("Update order successfully.");
		
	}


}
