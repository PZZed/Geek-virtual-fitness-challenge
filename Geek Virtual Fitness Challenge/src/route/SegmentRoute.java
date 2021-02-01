package route;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controller.SegmentController;

@Path("segment")
public class SegmentRoute {

	private SegmentController controller;
	
	public SegmentRoute() {
		controller = SegmentController.getInstance();
	}
	
	@Path("{idDep}/{idArr}")
	public Response getSegment(@PathParam("idDep") long idDepart, @PathParam("idArr")long idArrive) {
		return Response.status(Status.OK).entity(null).build();
	}
	
	@GET
	@Path("{id}/obstacle/add/{ids}")
	public Response addObstacle(@PathParam("id") long id, @PathParam("ids")List<Long> ids) {
		return Response.status(Status.OK).entity(controller.addObstacle(id,ids)).build();
	}
}
