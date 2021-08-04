package ciello.arsenal.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ciello.arsenal.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {}
