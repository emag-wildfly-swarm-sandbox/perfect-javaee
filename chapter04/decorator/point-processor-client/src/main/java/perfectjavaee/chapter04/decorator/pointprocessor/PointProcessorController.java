package perfectjavaee.chapter04.decorator.pointprocessor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/")
public class PointProcessorController {

  @Inject
  private PointProcessor pointProcessor;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public PointResponse confirmPoint(@QueryParam("price") int price) {
    Point point = pointProcessor.process(price);
    return new PointResponse(point.getValue(), point.getExpireDay().toString());
  }

}
