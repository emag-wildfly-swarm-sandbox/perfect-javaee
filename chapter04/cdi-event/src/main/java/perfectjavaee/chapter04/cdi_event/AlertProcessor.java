package perfectjavaee.chapter04.cdi_event;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class AlertProcessor {

  private AtomicLong idCounter = new AtomicLong();

  @Inject
  private Event<Alert> event;

  @Inject
  @Serious
  private Event<Alert> seriousEvent;

  public void receipt(AlertLevel level, String title) {
    Alert alert = new Alert(idCounter.getAndIncrement(), level, title);

    switch (alert.getLevel()) {
      case MINOR:
      case MAJOR:
        event.fire(alert);
        break;
      case SERIOUS:
        seriousEvent.fire(alert);
        break;
      default:
        event.fire(alert);
    }
  }

}
