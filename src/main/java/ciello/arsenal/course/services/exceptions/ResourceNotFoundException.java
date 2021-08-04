package ciello.arsenal.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super(new StringBuilder().append("Resource not found. Id: ").append(id).toString());
	}

}
