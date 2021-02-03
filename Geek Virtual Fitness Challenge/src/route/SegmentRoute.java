package route;

import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controller.SegmentController;
import model.Segment;

@Path("/Segment")
public class SegmentRoute {

	private SegmentController controller;

	public SegmentRoute() {
		controller = SegmentController.getInstance();
	}

	@GET
	public Response getAll() {
		return Response.status(Response.Status.OK).entity(controller.findAll()).build();
	}

	@GET
	@Path("/add/{src}/{dst}")
	public Response create(@PathParam("src") String src, @PathParam("dst") String dst)
			throws SecurityException, IllegalStateException, NamingException, NotSupportedException, SystemException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException {
		Segment add = controller.add(src, dst);
		return Response.status(Response.Status.OK).entity(add).build();
	}

	@GET
	@Path("/create/{src}/{dst}")
	public Response create(@PathParam("src") int src, @PathParam("dst") int dst)
			throws SecurityException, IllegalStateException, NamingException, NotSupportedException, SystemException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException {
		return Response.status(Status.OK).entity(controller.create(src, dst)).build();
	}

	@GET
	@Path("/{id}/add/obstacle/{idObstacle}")
	public Response addObstacle(@PathParam("id") long id, @PathParam("idObstacle") long idObstacle) {
		return Response.status(Status.OK).entity(controller.addObstacle(idObstacle, idObstacle)).build();
	}

	@DELETE
	@Path("/delete")
	public Response delete(@QueryParam("id") long id)
			throws SecurityException, IllegalStateException, NamingException, NotSupportedException, SystemException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException {
		// controller.delete(src, dst);
		Segment seg = controller.getSegment(id);
		controller.delete(id);
		return Response.status(Response.Status.OK).entity("Suppression de :" + seg).build();
		// return null;
	}

}
