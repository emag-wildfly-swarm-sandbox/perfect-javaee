package perfectjavaee.chapter04.cdi_event;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/")
public class AlertController {

  @Inject
  private AlertProcessor alertProcessor;

  @Inject
  private AlertCache cache;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    return Response.ok(cache.getFifo()).build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response get(@PathParam("id") long id) {
    return Response.ok(cache.get(id)).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response alert(AlertRequest request) {
    alertProcessor.receipt(request.getLevel(), request.getTitle());
    return Response.ok().build();
  }

}
