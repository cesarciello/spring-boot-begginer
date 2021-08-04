package ciello.arsenal.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ciello.arsenal.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}
