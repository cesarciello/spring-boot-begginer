package ciello.arsenal.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ciello.arsenal.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
