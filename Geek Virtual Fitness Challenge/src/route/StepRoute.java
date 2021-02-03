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

import controller.StepController;
import model.Step;

@Path("/Step")
public class StepRoute {

private StepController controller;
	
	public StepRoute() {
		controller = StepController.getInstance();
	}
	
	/**get all step */
	@GET
	public Response getAll() {
		return Response.status(Response.Status.OK).entity(StepController.getInstance().findAll()).build();
	}
	
	/**create a step */
	@GET
	@Path("/add/{name}")
	public Response create(@PathParam("name") String name) throws SecurityException, IllegalStateException, NamingException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		Step step = new Step(name);
		return Response.status(Response.Status.OK).entity(controller.add(step)).build();
		
	}
	
	/**delete a step */
	@DELETE
	@Path("/delete")
	public Response delete(@QueryParam("id") int id) {
		Step step = controller.getStep(id);
		controller.remove(id);
		
		
		return Response.status(Response.Status.OK).entity("suppression de :"+step).build();
	}
	
	
}
