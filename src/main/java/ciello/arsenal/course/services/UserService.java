package ciello.arsenal.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import ciello.arsenal.course.repositories.UserRepository;
import ciello.arsenal.course.services.exceptions.DatabaseException;
import ciello.arsenal.course.services.exceptions.ResourceNotFoundException;
import ciello.arsenal.course.entities.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User create(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException error) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException error) {
			throw new DatabaseException(error.getMessage());
		}
		
	}
	
	public User update(Long id, User user) {
		try {
			User entity = userRepository.getById(id);
			updateData(entity, user);
			return userRepository.save(entity);
		}catch (EntityNotFoundException error) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
}
