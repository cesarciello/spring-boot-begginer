package ciello.arsenal.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ciello.arsenal.course.entities.User;
import ciello.arsenal.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<User> finById(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
