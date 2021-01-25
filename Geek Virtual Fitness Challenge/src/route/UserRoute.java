package route;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controller.UserController;
import model.User;

@Path("/User")
public class UserRoute {

	private UserController controller;
	
	public UserRoute() {
		controller = UserController.getInstance();
	}
	
	@GET
	@Path("/all")
	public Response getAll() {
		
		return Response.status(Response.Status.OK).entity(UserController.getInstance().findAll()).build();
	}
	
	
	@POST
	@Path("/login")
	public Response login(@QueryParam("username") String username, @QueryParam("password")String password) {
		
		// check if user exist
		// check password
		List<User> users = controller.getUser(username, password);
		if(users.isEmpty())
			return Response.status(Status.FORBIDDEN).entity(username+" "+password).build();
		else 
			return Response.status(Status.OK).entity("Logged").build();
		// return status NotOk
		
	}
	
	/*@Path("/logout")
	public void logout() {
		
	}
	
	@Path("/signup")
	public void signup() {
		
	}
	*/
}
