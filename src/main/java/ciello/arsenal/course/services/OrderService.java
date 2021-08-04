package ciello.arsenal.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciello.arsenal.course.repositories.OrderRepository;
import ciello.arsenal.course.entities.Order;

@Service
public class OrderService {
	@Autowired
	private OrderRepository OrderRepository;
	
	public List<Order> findAll() {
		return OrderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> order = OrderRepository.findById(id);
		return order.get();
	}

}
