package ciello.arsenal.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ciello.arsenal.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
