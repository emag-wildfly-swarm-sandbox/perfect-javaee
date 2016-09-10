package perfectjavaee.chapter13;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
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

}
