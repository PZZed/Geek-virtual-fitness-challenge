package route;

import java.util.List;

import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import controller.SegmentController;
import controller.StepController;
import model.Segment;
import model.Step;


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
	
	@POST
	@Path("/add")
	public Response create(@QueryParam("src") String src, @QueryParam("dst") String dst) throws SecurityException, IllegalStateException, NamingException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		Segment add = controller.add(src, dst);
		
		return Response.status(Response.Status.OK).entity(add).build();
		//return null;
	}
		
		
}
