package route;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controller.ObstacleController;

@Path("obstacle")
public class ObstacleRoute {

	private ObstacleController controller;
	
	public ObstacleRoute() {
		controller = ObstacleController.getInstance();
	}

	@GET
	public Response getAll() {
		return Response.status(Status.OK).entity(controller.findAll()).build();
	}
	
	@POST
	@Path("/create")
	public Response create(@QueryParam("name")String name,@QueryParam("action")String action) {
		return Response.status(Status.CREATED).entity(controller.create(name,action)).build();
	}
}
