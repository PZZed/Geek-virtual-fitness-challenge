package route;

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

import controller.StepController;
import controller.UserController;
import model.Step;

@Path("/Step")
public class StepRoute {

private StepController controller;
	
	public StepRoute() {
		controller = StepController.getInstance();
	}
	
	
	@GET
	public Response getAll() {
		return Response.status(Response.Status.OK).entity(StepController.getInstance().findAll()).build();
	}
	
	
	@POST
	@Path("/add")
	public Response create(@QueryParam("name") String name) throws SecurityException, IllegalStateException, NamingException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		Step step = new Step(name);
		
		controller.add(step);
		return Response.status(Response.Status.OK).entity(step.getName()).build();
		
	}
	
	
}
