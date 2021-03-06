package route;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controller.ThemeController;

@Path("Theme")
public class ThemeRoute {

	private ThemeController controller;
	
	public ThemeRoute() {
		controller = ThemeController.getInstance();
	}
	
	/**get all theme */
	@GET
	public Response getAll() {
		return Response.status(Status.OK).entity(controller.getAll()).build();
	}

	/**vote for a theme */
	@GET
	@Path("/vote/{id}")
	public Response vote(@PathParam("id")long id) {
		return Response.status(Status.OK).entity(controller.vote(id)).build();	
	}

	/**create a theme */
	@GET
	@Path("/create/{desc}")
	public Response create(@PathParam("desc") String desc) {
		return Response.status(Status.OK).entity(controller.create(desc)).build();
	}
}
