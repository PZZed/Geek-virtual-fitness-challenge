package route;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controller.ObstacleController;

@Path("/obstacle")
public class ObstacleRoute {

	private ObstacleController controller;
	
	public ObstacleRoute() {
		controller = ObstacleController.getInstance();
	}

/** get all obastacle */
	@GET
	public Response getAll() {
		return Response.status(Status.OK).entity(controller.findAll()).build();
	}

/** create obstacle */	
	@GET
	@Path("/create/{name}/{action}")
	public Response create(@PathParam("name")String name,@PathParam("action")String action) {
		return Response.status(Status.CREATED).entity(controller.create(name,action)).build();
	}
}
