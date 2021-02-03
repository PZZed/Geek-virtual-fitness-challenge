package route;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controller.ChallengeController;
import model.Challenge;
import model.Mode;

@Path("/challenge")
public class ChallengeRoute {

	private ChallengeController controller;

	public ChallengeRoute() {
		controller = ChallengeController.getInstance();
	}

	@POST
	@Path("/create")
	public Response create(@QueryParam("name") String name, @QueryParam("maxPlayer") int maxPlayer,
			@QueryParam("description") String description, @QueryParam("idSegments") List<Integer> segmentsIDs,
			@QueryParam("url") String url) {
		Challenge chall = controller.create(name, Mode.SOLO, maxPlayer, description, segmentsIDs, url);
		System.out.println(chall);
		return Response.status(Status.OK).entity(chall).build();
	}

	@GET
	@Path("/create/{name}/{maxPlayer}/{description}/{url}")
	public Response createChall(@PathParam("name") String name, @PathParam("maxPlayer") int maxPlayer,
			@PathParam("description") String description, @PathParam("url") String url) {
		// if user is admin

		return Response.status(Status.OK).entity(controller.create(name, Mode.SOLO, maxPlayer, description, null, url))
				.build();
	}

	@GET
	public Response getAll() {
		return Response.status(Status.OK).entity(controller.getAll()).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") long id) {
		return Response.status(Status.OK).entity(controller.getById(id)).build();
	}

	/*********************************************
	 * Modification
	 *****************************************************/
	@POST
	@Path("/{id}/modify/parameters")
	public Response modifyParameters(@PathParam("id") long id, @QueryParam("name") String name,
			@QueryParam("maxPlayer") int maxPlayer, @QueryParam("mode") Mode mode) {
		controller.update(id, name, maxPlayer, mode);

		return Response.status(Status.OK).build();
	}

	@GET
	@Path("/{id}/modify/image/{url}")
	public Response modifyImage(@PathParam("id") long id, @PathParam("url") String url) {
		return Response.status(Status.OK).entity(controller.modifyImage(id, url)).build();
	}

	@GET
	@Path("/{id}/modify/description/{description}")
	public Response modifyDescription(@PathParam("id") long id, @PathParam("description") String desc) {
		return Response.status(Status.OK).entity(controller.modifyDescription(id, desc)).build();
	}

	@GET
	@Path("/{id}/remove/checkpoint/{idc}")
	public Response removeCheckpoint(@PathParam("id") long id, @PathParam("idc") long idcheckpoint) {
		controller.removeCheckpoint(id, idcheckpoint);
		return Response.status(Status.OK).entity(true).build();
	}

	@GET
	@Path("/{id}/segment/add/{idseg}")
	public Response addSegment(@PathParam("id") long id, @PathParam("idseg") long idSeg) {
		Challenge chall = controller.addSegment(id, idSeg);
		return Response.status(Status.OK).build();
	}
}