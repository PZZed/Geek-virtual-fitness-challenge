package route;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controller.UserController;
import model.Challenge;
import model.User;

@Path("/User")
public class UserRoute {

	private UserController controller;

	private static final Response FAILURE = Response.status(Status.CONFLICT).build();
	private static final Response FORBIDDEN = Response.status(Status.FORBIDDEN).build();

	public UserRoute() {
		controller = UserController.getInstance();
	}

	/***
	 * Ok Get all the users.
	 * 
	 * @return All the users.
	 */
	@GET
	public Response getAll() {
		return Response.status(Response.Status.OK).entity(UserController.getInstance().findAll()).build();
	}

	/***
	 * Ok Get an user with its id.
	 * 
	 * @param id
	 * @return a particular user.
	 */
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") long id) {
		User u = UserController.getInstance().getUser(id);
		if (u != null)
			return Response.status(Response.Status.OK).entity(u).build();
		else
			return FAILURE;

	}

	/**
	 * Create an user.
	 * 
	 * @param username the user username.
	 * @param password the user password.
	 * @param mail     The user mail.
	 * @return the user created.
	 */
	@POST
	@Path("/create")
	public Response createUser(@QueryParam("username") String username, @QueryParam("password") String password,
			@QueryParam("mail") String mail) {

		// QueryParam null ?
		username = "uesr";
		password = "pass";
		mail = "etst@test.fr";

		if (username == null || password == null || mail == null)
			return Response.status(Status.NOT_ACCEPTABLE).build();
		User user = controller.create(username, password, mail);

		if (user != null)
			return Response.status(Status.CREATED).entity(user).build();
		else
			return FAILURE;
	}

	@GET
	@Path("/create/{username}/{password}/{mail}")
	public Response create(@PathParam("username") String username, @PathParam("password") String password,
			@PathParam("mail") String mail) {
		User u = controller.create(username, password, mail);
		if (u == null)
			return FAILURE;
		else
			return Response.status(Status.OK).entity(u).build();
	}

	/**
	 * Delete the user.
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/delete/{id}")
	public Response deleteUser(@PathParam("id") long id) {
		UserController.getInstance().delete(id);
		return Response.status(Status.OK).entity(true).build();
	}

	/**
	 * Promote an User to Admin
	 * 
	 * @param id the user id.
	 * @return the user modified.
	 */
	@GET
	@Path("/promote/{id}")
	public Response promoteUser(@PathParam("id") long id) {
		User user = UserController.getInstance().promote(id);
		if (user == null)
			return FAILURE;
		else
			return Response.status(Status.OK).entity(user).build();
	}

	/**
	 * Subscribe a player to a challenge.
	 * 
	 * @param id      of the player
	 * @param idChall of the challenge
	 * @return
	 */
	@GET
	@Path("/{id}/subscribe/{idChall}")
	public Response registerChallenge(@PathParam("id") long id, @PathParam("idChall") long idChall) {
		if (UserController.getInstance().subscribeChallenge(id, idChall))
			return Response.status(Status.OK).build();
		else
			return FAILURE;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}/challenge/registered")
	public Response getRegisteredChallenge(@PathParam("id") long id) {
		List<Challenge> challs = UserController.getInstance().getRegisteredChallenge(id);
		if (challs == null)
			return FAILURE;
		else
			return Response.status(Status.OK).entity(challs).build();
	}

	@GET
	@Path("/login/{username}/{password}")
	public Response login(@PathParam("username") String username, @PathParam("password") String password) {
		if (UserController.getInstance().login(username, password))
			return Response.status(Status.OK).entity("Logged").build();
		else
			return FORBIDDEN;
	}
	
	
}
