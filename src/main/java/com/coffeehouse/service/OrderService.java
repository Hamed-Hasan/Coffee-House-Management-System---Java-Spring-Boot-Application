package com.coffeehouse.service;

import com.coffeehouse.model.Order;
import com.coffeehouse.model.Customer;
import com.coffeehouse.model.Coffee;
import com.coffeehouse.repository.OrderRepository;
import com.coffeehouse.repository.CustomerRepository;
import com.coffeehouse.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CoffeeRepository coffeeRepository;

    // Modified createOrder method with checks for Customer and Coffee existence
    public Order createOrder(Order order) {
        Customer customer = customerRepository.findById(order.getCustomer().getId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));
        Coffee coffee = coffeeRepository.findById(order.getCoffee().getId())
            .orElseThrow(() -> new RuntimeException("Coffee not found"));

        order.setCustomer(customer);
        order.setCoffee(coffee);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setCustomer(orderDetails.getCustomer());
        order.setCoffee(orderDetails.getCoffee());
        order.setOrderDate(orderDetails.getOrderDate());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
