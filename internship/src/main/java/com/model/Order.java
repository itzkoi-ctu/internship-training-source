package com.model;

import java.time.LocalDateTime;
import java.util.List;

import com.enums.OrderStatus;
import com.internship.Payable;

public class Order implements Payable{
	private int orderId;
	private String customerName;
	private List<OrderItem> items;
	private LocalDateTime orderDate;
	private OrderStatus orderStatus;
	
	@Override
	public double calculateTotal() {
		double totalPrice = 0;
		for (int i = 1; i< items.size() ; i++) {
			totalPrice += items.get(i).calculateSubTotal();
			
		}
		return totalPrice;
		
	}
	
	
	public void addOrderItem(OrderItem item) {
		if(this.orderStatus == OrderStatus.PAID || orderStatus == OrderStatus.CANCELED) {
			throw new IllegalArgumentException("The order is completed, cannot add more items");
		}
		this.items.add(item);
		System.out.println("Add item successfully.");
	}
	public void checkout(Order order) {
		if (order.orderStatus == OrderStatus.CANCELED) {
			throw new IllegalArgumentException("Order is canceled, cannot checkout.");
		}
		order.orderStatus = OrderStatus.PAID;
		System.out.println("Your order is paid.");
	}
	
	public void cancelOrder(Order order) {
		if(order.orderStatus == OrderStatus.PAID) {
			throw new IllegalArgumentException("The order is paid, cannot cancel it.");
		}
		order.orderStatus = OrderStatus.CANCELED;
		
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public List<OrderItem> getItems() {
		return items;
	}


	public void setItems(List<OrderItem> items) {
		this.items = items;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}


	public OrderStatus getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}


	@Override
	public String toString() {
	    return "Order {" +
	            "orderId='" + orderId + '\'' +
	            ", customerName='" + customerName + '\'' +
	            ", items=" + items +
	            ", orderDate=" + orderDate +
	            ", orderStatus='" + orderStatus + '\'' +
	            ", total=" + calculateTotal() +
	            '}';
	}
	
	
	
	

}
