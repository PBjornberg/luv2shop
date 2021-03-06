package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.CustomerRepository;
import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.luv2code.ecommerce.entity.Customer;
import com.luv2code.ecommerce.entity.Order;
import com.luv2code.ecommerce.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	private CustomerRepository customerRepository;

	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
	// retrieve th order info trom dto
		Order order = purchase.getOrder();

	// generate tracking number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);

	// populate order with orderitems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));

	// populate order with billing address and shipping address
		order.setShippingAddress(purchase.getShippingAddress());;
		order.setBillingingAddress(purchase.getBillingAddress());

	// populate customer with order
		Customer customer = purchase.getCustomer();

		String theEmail = customer.getEmail();
		Customer customerFromDB = customerRepository.findByEmail(theEmail);

		if (customerFromDB != null) {
			customer = customerFromDB;
		}

		customer.add(order);

		customerRepository.save(customer);

		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		// generate a random UUID
		return UUID.randomUUID().toString();
	}
}
