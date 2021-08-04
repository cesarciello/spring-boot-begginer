package ciello.arsenal.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ciello.arsenal.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
