package ciello.arsenal.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		User userCreated = userService.create(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userCreated.getId()).toUri();
		return ResponseEntity.created(uri).body(userCreated);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> removeById(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
		var userUpdated = userService.update(id, user);
		return ResponseEntity.ok().body(userUpdated);
	}
}
