package perfectjavaee.chapter13;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/message")
public class MessageEndpoint {

  @Inject
  MessageService messageService;

  @GET
  @Path("/add")
  @Produces(MediaType.APPLICATION_JSON)
  public Message add(@QueryParam("message") String message) {
    return messageService.create(message);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Message> list() {
    return messageService.findAll();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findById(@PathParam("id") Long id) {
    Message message = messageService.findById(id);
    return (message != null)
      ? Response.ok(message).build()
      : Response.status(Response.Status.NOT_FOUND).build();
  }

  @GET
  @Path("/search")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Message> searchWithMessage(@QueryParam("message") String message) {
    return messageService.findByMessage(message);
  }

}
